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
    /** Hint object's title String*/
    private String title;
    /** Hint object's hint content String */
    private String content;

    /**
     *  Constructor for Hint class.
     *
     * @param title Hint's title.
     * @param content Content of hint.
     */
    public Hint (String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     *  Returns Hint object's title.
     * @return Hint title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns Hint object's content String.
     * @return Hint content
     */

    public String getContent() {
        return this.content;
    }
}
