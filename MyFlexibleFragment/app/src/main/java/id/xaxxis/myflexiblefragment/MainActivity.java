package id.xaxxis.myflexiblefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentTransaction.add(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName());
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }
}
