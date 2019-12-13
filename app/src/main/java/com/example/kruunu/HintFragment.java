package com.example.kruunu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * @author Jan-Mikael Martin
 * @version 4.20
 * @since 12.12.2019
 */
public class HintFragment extends Fragment {
    /** textView*/
    private TextView textView;

    /**
     * Empty public constructor
     */
    public HintFragment() {
        // Required empty public constructor
    }

    /**
     * This is the textView fragment for viewPager.
     * Gets the current String from Bundle that is set in HintFragmentCollectionAdapter.
     * @return fragment_hint layout view
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hint, container, false);
        textView = view.findViewById(R.id.hintTextView);
        String message = getArguments().getString("message");
        textView.setText(message);
        return view;
    }

}
