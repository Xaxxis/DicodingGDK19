package id.xaxxis.myloader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener {

    public static final String TAG = "ContactApp";

    ListView lvContact;
    ProgressBar progressBar;

    private ContactAdapter mAdapter;

    private final int CONTACT_REQUEST_CODE = 101;
    private final int CALL_REQUEST_CODE = 102;
    private final int CONTACT_LOAD = 101;
    private final int CONTACT_SELECT = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lv_contact);
        progressBar = findViewById(R.id.progress_bar);

        lvContact.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);

        mAdapter = new ContactAdapter(MainActivity.this, null, true);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(this);

        if (PermissionManager.isGranted(this, Manifest.permission.READ_CONTACTS)) {
            getSupportLoaderManager().initLoader(CONTACT_LOAD, null, this);
        }
        PermissionManager.check(this, Manifest.permission.READ_CONTACTS, CONTACT_REQUEST_CODE);
    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        CursorLoader mCursorLoader = null;
        if (i == CONTACT_LOAD) {
            progressBar.setVisibility(View.VISIBLE);

            String[] projectFields = new String[]{
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.Contacts.PHOTO_URI};

            mCursorLoader = new CursorLoader(MainActivity.this, ContactsContract.Contacts.CONTENT_URI,
                    projectFields, ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1",
                    null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "ASC");
        } else if (i == CONTACT_SELECT) {
            String[] phoneProjectionFields = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            mCursorLoader = new CursorLoader(MainActivity.this,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    phoneProjectionFields,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                            ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                            ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE + " AND " +
                            ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER + "=1",
                    new String[]{bundle.getString("id")},
                    null);
        }
        return mCursorLoader;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d(TAG, "LoadFinished");
        if (loader.getId() == CONTACT_LOAD) {
            if (data.getCount() > 0) {
                lvContact.setVisibility(View.VISIBLE);
                mAdapter.swapCursor(data);
            }
            progressBar.setVisibility(View.GONE);
        } else if (loader.getId() == CONTACT_SELECT) {
            String contactNumber = null;
            if (data.moveToFirst()) {
                contactNumber = data.getString(data.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            if (PermissionManager.isGranted(this, Manifest.permission.CALL_PHONE)) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + contactNumber));
                startActivity(dialIntent);
            } else {
                PermissionManager.check(this, Manifest.permission.CALL_PHONE, CALL_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId() == CONTACT_LOAD) {
            progressBar.setVisibility(View.GONE);
            mAdapter.swapCursor(null);
            Log.d(TAG, "LoaderReset");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor = (Cursor) parent.getAdapter().getItem(position);
        long mContactId = cursor.getLong(0);
        Log.d(TAG, "Position : " + position + " " + mContactId);
        getPhoneNumber(String.valueOf(mContactId));
    }

    private void getPhoneNumber(String contactID) {
        Bundle bundle = new Bundle();
        bundle.putString("id", contactID);
        getSupportLoaderManager().restartLoader(CONTACT_SELECT, bundle, this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CONTACT_REQUEST_CODE) {
            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getSupportLoaderManager().initLoader(CONTACT_LOAD, null, this);
                    Toast.makeText(this, "Contact permission diterima", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Contact permission ditolak", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (requestCode == CALL_REQUEST_CODE) {
            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Call permission diterima", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Call permission ditolak", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
