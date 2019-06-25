package id.xaxxis.mytestingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvText;
    Button btnSetValue;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_text);
        btnSetValue = findViewById(R.id.btn_set_value);
        btnSetValue.setOnClickListener(this);

        names = new ArrayList<>();
        names.add("Zaki Ibrahim");
        names.add("Narenda Wicaksono");
        names.add("Yoza");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_set_value){
            StringBuilder name = new StringBuilder();
            for (int i = 0; i< names.size(); i++){
                name.append(names.get(i)).append("\n");
            }
            tvText.setText(name.toString());

            try {
                Thread.sleep(3000000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
