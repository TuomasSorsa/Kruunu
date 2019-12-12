package com.example.kruunu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HintFragment extends Fragment {

    private TextView textView;
    public HintFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hint, container, false);
        textView = view.findViewById(R.id.hintTextView);
        String message = getArguments().getString("message");
        textView.setText(message);
        //textView.setText(HintList.getInstance().getHintList().get(i).getContent());
        return view;
    }

}
