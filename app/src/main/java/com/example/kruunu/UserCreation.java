package com.example.kruunu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

public class UserCreation extends AppCompatActivity {
    static final String KEY_IS_FIRST_TIME = "com.Kruunu.first_time";
    static final String KEY = "com.Kruunu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        EditText password = findViewById(R.id.editPassword);
        password.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void inputUserData (View v) {
        EditText editName = findViewById(R.id.editName);
        int length = editName.length();
        if (length < 3) {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Nimessä vähintään 3 kirjainta (a-z, A-Z)");
            dlgAlert.setTitle("ERROR");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return;
        }

        EditText editPIN = findViewById(R.id.editPassword);
        length = editPIN.length();
        if (!(length == 4)) {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("PIN pitää olla 4-numeroinen! (0-9)");
            dlgAlert.setTitle("ERROR");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return;
        }

        boolean firstSetup = true;
        String name = editName.getText().toString(); String pincode = editPIN.getText().toString();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putBoolean(KEY_IS_FIRST_TIME, false).apply();
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra("FIRSTER", firstSetup);
        intent.putExtra("USER.NAME", name);
        intent.putExtra("USER_PIN", pincode);
        startActivity(intent);
        MainActivity.activityA.finish();
        finish();
    }
}
