package com.example.kruunu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * HintFragmentCollectionAdapter.java is an adapter for Hint Fragments.
 * @author Jan-Mikael Martin
 * @version 4.20
 * @since 12.12.2019
 */

public class HintFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    /**
     * Constructor for HintFragmentCollection Adapter. Extends FragmentManager.
     * @param fm FragmentManager
     */
    public HintFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem method creates a new HintFragment object and inserts and returns a selected
     * Content String from HintList.
     *
     * @param position Shows which fragment to show.
     * @return hintFragment Object
     */
    @Override
    public Fragment getItem(int position) {
        HintFragment hintFragment = new HintFragment();
        Bundle bundle = new Bundle();
        if (position < HintList.getInstance().getHintList().size()){
            bundle.putString("message", HintList.getInstance().getHintList().get(position).getContent());
            position++;
        }
        hintFragment.setArguments(bundle);
        return hintFragment;
    }

    /**
     *  Shows how many hintFragments there are in ArrayList hintList.
     * @return ArrayList HintList size in integer
     */
    @Override
    public int getCount() {
        return HintList.getInstance().getHintList().size();
    }
}
