package com.example.solace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class otpFg extends AppCompatActivity {

    private Button fnext;
    private EditText fpotp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_fg);
        fnext=findViewById(R.id.ofgnext);
        fpotp=findViewById(R.id.OTP2);


        fnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fotp = fpotp.getText().toString();
                if(fotp.equals("123456")){
                    Intent intent=new Intent(otpFg.this,newPassword.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(otpFg.this, "OTP is wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}