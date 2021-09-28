package com.example.solace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class report extends AppCompatActivity {
    BarChart barChart;
    ArrayList barEntries;

    private DatabaseReference myRef, ref2;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private String id;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        barChart = findViewById(R.id.BarChart);


//        BarData barData = new BarData();
//        barChart.setData(barData);
//        XAxis xAxis = barChart.getXAxis();
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(Collections.singleton(date)));
//        barChart.getAxisLeft().setAxisMinimum(0);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setGranularity(1);
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setGranularityEnabled(true);
//        barChart.invalidate();
//
//        float barSpace = 0.02f;
//        float groupSpace = 0.3f;
//        int groupCount = 4;
//        barData.setBarWidth(0.15f);
//        barChart.getXAxis().setAxisMinimum(0);
//        barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
//        barChart.groupBars(0, groupSpace, barSpace);



        user = FirebaseAuth.getInstance().getCurrentUser();
        id = user.getUid();

        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference().child(id);


        Log.d("my ref", String.valueOf(myRef));


        Intent intent = getIntent();
        HashMap<String, String> core = (HashMap<String, String>) intent.getSerializableExtra("core");
        HashMap<String, String> SWS = (HashMap<String, String>) intent.getSerializableExtra("sws");
        HashMap<String, String> symptoms = (HashMap<String, String>) intent.getSerializableExtra("symptoms");
        HashMap<String, String> triggers = (HashMap<String, String>) intent.getSerializableExtra("triggers");
        String date = intent.getStringExtra("date");

        fetchDate();

    }






    private void fetchDate() {
        myRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("all user firebase", "datbase");
                date = snapshot.getKey();
//                HashMap value = (HashMap) snapshot.getValue();
                Log.d("date", date);
//                Log.d("value", String.valueOf(value));
                fetchData(date);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void fetchData(String date) {
        ref2 = database.getInstance().getReference().child(id).child(""+date).child("Core Data");

        ref2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
               switch (snapshot.getKey()){
                   case "Exercise(Minutes)":
                       String value = String.valueOf(snapshot.getValue());

                       Log.d("exercise",value);
                       break;
                   case "How Coped":
                       String coped = String.valueOf(snapshot.getValue());

                       Log.d("coped",coped);
                       break;
                   case "Medication Taken":
                       String medication = String.valueOf(snapshot.getValue());
                       Log.d("medication",medication);
                       break;
                   case "Sleep Duration(Hours)":
                       String sleepDuration = String.valueOf(snapshot.getValue());
                       Log.d("sleepduration",sleepDuration);
                       break;
                   case "Sleep Quality":
                       String sleepQuality = String.valueOf(snapshot.getValue());
                       Log.d("sleepQuality",sleepQuality);
                       break;
                   case "Your Mood":
                       String Mood = String.valueOf(snapshot.getValue());
                       Log.d("mood",Mood);
                       break;


               }

               }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

