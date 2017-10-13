package sk.gasparv.cviko2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import sk.gasparv.cviko2.Tools.Constants;

public class ResumeActivity extends AppCompatActivity {

    TextView tv_hodiny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        tv_hodiny = (TextView) findViewById(R.id.tv_resume_hodiny);
        Intent intent = getIntent();
        String hodiny = intent.getStringExtra(Constants.INTENT_DATA_HODINA);
        tv_hodiny.setText(hodiny);
    }
}
