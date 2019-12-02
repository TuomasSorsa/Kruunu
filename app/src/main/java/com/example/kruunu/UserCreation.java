package com.example.kruunu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

public class UserCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        EditText password = (EditText) findViewById(R.id.editPassword);
        password.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void inputUserData (View v) {
        /*for() {
            if () {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Nimessä saa olla vain kirjaimia! (a-z, A-Z)");
                dlgAlert.setTitle("ERROR");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        }*/
    }
}
