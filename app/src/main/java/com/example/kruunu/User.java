package com.example.kruunu;

public class User {

    private String name;
    private int streak;
    private int missed;
    private String password;

    public User (String name, int age) {
        this.name = name;
        this.streak = 0;
        this.missed = 0;
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
}
