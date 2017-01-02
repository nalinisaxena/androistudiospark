package com.example.nalini.simpleapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText etxInput;
    private Button btnOkay;
    private ImageView image;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxInput=(EditText)findViewById(R.id.etxInput);
        btnOkay=(Button)findViewById(R.id.btnOkay);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Good evening",Toast.LENGTH_LONG).show();


            }
        });

        image=(ImageView)findViewById(R.id.image);
        seekBar=(SeekBar)findViewById(R.id.seekbar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Toast.makeText(MainActivity.this, "seekbar progress"+progress, Toast.LENGTH_SHORT).show();
                image.setRotation(progress);
                etxInput.setText(" "+progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this,"Start",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this,"Stop",Toast.LENGTH_LONG).show();

            }
        });




    }
}
