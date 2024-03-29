package com.example.kruunu;

import java.util.ArrayList;
import java.util.List;

/**
 * HintList.java is a Singleton class which is used to store washing tips inside an ArrayList.
 * HintList is used in HintFragmentCollectionAdapter.java
 *
 * @author Jan-Mikael Martin
 * @version 4.20
 * @since 12.12.2019
 */

public class HintList {
    /** ourInstance*/
    private static final HintList ourInstance = new HintList();
    /** List for storing hints.*/
    private List<Hint> hintList;


    /**
     * Used to getInstance.
     * @return HintList Singleton
     */
    public static HintList getInstance() {
        return ourInstance;
    }

    /**
     * Creates the HintList singleton.
     * Creates new ArrayList and adds washing tips into the ArrayList.
     */
    private HintList() {
        hintList = new ArrayList<>();
        hintList.add(new Hint("Milloin pestä hampaat?", "Pese hampaat huolellisesti 2 kertaa päivässä aamulla ja illalla."));
        hintList.add(new Hint("Mikä värjää hampaat?", "Kaikki asiat, jotka tahraavat valkoisen paidan tahraavat myös hampaat. Esim. Suklaa ja limu."));
        hintList.add(new Hint("Mitä tehdä syömisen jälkeen?", "1-2 Xylitol-purkkapalaa ruokailun jälkeen vähentää happohyökkäyksen kestoa."));
        hintList.add(new Hint("Kannattaako pestä ennen vai jälkeen aamupalan?", "Aamiaisen jälkeen hampaiden peseminen on parasta. Näin tehden saadaan pois sekä hampaille yön aikana kertyneet bakteeripeitteet eli hammasplakki että mahdolliset ruuantähteet aamiaisateriasta."));
        hintList.add(new Hint("Voiko pestä ruokailun jälkeen hampaat?", "Voit pestä hampaat ruokailun jälkeen, jos ruoka ei sisällä hapanta ruokaa. Happo pehmentää hampaan pintaa n. 30 minuuttia eli odota sen verran."));
        hintList.add(new Hint("Miten hampaan välit saa puhtaaksi?", "Hampaan välit saa puhtaaksi hammaslangalla. Useimmat reiät alkavat hammasväleistä."));
        hintList.add(new Hint("Mikä on paras hammasharja?", "Mitä pehmeämpi hammasharja sitä parempi. Mitä kovempi harja sitä enemmän se kuluttaa ikeniä."));

    }

    /**
     * Returns ArrayList hintList
     * @return hintList ArrayList
     */
    public List<Hint> getHintList () {
        return hintList;
    }
}
