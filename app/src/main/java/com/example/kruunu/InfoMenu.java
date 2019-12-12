package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class InfoMenu extends AppCompatActivity {
    private ViewPager viewPager;
    private HintFragmentCollectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_menu);
        viewPager = findViewById(R.id.pager);
        adapter = new HintFragmentCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
