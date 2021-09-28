package com.example.solace;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class coreData extends AppCompatActivity {


    //declearing variables

    //    Button mood_dec,mood_inc,coped_dec,coped_inc,sleep_dec,sleep_inc,exer_dec,exer_inc,core_next;
    Button core_next;
    SeekBar seek_mood, seek_coped, seek_sleep, seek_exer;
    TextView set_mood, set_coped, set_sleep, set_exer;
    int mood_rslt, coped_rslt, sleep_rslt, exer_rslt;
    EditText set_sleep_dur;//sleep duration
//    int sleepDur_rslt;//sleep duration integer

    String sleep_durS;

    //radio buttons
    RadioGroup radiogrp;
    RadioButton radiobtn;
    String radioChecked,date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_data);

        Intent intent = getIntent();
       date = intent.getStringExtra("date");

        //Rate your mood{
        set_mood = findViewById(R.id.RMR);
        seek_mood = findViewById(R.id.seekRM);
        String moodS = set_mood.getText().toString();
        mood_rslt = Integer.parseInt(moodS);//}

        //rate coped
        set_coped = findViewById(R.id.copedR);
        seek_coped = findViewById(R.id.seekcoped);
        String copedS = set_mood.getText().toString();
        coped_rslt = Integer.parseInt(copedS);

        //quality of sleep
        set_sleep = findViewById(R.id.qsleepR);
        seek_sleep = findViewById(R.id.seekQsleep);
        String sleepS = set_mood.getText().toString();
        sleep_rslt = Integer.parseInt(sleepS);

        //Exercise
        set_exer = findViewById(R.id.exerR);
        seek_exer = findViewById(R.id.seekexer);
        String exerS = set_mood.getText().toString();
        exer_rslt = Integer.parseInt(exerS);

        //Sleep Duration

        set_sleep_dur = findViewById(R.id.sleepDur);
        sleep_durS = set_sleep_dur.getText().toString();
//        sleepDur_rslt = Integer.parseInt(sleep_durS);

        //Finding next button view
        core_next = findViewById(R.id.coreNext);

        //Rate your mood{


        //changing mood level by seekbar
        seek_mood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                set_mood.setText(String.valueOf(progress));
                mood_rslt = progress;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //rate coped

        seek_coped.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                set_coped.setText(String.valueOf(progress));
                coped_rslt = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//        //Quality Sleep

        seek_sleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                set_sleep.setText(String.valueOf(progress));
                sleep_rslt = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Exercise duration

        seek_exer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                set_exer.setText(String.valueOf(progress));
                exer_rslt = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

// radio Buttons
//        int radior = radiogrp.getCheckedRadioButtonId();


        //Sleep Duration Validation
        set_sleep_dur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!TextUtils.isEmpty(set_sleep_dur.getText())) {
                    if (Integer.parseInt(set_sleep_dur.getText().toString()) > 24) {
                        sleep_durS = String.valueOf(sleep_rslt);
                        set_sleep_dur.setText("24");
                    }
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        core_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiogrp = findViewById(R.id.radioCore);
//        radioChecked= (String) radiobtn.getText();

                int selectedId = radiogrp.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radiobtn = (RadioButton) findViewById(selectedId);
                radioChecked = radiobtn.getText().toString();

                String sleeptime=set_sleep_dur.getText().toString();

// Hash map

                Map<String, Object> core = new HashMap<>();
                core.put("Your Mood", mood_rslt);
                core.put("How Coped", coped_rslt);
                core.put("Sleep Quality", sleep_rslt);
                core.put("Exercise(Minutes)", exer_rslt);
                core.put("Sleep Duration(Hours)",sleeptime);
                core.put("Medication Taken", radioChecked);



              //new activity and sendind data to other activity


                Intent intent = new Intent(coreData.this, StayWellStratigies.class);
                intent.putExtra("core",(Serializable) core);
                intent.putExtra("date", date);

                startActivity(intent);

            }
        });


    }
}