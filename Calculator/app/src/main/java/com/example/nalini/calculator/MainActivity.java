package com.example.nalini.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnAdd, btnSub, btnDiv, btnMulti,
            btnDot, btnEquals, btnZero;

    private TextView txtAnswer, txtResult;

    private int operand1, operand2, operation, result;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button) findViewById(R.id.btnOne);

        btnTwo = (Button) findViewById(R.id.btnTwo);

        btnThree = (Button) findViewById(R.id.btnThree);

        btnFour = (Button) findViewById(R.id.btnFour);

        btnFive = (Button) findViewById(R.id.btnFive);

        btnSix = (Button) findViewById(R.id.btnSix);

        btnSeven = (Button) findViewById(R.id.btnSeven);

        btnEight = (Button) findViewById(R.id.btnEight);

        btnNine = (Button) findViewById(R.id.btnNine);

        btnZero = (Button) findViewById(R.id.btnZero);

        btnDot = (Button) findViewById(R.id.btnDot);


        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnSub = (Button) findViewById(R.id.btnSub);

        btnMulti = (Button) findViewById(R.id.btnMulti);

        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnEquals = (Button) findViewById(R.id.btnEquals);

        txtAnswer = (TextView) findViewById(R.id.textView1);

        txtResult = (TextView) findViewById(R.id.textView2);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "1");


            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "2");

            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "3");

            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "4");

            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "5");

            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "6");

            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "7");

            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "9");

            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + "0");

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText() + ".");

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempop1 = txtAnswer.getText().toString();

                operand1 = Integer.parseInt(tempop1);

                txtAnswer.setText("0");

                operation = 1;
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tempop1 = txtAnswer.getText().toString();

                operand1 = Integer.parseInt(tempop1);

                txtAnswer.setText("0");

                operation = 2;

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tempop1 = txtAnswer.getText().toString();

                operand1 = Integer.parseInt(tempop1);

                txtAnswer.setText("0");

                operation = 3;
            }
        });


        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tempop1 = txtAnswer.getText().toString();

                operand1 = Integer.parseInt(tempop1);

                txtAnswer.setText("0");

                operation = 4;
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temop2 = txtAnswer.getText().toString();

                operand2 = Integer.parseInt(temop2);

                if (operation == 1) {
                    result = operand1 + operand2;


                    txtResult.setText(" " + result);

                    txtAnswer.setText(operand1 + "+" + operand2);

                } else if (operation == 2) {
                    result = operand1 - operand2;


                    txtResult.setText(" " + result);

                    txtAnswer.setText(operand1 + "-" + operand2);
                } else if (operation == 3) {
                    result = operand1 * operand2;


                    txtResult.setText(" " + result);

                    txtAnswer.setText(operand1 + "x" + operand2);
                } else if (operation == 4) {
                    result = operand1 / operand2;


                    txtResult.setText(" " + result);

                    txtAnswer.setText(operand1 + "/" + operand2);
                }

            }

        });
    }
}
