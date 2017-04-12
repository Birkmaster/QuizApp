package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // value of score shuld show result at the end

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //switch case for th redio buttons
    public void onRadioButton1Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_1:
                if (checked)
                    score -= 1;
                    break;
            case R.id.radio_2:
                if (checked)
                    score -= 1;
                    break;
            case R.id.radio_3:
                if (checked)
                    score += 1;
                    break;
        }
    }
    //switch case for th redio buttons
    public void onRadioButton2Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_4:
                if (checked)
                    score += 1;
                break;
            case R.id.radio_5:
                if (checked)
                    score -= 1;
                break;
            case R.id.radio_6:
                if (checked)
                    score -= 1;
                break;
        }
    }
    //switch case for th redio buttons
    public void onRadioButton3Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_7:
                if (checked)
                    score -= 1;
                break;
            case R.id.radio_8:
                if (checked)
                    score += 1;
                break;
            case R.id.radio_9:
                if (checked)
                    score -= 1;
                break;
        }
    }
    //checks if CheckBoxes are checked and calculates score from result
    public void checkBoxes(View view) {
        CheckBox quizOneCreamCheckBox = (CheckBox) findViewById(R.id.quiz_checkbox1);
        boolean oneChecked = quizOneCreamCheckBox.isChecked();
        CheckBox quizTwoCheckBox = (CheckBox) findViewById(R.id.quiz_checkbox2);
        boolean twoChecked = quizTwoCheckBox.isChecked();
        CheckBox quizThreeCheckBox = (CheckBox) findViewById(R.id.quiz_checkbox3);
        boolean threeChecked = quizThreeCheckBox.isChecked();
        CheckBox quizFourCheckBox = (CheckBox) findViewById(R.id.quiz_checkbox4);
        boolean fourChecked = quizFourCheckBox.isChecked();
        score += calculateCheckBoxes (oneChecked, twoChecked, threeChecked, fourChecked);

    }
    //introduces baseScore for calculating score from checkBoxes
    private int calculateCheckBoxes(boolean addOneCheck, boolean addTwoCheck, boolean addThreeCheck,  boolean addFourCheck) {
        int baseScore = 0;

        if (addOneCheck) {
            baseScore += 1;
        }
        if (addTwoCheck) {
            baseScore -= 1;
        }
        if (addThreeCheck) {
            baseScore -= 1;
        }
        if (addFourCheck) {
            baseScore += 1;
        }
        return baseScore;
    }
    //checks if entered number equals 50
    public void checkNumber (View view){

        EditText number = (EditText)findViewById(R.id.number_field);
        String userEntry = number.getText().toString();
        if (userEntry.equals(50))
            score += 1;
        else {
            Toast.makeText(MainActivity.this, "Oops Wrong !", Toast.LENGTH_SHORT).show();
        }
    }

    //shows score

    public void showScore (View view) {
        Context context = getApplicationContext();
        CharSequence text = "You have reached " + score + " out of 6 Points";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}


