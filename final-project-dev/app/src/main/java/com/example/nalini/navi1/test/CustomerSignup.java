package com.example.nalini.navi1.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nalini.navi1.Add;
import com.example.nalini.navi1.CustomerInfo;
import com.example.nalini.navi1.R;
import com.example.nalini.navi1.SearchContactActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerSignup extends Fragment {

    Button btn;


    public CustomerSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_customer_signup,
                container, false);

        btn = (Button) rootView.findViewById(R.id.add_id);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerSignup.this.getActivity(), Add.class);

                startActivity(intent);
            }
        });

        return rootView;
    }
    }


