package com.example.calculator;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    Button button_one,button_two, button_three, button_four, button_five, button_six, button_seven, button_eight, button_nine,
            button_zero, button_dot, button_multiplication, button_divisible, button_minus, button_plus;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.et);

        buttonListeners();

    }
    private void buttonListeners() {
        int[] numberButtons = {R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four,
                R.id.btn_five, R.id.btn_six, R.id.btn_seven, R.id.btn_eight, R.id.btn_nine, R.id.btn_zero};
        for (int id : numberButtons) {
            findViewById(id).setOnClickListener(this::onNumberCLick);
        }

        findViewById(R.id.btn_division).setOnClickListener(v -> onOperatorClick("/"));
        findViewById(R.id.btn_plus).setOnClickListener(v -> onOperatorClick("+"));
        findViewById(R.id.btn_minus).setOnClickListener(v -> onOperatorClick("-"));
        findViewById(R.id.btn_multiplication).setOnClickListener(v -> onOperatorClick("*"));
        findViewById(R.id.btn_equal).setOnClickListener(v -> onEqualClick());
        findViewById(R.id.btn_dot).setOnClickListener(v -> onDotClick());
    }

    private void onNumberCLick(View view) {
        Button button = (Button) view;
        if (isOperatorPressed) {
            currentInput = "";
            isOperatorPressed = false;
        }
        currentInput += button.getText().toString();
        editText.setText(currentInput);

    }
    private void onOperatorClick(String st) {
        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput);
        }

        operator = st;
        isOperatorPressed = true;
    }

    private void onEqualClick() {
        if (operator.isEmpty() || currentInput.isEmpty()) {
            return;
        }

        double secondOperand = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    editText.setText("Ошибка");
                    return;
                }
                break;
        }
        editText.setText(String.valueOf(result));
        firstOperand = result;
        currentInput = String.valueOf(result);
        operator = "";
    }

    private void onDotClick(){
        if (!currentInput.contains(".")) {
            currentInput += ".";
            editText.setText(currentInput);
        }
    }
}