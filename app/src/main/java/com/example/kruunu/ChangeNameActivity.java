package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeNameActivity extends AppCompatActivity {
    static final String KEY = "com.Kruunu";
    static final String NAME = "com.Kruunu.User.Name";
    TextView nimi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_name);
            // load userdata from SharedPreferences to User singleton.
        //getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, User.getInstance().getName()).clear().apply();

        nimi = findViewById(R.id.userNimi);
        nimi.setText(User.getInstance().getName());
        Button nShowDialog = (Button) findViewById(R.id.btnChangeName);
        nShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder nBuilder = new AlertDialog.Builder(ChangeNameActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_name, null);
                final EditText nName = (EditText) mView.findViewById(R.id.editName);
                Button mYes = (Button) mView.findViewById(R.id.btnVaihdaNimi);



                nBuilder.setView(mView);
                final AlertDialog ndialog = nBuilder.create();
                ndialog.show();

                mYes.setOnClickListener (new View.OnClickListener(){
                    EditText editName = findViewById(R.id.editName);
                    @Override
                    public void onClick(View v){
                        /*int length = editName.length();
                        if(length < 3){
                            return;
                        }*/
                        String name = editName.getText().toString();
                        User.getInstance().changeName(name);
                        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, User.getInstance().getName()).apply();
                        Log.d("TAG", "Current name: " + User.getInstance().getName());
                        Intent intent = new Intent(ChangeNameActivity.this, OptionsMenu.class);       // Intent to MainMenu.java activity, putExtra USER_NAME & USER_PIN.
                        startActivity(intent);
                        finish();
                    }
                        //User.getInstance().inputUserDataFirst(name);
                });
            }
        });

    }

}
