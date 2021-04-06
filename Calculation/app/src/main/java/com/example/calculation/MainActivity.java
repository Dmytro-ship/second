package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1;
    EditText et2;
    Button plus, minus, multiply, divide;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        result = (TextView) findViewById(R.id.result);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        float number1 = 0;
        float number2 = 0;
        float result1 = 0;
        String operation = "";

        if(TextUtils.isEmpty(et1.getText().toString())
                || TextUtils.isEmpty(et2.getText().toString())){
            return;
        }
        number1 = Float.parseFloat(et1.getText().toString());
        number2 = Float.parseFloat(et2.getText().toString());

        switch (v.getId()) {
            case R.id.plus:
                operation = "+";
                result1 = number1 + number2;
                break;
            case R.id.minus:
                operation = "-";
                result1 = number1 - number2;
                break;
            case R.id.multiply:
                operation = "*";
                result1 = number1 * number2;
                break;
            case R.id.divide:
                operation = "/";
                if (number1 == 0 || number2 == 0) {
                    result1 = 0;

                } else result1 = number1 / number2;
                break;
            default:
                break;
        }
        result.setText(number1 + " " + operation + " " + number2 + " = " + result1);
    }
}