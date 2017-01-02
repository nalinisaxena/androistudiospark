package com.example.nalini.navi1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {

    Button btn;


    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_sign_up,
                container, false);

        btn=(Button)rootView.findViewById(R.id.sign_in);


        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent (SignUp.this.getActivity(), DataListActivity.class);
                startActivity(intent);


            }});
        return rootView;
    }
    }


