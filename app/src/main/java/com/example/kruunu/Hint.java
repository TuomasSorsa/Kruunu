package com.example.kruunu;

public class Hint {

    private String title;
    private String content;

    public Hint (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return this.title; }

    public String getContent() {
        return this.content;
    }
}
