package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class calculator extends AppCompatActivity implements View.OnClickListener {
    TextView tv_result, tv_solution;

    Button btnClear, btnMod, btnErase, btnDivide, btnMultiply, btnAdd, btnMinus, btnEquals, btnDot, btn0, btn1, btn2, btn3,
            btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        btnClear = findViewById(R.id.button_clear);
        btnErase = findViewById(R.id.button_erase);

        tv_result = findViewById(R.id.txtView_result);
        tv_solution = findViewById(R.id.txtView_solution);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);

        btnAdd = findViewById(R.id.button_plus);
        btnMinus = findViewById(R.id.button_minus);
        btnMultiply= findViewById(R.id.button_multpily);
        btnDivide= findViewById(R.id.button_divide);

        btnDot = findViewById(R.id.button_dot);
        btnEquals = findViewById(R.id.button_equals);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btnEquals.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_calculator_landscape);
        } else {
            setContentView(R.layout.activity_calculator);
        }

        Button button = (Button) v;
        String buttonText = button.getText().toString();
        String data = tv_solution.getText().toString();

//        IF PISLITON ANG C, MA CLEAR
        if (buttonText.equals("C")) {
            tv_solution.setText("");
            tv_result.setText("0");
        }

        if (buttonText.equals("⌫")) { //PARA ERASE
            data = data.substring(0, data.length() - 1);
        }

        if (buttonText.equals("=")) { //IF EQUALS, IPRINT ANG NAA SA LOWER TEXT SA UPPER TEXT
            data = calculateData(data);

            tv_result.setText(data);
            tv_solution.setText("0");
        } else if (buttonText.equals(".")) {
            String last_num = "";
            for (int i = data.length() - 1; i >= 0; i--) {
                if (isOperator(data.charAt(i))) {
                    break;
                }
                last_num += data.charAt(i);
            }
            if(last_num.equals("")){
                data += "0";
                data += buttonText;
            }else if(last_num.contains(".")){
                if(last_num.charAt(0) == '.'){
                    data = data.substring(0,data.length() - 1);
                }
            } else {
                data += buttonText;
            }
            tv_solution.setText(data);
        } else {
            if (!data.isEmpty() && isOperator(data.charAt(data.length() - 1)) && isOperator(buttonText)) {
                data = data.substring(0, data.length() - 1);
            }
            String tempo = data;
            data += buttonText;
            tv_solution.setText(data);
            if(isOperator(buttonText)){
                tv_result.setText(sequentialCalculate(tempo));
            }
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private String calculateData(String data) {
        ArrayList<String> finalData = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }
        Stack<String> stackOp = new Stack<>();
        stackOp.push(finalData.get(0));

        for (int i = 1; i < finalData.size(); i++) {
            if (finalData.get(i).equals("+") || finalData.get(i).equals("-")) {
                stackOp.push(finalData.get(i));
            } else if (finalData.get(i).equals("*")) {

                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(prevNum * nextNum));
            } else if (finalData.get(i).equals("/")) {
                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(prevNum / nextNum));
            } else {
                stackOp.push(finalData.get(i));
            }
        }
        double result = Double.parseDouble(stackOp.get(0));

        for (int i = 1; i < stackOp.size(); i += 2) {
            if (stackOp.get(i).equals("+")) {
                result += Double.parseDouble(stackOp.get(i + 1));
            } else {
                result -= Double.parseDouble(stackOp.get(i + 1));
            }
        }
        return String.valueOf(result);
    }

    private String sequentialCalculate(String data) {
        ArrayList<String> finalData = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }

        Stack<String> stackOp = new Stack<>();
        int start = 0;

        if (isOperator(finalData.get(0))) {
            stackOp.push("0");
        } else {
            stackOp.push(finalData.get(0));
            start = 1;
        }

        for (int i = start; i < finalData.size(); i++) {
            if (isOperator(finalData.get(i))) {
                if (finalData.get(i).equals("+")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum + nextNum));
                } else if (finalData.get(i).equals("-")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum - nextNum));
                } else if (finalData.get(i).equals("*")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum * nextNum));
                } else if (finalData.get(i).equals("/")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum / nextNum));
                }
            } else {
                stackOp.push(finalData.get(i));
            }
        }
        return stackOp.pop();
    }
}