package sk.gasparv.cviko2;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start;
    TextView tv_hod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        tv_hod = (TextView) findViewById(R.id.tv_hod);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"dajsdlas",Toast.LENGTH_LONG).show();
                tv_hod.setText(incrementHod(tv_hod.getText().toString()));
            }
        });


    }
    private String incrementHod(String hod)
    {
        int convertHod = Integer.parseInt(hod);
        convertHod++;
        return Integer.toString(convertHod);
    }
}
