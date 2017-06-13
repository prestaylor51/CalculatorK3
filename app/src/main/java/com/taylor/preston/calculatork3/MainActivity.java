package com.taylor.preston.calculatork3;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    public String equation = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleButton(View view) {
        // Get the button based on id
        Button b = (Button)view;
        String bText = b.getText().toString();

        // Concat the string with correct number/operation
        equation += bText;
        updateEquation(view);

    }

    public void clearEquation(View view) {

    }

    /** EVALUATE EQUATION
     *      Finds the output of the edquation and appends the '=' and the output
     *      to the textView.
     *
     *      This code modified from:
     *          https://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
     */
    public void evaluateEquation (View view) {

    }

    /** UPDATE EQUATION
    *   update the textView with the new equation
    *   This code modified from:
    *       https://stackoverflow.com/questions/4873196/dynamically-update-textview-in-android*/
    public void updateEquation(View view) {
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(equation);

    }

}
