package sk.mobilab.hi.cvko11.Tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import sk.mobilab.hi.cvko11.Model.Address;
import sk.mobilab.hi.cvko11.Model.User;

/**
 * Created by gaspa on 5.12.2017.
 */

public class JsonUtils {
    public static List<User> konvertujJsonNaUserov(JsonArray jsonZoSluzby){
        List<User> users = new ArrayList<>();

        for(int i=0;i<jsonZoSluzby.size();i++)
        {
            User novyUser = new User();
           JsonObject user = jsonZoSluzby.get(i).getAsJsonObject();
           novyUser.name = user.get("name").getAsString();
            novyUser.email = user.get("email").getAsString();
            novyUser.id = user.get("id").getAsInt();
            novyUser.username = user.get("username").getAsString();

            Address adresa = new Address();
            adresa.city = user.get("address").getAsJsonObject().get("city").getAsString();
            novyUser.adresa = adresa;
            users.add(novyUser);
        }

        return users;
    }
}
