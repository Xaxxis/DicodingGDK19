package id.xaxxis.myunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    EditText edtWidth, edtHeight, edtLength;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void showVolume(MainModel model) {
        tvResult.setText(String.valueOf(model.getVolume()));

    }

    @Override
    public void onClick(View view) {
        String length = edtLength.getText().toString().trim();
        String width = edtWidth.getText().toString().trim();
        String height = edtHeight.getText().toString().trim();

        boolean isEmptyFields = false;

        if(TextUtils.isEmpty(length)){
            isEmptyFields = true;
            edtLength.setError("Field ini tidak boleh kosong");
        }

        if(TextUtils.isEmpty(width)){
            isEmptyFields = true;
            edtWidth.setError("Field ini tidak boleh kosong");
        }

        if(TextUtils.isEmpty(height)){
            isEmptyFields = true;
            edtHeight.setError("Field ini tidak boleh kosong");
        }

        if(!isEmptyFields){
            double l = Double.parseDouble(length);
            double w = Double.parseDouble(width);
            double h = Double.parseDouble(height);

            final MainPresenter presenter = new MainPresenter(this);
            presenter.calculateVolume(l,w,h);
        }
    }
}
