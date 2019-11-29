package com.example.kruunu;

public class hintList {
    private static final hintList ourInstance = new hintList();

    public static hintList getInstance() {
        return ourInstance;
    }

    private hintList() {
    }
}
