package com.example.kruunu;

public class Asetukset {
    private String nimi;

    public Asetukset(String nimi){
        this.nimi = nimi;
    }

    public String toString() {
        return this.nimi;
    }

    public String getNimi(){
        return this.nimi;
    }
}

