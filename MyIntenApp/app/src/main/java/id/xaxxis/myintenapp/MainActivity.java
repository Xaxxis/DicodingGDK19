package id.xaxxis.myintenapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMoveActivity, btnMoveWithData, btnMoveWithObject, btnDialPhone, btnMoveForResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_acivity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithData = findViewById(R.id.btn_move_with_data);
        btnMoveWithData.setOnClickListener(this);

        btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        btnMoveForResult = findViewById(R.id.btn_move_with_result);
        btnMoveForResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_acivity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
            break;

            case R.id.btn_move_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("DicodingAcademy");
                person.setAge(5);
                person.setEmail("academy@dicoding.com");
                person.setCity("Jakarta");
                Intent moveWithObject = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObject);
                break;

            case R.id.btn_dial_number:
                String number = "+6287782227767";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +number));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_with_result:
                Intent moveActivityForReslut = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveActivityForReslut, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
