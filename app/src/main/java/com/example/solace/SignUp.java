package com.example.solace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private Button snext;
    private EditText email,pass,cp;
    private TextView msg;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        snext=findViewById(R.id.next);
        email=findViewById(R.id.Email);
        pass=findViewById(R.id.Password);
        cp=findViewById(R.id.ConfirmPassword);
        msg=findViewById(R.id.messsage);


        auth = FirebaseAuth.getInstance();

        snext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Pass = pass.getText().toString();
                String Confirm_Pass = cp.getText().toString();


                //Checking whether all fields are filled
                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Pass) || TextUtils.isEmpty(Confirm_Pass) ) {
                    msg.setText("Please fill all fields");
                }

                //length of password
                else if ((Pass.length()) < 8) {
                    msg.setText("password length should be atleast 8");
                }

                // Comparing password and confirm password
                else if (!(Pass.contentEquals(Confirm_Pass))) {
                    msg.setText("Password does not match");
                } else {
                    registerUser(Email , Pass);
                }
            }
        });}
    private void registerUser(String email, String password) {

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this , new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUp.this, "Registering user successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this , Login.class));
                    finish();
                } else {
                    Toast.makeText(SignUp.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
