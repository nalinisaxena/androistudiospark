package com.example.nalini.navi1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerInfo extends Fragment {

    Button btn;


    public CustomerInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_customer_info,
                container, false);

        btn = (Button) rootView.findViewById(R.id.click_on);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerInfo.this.getActivity(), SearchContactActivity.class);

                startActivity(intent);
            }
        });

        return rootView;
    }

}
