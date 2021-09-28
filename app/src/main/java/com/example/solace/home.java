package com.example.solace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class home extends AppCompatActivity {

    private EditText date;
    private Button homeNext;
    private Calendar calendar;
    String txt_date;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeNext = findViewById(R.id.homenext);

        date = findViewById(R.id.date);
        calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String sd = dateFormat.format(calendar.getTime());
        date.setText(sd);


        homeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_date = date.getText().toString();
                if (txt_date.isEmpty()) {
                    Toast.makeText(home.this, "Invalid Date", Toast.LENGTH_SHORT).show();
                } else {






                    Intent intent = new Intent(home.this, coreData.class);
                    intent.putExtra("date", txt_date);
                    startActivity(intent);
                }

            }
        });



        //Logout Button
        Button logout;
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(home.this, "Loged Out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(home.this, Login.class));
            }
        });

    }
}