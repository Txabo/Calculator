package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.operations.Operations;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView errorTextView, operationTextView;
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private Operations operations;
    private boolean restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operations operations = new Operations();
        errorTextView = findViewById(R.id.errorTextView);
        operationTextView = findViewById(R.id.inputTextView);
        restart = false;

        buttons.add(findViewById(R.id.button1));
        buttons.add(findViewById(R.id.button2));
        buttons.add(findViewById(R.id.button3));
        buttons.add(findViewById(R.id.button4));
        buttons.add(findViewById(R.id.button5));
        buttons.add(findViewById(R.id.button6));
        buttons.add(findViewById(R.id.button7));
        buttons.add(findViewById(R.id.button8));
        buttons.add(findViewById(R.id.button9));
        buttons.add(findViewById(R.id.button10));
        buttons.add(findViewById(R.id.button11));
        buttons.add(findViewById(R.id.button12));
        buttons.add(findViewById(R.id.button13));

        for (int i = 0; i < buttons.size(); i++) {
            Button element = buttons.get(i);
            element.setOnClickListener(this);
            buttons.set(i,element);
        }
    }

    @Override
    public void onClick(View view) {

        if (restart) {
            operationTextView.setText("");
            errorTextView.setVisibility(View.GONE);
            restart = false;
        } else {
            doClick(view);
        }

    }

    public void doClick(View view) {

        Button clickedButton = (Button) view;
        String clickedButtonText = clickedButton.getText().toString();

        if  ((clickedButtonText.equalsIgnoreCase(getString(R.string.button_equal)))) {
            showResult(clickedButton);
        } else {
            addDigit(clickedButton);
        }

    }

    public void showResult(Button clickedButton) {

//        try {
            operationTextView.setText(operations.doOperation(operationTextView.getText().toString()));
            restart = true;
//        } catch (Exception e){
//            errorTextView.setVisibility(View.VISIBLE);
//        } finally {
//            restart = true;
//        }
    }

    public void addDigit(Button clickedButton) {
        String buttonText = clickedButton.getText().toString();
        String operationText = operationTextView.getText().toString();
        operationTextView.setText(operationText + buttonText);
    }
}