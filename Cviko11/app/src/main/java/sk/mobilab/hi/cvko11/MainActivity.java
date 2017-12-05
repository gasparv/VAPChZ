package sk.mobilab.hi.cvko11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sk.mobilab.hi.cvko11.API.apiMethods;
import sk.mobilab.hi.cvko11.Model.User;
import sk.mobilab.hi.cvko11.Tools.ApiConstants;
import sk.mobilab.hi.cvko11.Tools.ApiUtils;
import sk.mobilab.hi.cvko11.Tools.JsonUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView dataview = findViewById(R.id.data);

        Call<JsonArray> call = ApiUtils.getApi().vratPouzivatelov();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                switch(response.code()){
                    case 200:{
                        JsonArray vystup = response.body();

                        //List<Users>
                        // JsonArray

                        List<User> zoznamUserov = JsonUtils.konvertujJsonNaUserov(vystup);

                        JsonObject pouzivatel1 = vystup.get(0).getAsJsonObject();
                        String email = pouzivatel1.get(ApiConstants.user_email).getAsString();
                        dataview.setText(email);
                        break;
                    }
                    case 404:
                    case 403:
                    case 500:{
                        Toast.makeText(MainActivity.this,"epodarilo sa vytiahnut data zo sluzby",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:{
                        Toast.makeText(MainActivity.this,"Neocakavana chyba v baliacom priestore.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
