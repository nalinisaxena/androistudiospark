package com.example.nalini.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by nalini on 20/12/16.
 */

public class FragmentThree  extends Fragment {

    private ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {


        View rootView=inflater.inflate(R.layout.fragment_three,container,false);

        imageView=(ImageView)rootView.findViewById(R.id.imgviewThree);

        Bundle bundle=getArguments();

        int i=bundle.getInt("INT_VLAUE_TEST");

        int imagepath= bundle.getInt("IMAGE_PATH");

        imageView.setImageResource(imagepath);

        Toast.makeText(getContext(),"value of i "+i,Toast.LENGTH_SHORT).show();

        return rootView;

    }
}
