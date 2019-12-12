package com.example.kruunu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class HintFragmentCollectionAdapter extends FragmentStatePagerAdapter {
    public HintFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

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

    @Override
    public int getCount() {
        return HintList.getInstance().getHintList().size();
    }
}
