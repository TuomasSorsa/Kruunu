package com.example.kruunu;

public class User {
    private static final User ourInstance = new User();
    private User mainUser;

    private String name;
    private int streak;
    private int missed;
    private String password;

    public static User getInstance() {
        return ourInstance;
    }

    private User() {
        this.name = "";
        this.password = "1234";
        this.missed = 0;
        this.streak = 0;
    }

    public void inputUserDataLoad (String name, String password, int streak, int missed) {
        this.name = name;
        this.streak = streak;
        this.missed = missed;
        this.password = password;
    }

    public void inputUserDataFirst (String name, String password) {
        this.name = name;
        this.streak = 0;
        this.missed = 0;
        this.password = password;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void streakUp() {
        this.streak++;
    }

    public void streakMiss () {
        this.streak = 0;
        this.missed++;
    }

    public int missCheckUp () {
        int i = this.missed;
        this.missed = 0;
        return i;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public boolean checkPassword (String password) {
        if(password.equals(this.password)) {
            return true;
        } else { return false; }
    }

    public String getName() {
        return this.name;
    }

    public int getStreak() {
        return this.streak;
    }

    public int getMissed() {
        return this.missed;
    }

    public String getPassword() {
        return this.password;
    }
}
