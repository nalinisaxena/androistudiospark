package com.example.nalini.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nalini on 20/12/16.
 */

public class FragmentOne extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

       View rootView= inflater.inflate(R.layout.fragment_one,container,false);
        return rootView;


    }
}
