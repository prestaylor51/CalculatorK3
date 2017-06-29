package com.taylor.preston.calculatork3;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


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



        LinearLayoutManager layoutMangager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView imageList = (RecyclerView) findViewById(R.id.recyclerview);
        imageList.setLayoutManager(layoutMangager);

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.one);

        imageList.addView(image);

//        final Button button = (Button) findViewById(R.id.button0);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//
//
//                // currentContext.startActivity(activityChangeIntent);
//
//
//            }
//        });
    }

    /** HANDLE BUTTON
     *      Is called when any of the numbers are pressed
     *
     * @param view
     */
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

//            addImage(view,1);

            // Concat the string with correct number/operation
                equation += bText;
                updateEquation(view);
            }
    }

    /** HANDLE OPERATOR
     *      Handles the input of operators. Only alows one operator to be pressed
     *      for an equation
     *
     * @param view
     */
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

    /** ADD IMAGE
     * @param view
     * @param size
     *      which image from the drawable folder to use
     */
//    public void addImage(View view, int size) {
//
//        //setContentView(R.layout.activity_main);
//        RelativeLayout relativelayout = (RelativeLayout)findViewById(R.id.mainLayout);
//
//        ImageView imageview = new ImageView(MainActivity.this);
//        imageview.setId(1);
//
//        RelativeLayout.LayoutParams params = new RelativeLayout
//                .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//
//        // Add image path from drawable folder.
//        imageview.setImageResource(R.drawable.one);
//        imageview.setLayoutParams(params);
//        relativelayout.addView(imageview);
//
//        ImageView image2 = new ImageView(MainActivity.this);
//        image2.setId(2);
//        RelativeLayout.LayoutParams params2 = new RelativeLayout
//                .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        params2.addRule(RelativeLayout.RIGHT_OF,imageview.getId());
//
//        imageview.setImageResource(R.drawable.five);
//        imageview.setLayoutParams(params2);
//
//        relativelayout.addView(image2);
//
//    }

}

//public class PresentActivity extends Activity {
//    protected void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//
//        setContentView(R.layout.content_layout_id);
//
//        final Button button = (Button) findViewById(R.id.button_id);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//                Intent activityChangeIntent = new Intent(PresentActivity.this, NextActivity.class);
//
//                // currentContext.startActivity(activityChangeIntent);
//
//                PresentActivity.this.startActivity(activityChangeIntent);
//            }
//        });
//    }
//}