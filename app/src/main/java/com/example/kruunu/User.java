package com.example.kruunu;

/**
 * Singleton User is used to access / use the Userdata globally.
 * When the app starts, Userdata is loaded from SharedPreferences
 * and inputted to User singleton, where it can be used for number of methods.
 */
public class User {
    /** ourInstance*/
    private static final User ourInstance = new User();
    /** Username*/
    private String name;
    /** User brushing streak value*/
    private int streak;
    /** User missed brushes value*/
    private int missed;
    /** User PIN code (4 numbers)*/
    private String password;

    /**
     * Used to getInstance and use all the methods.
     * @return User singleton getInstance
     */
    public static User getInstance() {
        return ourInstance;
    }

    /**
     * Creates the User singleton.
     * Inputs temporary default values.
     */
    private User() {
        this.name = "";
        this.password = "1234";
        this.missed = 0;
        this.streak = 0;
    }

    /**
     * Constructor used to set Userdata from SharedPreferences.
     * Always used after the first time setup.
     *
     * @param name Name from SharedPreferences.
     * @param password PIN from SharedPreferences.
     * @param streak User brushing streak from SharedPreferences.
     * @param missed User missed brushes from SharedPreferences.
     */
    public void inputUserDataLoad (String name, String password, int streak, int missed) {
        this.name = name;
        this.streak = streak;
        this.missed = missed;
        this.password = password;
    }

    /**
     * Constructor used to set Username & PIN from Intent extras.
     * Used only in first time setup.
     * Streak and Missed are set to default 0.
     *
     * @param name Name from first time setup Intent.
     * @param password PIN from first time setup Intent.
     */
    public void inputUserDataFirst (String name, String password) {
        this.name = name;
        this.streak = 0;
        this.missed = 0;
        this.password = password;
    }

    /**
     * Used to change Username.
     * Used only in OptionsMenu.
     *
     * @param newName Name inputted in EditText
     */
    public void changeName(String newName) {
        this.name = newName;
    }

    /**
     * Brushing streak goes up by one.
     * Used in PesuMenu after every brushing.
     */
    public void streakUp() {
        this.streak++;
    }

    /**
     *
     */
    public void streakMiss () {
        this.streak = 0;
        this.missed++;
    }

    /**
     *
     * @return
     */
    public int missCheckUp () {
        int i = this.missed;
        this.missed = 0;
        return i;
    }

    /**
     *
     * @param password
     */
    public void setPassword (String password) {
        this.password = password;
    }

    /**
     * Checks if inputted password is correct (same as User PIN).
     * Used only when deleting all app data in OptionsMenu (SharedPreferences).
     *
     * @param password Inputted PIN.
     * @return Returns the User PIN.
     */
    public boolean checkPassword (String password) {
        if(password.equals(this.password)) {
            return true;
        } else { return false; }
    }

    /**
     * Gets User this.name.
     *
     * @return Returns Username.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets User this.streak.
     *
     * @return Returns User brushing streak.
     */
    public int getStreak() {
        return this.streak;
    }

    /**
     * Gets User this.misses.
     *
     * @return Returns User missed brushes value.
     */
    public int getMissed() {
        return this.missed;
    }

    /**
     * Gets User this.password.
     *
     * @return Returns User PIN.
     */
    public String getPassword() {
        return this.password;
    }
}
