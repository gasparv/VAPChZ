package sk.mobilab.hi.cvko11.API;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gaspa on 5.12.2017.
 */

public interface apiMethods {
    @GET ("/users")
    Call<JsonArray> vratPouzivatelov();


    @GET ("/users/{id}")
    Call<JsonObject> vratPouzivatela(@Path("id") int idPouzivatela);
}
