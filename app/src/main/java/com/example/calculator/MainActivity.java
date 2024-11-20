package com.example.calculator;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button_one, button_two, button_three, button_four, button_five, button_six,
            button_seven, button_eight, button_nine, button_zero, button_division, button_multiplication,
            button_minus, button_plus, button_equal, button_dot;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_one = findViewById(R.id.btn_one);
        button_two = findViewById(R.id.btn_two);
        button_three = findViewById(R.id.btn_three);
        button_four = findViewById(R.id.btn_four);
        button_five = findViewById(R.id.btn_five);
        button_six = findViewById(R.id.btn_six);
        button_seven = findViewById(R.id.btn_seven);
        button_eight = findViewById(R.id.btn_eight);
        button_nine = findViewById(R.id.btn_nine);
        button_zero = findViewById(R.id.btn_zero);
        button_division = findViewById(R.id.btn_division);
        button_multiplication = findViewById(R.id.btn_multiplication);
        button_minus= findViewById(R.id.btn_minus);
        button_plus = findViewById(R.id.btn_plus);
        button_dot = findViewById(R.id.btn_dot);
        button_equal = findViewById(R.id.btn_equal);
        editText = findViewById(R.id.et);
        editText.setGravity(Gravity.END);
        editText.setGravity(Gravity.BOTTOM);

    }

}