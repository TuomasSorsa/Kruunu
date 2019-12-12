package com.example.kruunu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeNameActivity extends AppCompatActivity {
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    /** SharedPreferences tag. */
    static final String NAME = "com.Kruunu.User.Name";
    /** TextView nimi used for findView*/
    TextView nimi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_name);
            // load userdata from SharedPreferences to User singleton.
        //getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, User.getInstance().getName()).clear().apply();

        nimi = findViewById(R.id.userNimi);
        nimi.setText(User.getInstance().getName());
    }

    /**
     * changeName is used to change userName
     * @param v the view within button was click
     */
    public void changeName (View v) {
        EditText editName = findViewById(R.id.editName);
        int length = editName.length();     // inputted username length
        if (length < 3) {                   // if username is less than 3 characters, it sends a AlertDialog.
            androidx.appcompat.app.AlertDialog.Builder dlgAlert  = new androidx.appcompat.app.AlertDialog.Builder(this);
            dlgAlert.setMessage("Nimessä vähintään 3 kirjainta (a-z, A-Z)");
            dlgAlert.setTitle("ERROR");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return; // Returns to let user reinput the userdata.
        }
        // If both username and PIN pass, the data is added to User and stored in SharedPreferences.
        String name = editName.getText().toString();         // get the inserted data to String format.
        User.getInstance().changeName(name);
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, User.getInstance().getName()).apply();// Input name and PIN from Intent to User singleton (Streak and Misses are default value 0).
        Intent intent = new Intent(this, OptionsMenu.class);       // Intent to MainMenu.java activity, putExtra USER_NAME & USER_PIN.
        startActivity(intent);
        MainActivity.activityA.finish();    // finish MainActivity.java activity.
        finish();
    }

}
