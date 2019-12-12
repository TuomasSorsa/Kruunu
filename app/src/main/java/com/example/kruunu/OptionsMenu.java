package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * OptionsMenu.java is Kruunu's OptionsMenu where all the app's Options are accessible.
 * OptionsMenu has ListView that lists all options activities: ChangeNameActivity, DelUserInfoActivity.
 *
 * @author Vertti Huovila
 * @version 1.01
 * @since 12.12.2019
 */
public class OptionsMenu extends AppCompatActivity {
    static Activity activityC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        ListView lv = findViewById(R.id.asetukset);

        lv.setAdapter(new ArrayAdapter<Asetukset>(
                this,  //context (activity instance)
                android.R.layout.simple_list_item_1, //XML item layout
                Singleton.getInstance().getAsetukset()) //array of data
        );


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             *
             * @param adapterView : The AdapterView where the click happened.
             * @param view The view within the AdapterView that was clicked (this will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that was clicked.
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(OptionsMenu.this, ChangeFontActivity.class);
                    startActivity(intent);

                }
                if(position == 1){
                    Intent intent = new Intent(OptionsMenu.this, ChangeNameActivity.class);
                    startActivity(intent);
                }
                /*Intent nextActivity = new Intent(MainActivity.this, DisplayMessageActivity.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);*/
            }
        });
    }
    public static Activity getInstance(){ // Method says it's never used, but this let's you use MainActivity.activityA.finish in other activities();
        return activityC;
    }
}