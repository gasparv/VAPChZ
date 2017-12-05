package sk.mobilab.hi.cvko11.Tools;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sk.mobilab.hi.cvko11.API.apiMethods;

/**
 * Created by gaspa on 5.12.2017.
 */

public final class ApiUtils {
    private static Retrofit sRetrofit;
    private static apiMethods sApi;

    private static String baseUrl = "https://jsonplaceholder.typicode.com";

    private static Retrofit getRetrofitContext(){
        if(sRetrofit == null)
            sRetrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        return sRetrofit;
    }

    public static apiMethods getApi(){
        if(sApi == null)
            sApi = getRetrofitContext().create(apiMethods.class);
        return sApi;
    }

}
