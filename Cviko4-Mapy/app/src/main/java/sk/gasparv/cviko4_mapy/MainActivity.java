package sk.gasparv.cviko4_mapy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnOtvorMapu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOtvorMapu = (Button)findViewById(R.id.btn_otvorMapu);

        btnOtvorMapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: OK Pridaj Intent na prechod medzi aktivitami
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
