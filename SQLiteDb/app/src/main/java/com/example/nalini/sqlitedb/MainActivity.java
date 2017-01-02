package com.example.nalini.sqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etxName,etxNumber,etxEmail,etxCity;
    private Button btnSave,btnView;

    private SqliteDatabaseHalper sqliteDatabaseHalper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etxName=(EditText)findViewById(R.id.etxName);
        etxNumber=(EditText)findViewById(R.id.etxNumber);
        etxEmail=(EditText)findViewById(R.id.etxEmail);
        etxCity=(EditText)findViewById(R.id.etxCity);

          sqliteDatabaseHalper=new SqliteDatabaseHalper(
                MainActivity.this,"studentdetails.db",null,1);

        sqliteDatabaseHalper.getWritableDatabase();


        btnSave=(Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name=etxName.getText().toString();
                String number=etxNumber.getText().toString();
                String email=etxEmail.getText().toString();
                String city=etxCity.getText().toString();

                boolean flag= sqliteDatabaseHalper.addStudentDetails(name,number,email,city);

                if(flag)

                    Toast.makeText(MainActivity.this,"data saved",Toast.LENGTH_SHORT).show();

                else

                    Toast.makeText(MainActivity.this,"failed to save data",Toast.LENGTH_SHORT).show();



            }
        });


        btnView=(Button)findViewById(R.id.btnView);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewDataIntent=new Intent(MainActivity.this,ViewContact.class);
                startActivity(viewDataIntent);
            }
        });
    }
}
