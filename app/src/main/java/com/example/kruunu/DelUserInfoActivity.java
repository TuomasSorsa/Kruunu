package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * DelUserActivity.java is used to delete userInformation
 * * @author Vertti Huovila
 *  * @version 1.01
 *  * @since 12.12.2019
 */
public class DelUserInfoActivity extends AppCompatActivity {
    static final String KEY = "com.Kruunu";
    static Activity activityD;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_user_info);

        Button mShowDialog = (Button) findViewById(R.id.btnDelUser);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            /**
             * OnClick used after user has inputed password
             * Opens AlertDialog that asks user if he really wants to delete sharedPreferences
             * @param view the view within button was click
             */
            @Override
            public void onClick(View view) {
                EditText editPIN = findViewById(R.id.editSalasana);
                String pincode = editPIN.getText().toString();
                if(!pincode.equals(User.getInstance().getPassword())) {
                    Toast.makeText(DelUserInfoActivity.this, "Väärä salasana!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(DelUserInfoActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialog_question, null);
                    Button mYes = (Button) mView.findViewById(R.id.btnYes);

                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();
                    mYes.setOnClickListener (new View.OnClickListener(){
                        @Override
                        /**
                         * Onclick used to delete sharedpreferences and to start MainActivity
                         */
                        public void onClick(View v){
                            dialog.dismiss();
                            SharedPreferences settings = getSharedPreferences(KEY, Context.MODE_PRIVATE);
                            settings.edit().clear().commit();
                            Intent i = new Intent(DelUserInfoActivity.this,MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            finish();
                            startActivity(i);
                        }


                    });
                }
                }

    });

    }

    /**
     * method enHalua is used to go back to OptionsMenu
     * @param view View The view within button was clicked
     */
    public void enHalua(View view){
        Intent previousActivity = new Intent(DelUserInfoActivity.this, OptionsMenu.class);
        startActivity(previousActivity);
    }
}
