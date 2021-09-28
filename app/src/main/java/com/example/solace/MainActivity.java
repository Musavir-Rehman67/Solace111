package com.example.solace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int n=0;

        while(n>=10){
            n=n+1;

        }
        startActivity(new Intent(MainActivity.this,Login.class));
    }
}