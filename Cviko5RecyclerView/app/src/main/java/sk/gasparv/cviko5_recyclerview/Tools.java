package sk.gasparv.cviko5_recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaspa on 24.10.2017.
 */

public class Tools {
//TODO:10 - Vytvofrenie metody na naplnenie obsahu modelu
    public static List<KoncertModel> stiahniKoncerty()
    {
        List<KoncertModel> result = new ArrayList<>();

        for(int i=0;i<50;i++)
        {
            result.add(new KoncertModel(
                    "Nazov " + Integer.toString(i),
                    "Interpret " + Integer.toString(i),
                    "Datum " + Integer.toString(i)
                    ));
        }
        return result;
    }

}
