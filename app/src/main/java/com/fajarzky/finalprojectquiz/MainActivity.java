package com.fajarzky.finalprojectquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    //pertanyaan 1
    RadioButton pertanyaan1_jawaban1;
    //pertanyaan 2
    EditText pertanyaan2_jawaban;
    //pertanyaan 3
    CheckBox pertanyaan3_jawaban1;
    CheckBox pertanyaan3_jawaban2;
    CheckBox pertanyaan3_jawaban3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }

    public void submitJawaban(View view) {
        CharSequence resultsDisplay;
        Log.e(LOG_TAG, "" + this.findViewById(R.id.pertanyaan3_jawaban1));
        int pertanyaan1_score;
        int pertanyaan2_score;
        int pertanyaan3_score;
        int final_score;

        Boolean pertanyaan1;

        pertanyaan1_jawaban1 = (RadioButton) this.findViewById(R.id.pertanyaan1_jawaban1);
        pertanyaan1 = pertanyaan1_jawaban1.isChecked();
        if (pertanyaan1) {
            pertanyaan1_score = 1;
        } else {
            pertanyaan1_score = 0;
        }

        String pertanyaan2;
        pertanyaan2_jawaban = (EditText) this.findViewById(R.id.pertanyaan2_jawaban);
        pertanyaan2 = pertanyaan2_jawaban.getText().toString().toLowerCase();
        if (pertanyaan2.equals("5 hari")) {
            pertanyaan2_score = 1;
        } else {
            pertanyaan2_score = 0;
        }

        CheckBox pertanyaan3_jawaban1;
        CheckBox pertanyaan3_jawaban2;
        CheckBox pertanyaan3_jawaban3;

        boolean isChecked_jawaban_1;
        boolean isChecked_jawaban_2;
        boolean isChecked_jawaban_3;

        pertanyaan3_jawaban1 = (CheckBox) this.findViewById(R.id.pertanyaan3_jawaban1);
        pertanyaan3_jawaban2 = (CheckBox) this.findViewById(R.id.pertanyaan3_jawaban2);
        pertanyaan3_jawaban3 = (CheckBox) this.findViewById(R.id.pertanyaan3_jawaban3);
        isChecked_jawaban_1 = pertanyaan3_jawaban1.isChecked();
        isChecked_jawaban_2 = pertanyaan3_jawaban2.isChecked();
        isChecked_jawaban_3 = pertanyaan3_jawaban3.isChecked();
        if (isChecked_jawaban_1 && !isChecked_jawaban_2 && isChecked_jawaban_3) {
            pertanyaan3_score = 1;
        } else {
            pertanyaan3_score = 0;
        }

        final_score = pertanyaan1_score + pertanyaan2_score + pertanyaan3_score;

        if (final_score == 3) {
            resultsDisplay = "Jawabannya bener semua";
        } else {
            resultsDisplay = "Coba lagi bro, salah " + final_score + " dari 3";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

