package com.example.solace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class newPassword extends AppCompatActivity {
    private Button new_pass_btn;
    private EditText new_pass,con_pass;
    private TextView npmatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        new_pass_btn=findViewById(R.id.newpnext);
        new_pass=findViewById(R.id.newPassword);
        con_pass=findViewById(R.id.newConfirmPassword);
        npmatch=findViewById(R.id.ncpmsg);


        new_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n_p=new_pass.getText().toString();
                String n_cp=con_pass.getText().toString();

                if(n_p.length()< 8 ){
                    npmatch.setText("Password length is too short");
                } else if ( !(n_cp.contentEquals(n_p))){
                    npmatch.setText("! Password doesnot match");

                } else {
                    npmatch.setText("");
                    Intent intent=new Intent(newPassword.this,home.class);
                    startActivity(intent);
                }

            }
        });

    }
}