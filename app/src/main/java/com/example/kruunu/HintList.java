package com.example.kruunu;

import java.util.ArrayList;
import java.util.List;

public class HintList {
    private static final HintList ourInstance = new HintList();
    private List<Hint> hintList;

    public static HintList getInstance() {
        return ourInstance;
    }

    private HintList() {
        hintList = new ArrayList<>();
    }

    public List<Hint> getHintList () {
        return hintList;
    }
}
