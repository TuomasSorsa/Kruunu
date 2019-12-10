package com.example.kruunu;

import java.util.ArrayList;

public class Singleton {
    private static final Singleton ourInstance = new Singleton();
    private ArrayList<Asetukset> asetukset;
    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        asetukset = new ArrayList<Asetukset>();
        asetukset.add(new Asetukset("Vaihda fontti"));
        asetukset.add(new Asetukset("Vaihda nimi"));
        asetukset.add(new Asetukset("Poista tiedot"));
    }
    public ArrayList<Asetukset> getAsetukset() {
        return asetukset;
    }
    public Asetukset getAsetukset(int i){
        return asetukset.get(i);
    }
}