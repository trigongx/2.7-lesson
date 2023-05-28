package com.example.a27_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Boolean isOperationClick;
    private Double first,second,result;
    private String operation = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_result);
    }
    public void onNumberClick(View view){
        Button button = (Button) view;
        String number = button.getText().toString();
        setNumber(number);
    }
    public void setNumber(String number){
        if(textView.getText().toString().equals("0")){
            textView.setText(number);
        } else if(isOperationClick){
            textView.setText(number);
        }else {
            textView.append(number);
        }
        isOperationClick = false;
    }
    public void onOperationClick(View view){
        if (view.getId() == R.id.btn_ac){
            textView.setText("0");
            first = 0.0;
            second = 0.0;
        }
        else if (view.getId() == R.id.btn_plus) {
            operation = "+";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        }
        else if (view.getId() == R.id.btn_equal) {
            second = Double.parseDouble(textView.getText().toString());
            if(operation.equals("+")){
                result = first+second;
                textView.setText(cancelDouble(result));
            } else if (operation.equals("-")) {
                result = first-second;
                textView.setText(cancelDouble(result));
            }else if (operation.equals("/")) {
                if(second == 0){
                    textView.setText("На 0 нельзя");
                }else{
                    result = first/second;
                    textView.setText(cancelDouble(result));}
            }else if (operation.equals("*")) {
                result = first*second;
                textView.setText(cancelDouble(result));
            }
            else if (operation.equals("%")) {
                result = (first/100)*second;
                textView.setText(cancelDouble(result));
            }
            isOperationClick = true;

        }
        else if (view.getId() == R.id.btn_minus) {
            operation = "-";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        }
        else if (view.getId() == R.id.btn_multiply) {
            operation = "*";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        }
        else if (view.getId() == R.id.btn_division) {
            operation = "/";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        }
        else if (view.getId() == R.id.btn_percent) {
            operation = "%";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        }

    }
    public String cancelDouble(Double number){
        String text = number.toString();
        if(text.substring(text.length() - 2).equals(".0")){
            return text.substring(0,text.length() - 2);
        }
        else{
            return number.toString();
        }
    }
}