package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

/**
 * InfoMenu is the java code for the InfoMenu Activity.
 *
 * @author Jan-Mikael Martin
 * @version 4.20
 * @since 12.12.2019
 */

public class InfoMenu extends AppCompatActivity {
    /** ViewPager*/
    private ViewPager viewPager;
    /** HintFragmentCollectionAdapter*/
    private HintFragmentCollectionAdapter adapter;

    /**
     * After the activity opens the FragmentManager interacts with fragments associated with this activity.
     * Adapter is set into viewPager.
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_menu);
        viewPager = findViewById(R.id.pager);
        adapter = new HintFragmentCollectionAdapter(getSupportFragmentManager()); // Gets Frag
        viewPager.setAdapter(adapter);
    }
}
