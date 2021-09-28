package com.example.solace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FEmail extends AppCompatActivity {
    private EditText Femail;
    private Button Fenext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_femail);

        Femail=findViewById(R.id.femail);
        Fenext=findViewById(R.id.fenext);
        Fenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fe =Femail.getText().toString();
                if(fe.equals("darmusaib13@gmail.com")){
                    Intent intent=new Intent(FEmail.this,otpFg.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(FEmail.this, "Email is not registered", Toast.LENGTH_SHORT).show();
            }
        });
    }
}