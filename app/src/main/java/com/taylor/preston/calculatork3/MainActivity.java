package com.taylor.preston.calculatork3;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String equation = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleButton(View view) {

        equation += "0 ";
        updateEquation(view);

    }

    public void updateEquation(View view) {
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(equation);

    }

}
