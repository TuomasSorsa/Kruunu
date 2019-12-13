package com.example.kruunu;

/**
 * HintList.java is a Singleton class which is used to store washing tips inside an ArrayList.
 * HintList is used in HintFragmentCollectionAdapter.java
 *
 * @author Jan-Mikael Martin
 * @version 4.20
 * @since 12.12.2019
 */

public class Hint {

    private String title;
    private String content;

    public Hint (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
