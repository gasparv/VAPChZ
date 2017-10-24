package sk.gasparv.cviko5_recyclerview;

/**
 * Created by gaspa on 24.10.2017.
 */

public class KoncertModel {
    //TODO 9: Vytvorit si POJO triedu, ktora bude obsahovat vsetky potrebne data pre zoznam
    public String nazov;
    public String interpret;
    public String datum;
    public KoncertModel(String nazov, String intepret, String datum){
        this.nazov = nazov;
        this.interpret = intepret;
        this.datum = datum;
    }
    public KoncertModel(){}

}
