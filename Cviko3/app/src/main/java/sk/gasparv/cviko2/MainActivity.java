package sk.gasparv.cviko2;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sk.gasparv.cviko2.Tools.Constants;

public class MainActivity extends AppCompatActivity {

    Button btn_start;
    Button btn_stop;
    TextView tv_hod;
    Handler handler;
    Thread thread;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                tv_hod.setText(incrementHod(tv_hod.getText().toString()));
                handler.postDelayed(this,1000);
            }
        };
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
        thread.interrupt();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        tv_hod = (TextView) findViewById(R.id.tv_hod);

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                Intent intent = new Intent(MainActivity.this,ResumeActivity.class);
                intent.putExtra(Constants.INTENT_DATA_HODINA, tv_hod.getText().toString());
                startActivity(intent);
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"dajsdlas",Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable,1000);
                //tv_hod.setText(incrementHod(tv_hod.getText().toString()));
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
