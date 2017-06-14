package com.taylor.preston.calculatork3;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public String equation = "";
    public String opnd1 = "";
    public String opnd2 = "";
    public String operator = "";

    public Integer result = 0;
    public Integer remainder = 0;

    private boolean isOp = false;
    private boolean isEval = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleButton(View view) {
        if (!isEval) {
            // Get the button based on id
            Button b = (Button)view;
            String bText = b.getText().toString();

            // If on first operand
            if (!isOp) {
                opnd1 += bText;
            }
            else {
                opnd2 += bText;
            }

            // Concat the string with correct number/operation

                equation += bText;
                updateEquation(view);
            }

    }

    public void handleOperator(View view) {

        if (!isOp) {
            // Get the button based on id
            Button b = (Button) view;
            String bText = b.getText().toString();
            operator = bText;

            equation += " " + bText + " ";

            updateEquation(view);

            isOp = true;
        }

    }

    /** EVALUATE EQUATION
     *      Finds the output of the edquation and appends the '=' and the output
     *      to the textView.
     *
     *      This code modified from:
     *          https://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
     */
    public void evaluateEquation (View view){
        if (!isEval) {
            switch (operator) {
                case "+":
                    result = Integer.parseInt(opnd1) + Integer.parseInt(opnd2);
                    break;
                case "-":
                    result = Integer.parseInt(opnd1) - Integer.parseInt(opnd2);
                    break;
                case "×":
                    result = Integer.parseInt(opnd1) * Integer.parseInt(opnd2);
                    break;
                case "÷":
                    result = Integer.parseInt(opnd1) / Integer.parseInt(opnd2);
                    remainder = Integer.parseInt(opnd1) % Integer.parseInt(opnd2);
                    break;
                default:
                    result = 333;
                    break;
            }


            equation += " = ";
            equation += Integer.toString(result);

            if (remainder > 0) {
                equation += " r " + Integer.toString(remainder);
            }
            updateEquation(view);
        }
        isEval = true;
    }

    /** UPDATE EQUATION
    *   update the textView with the new equation
    *   This code modified from:
    *       https://stackoverflow.com/questions/4873196/dynamically-update-textview-in-android*/
    public void updateEquation(View view) {
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(equation);

    }

    public void clearEquation(View view) {

        // Clear all variables
        equation = "";
        opnd1 = "";
        opnd2 = "";
        operator = "";

        result = 0;
        remainder = 0;

        isEval = false;
        isOp = false;

        updateEquation(view);

    }

}
