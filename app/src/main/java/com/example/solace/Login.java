package com.example.solace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class Login extends AppCompatActivity {


    private Button reg, Log;
    private EditText Eml, Pass;
    private TextView fp;

    private FirebaseAuth login_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reg = findViewById(R.id.register);
        Log = findViewById(R.id.login);
        Eml = findViewById(R.id.lemail);
        Pass = findViewById(R.id.lpassword);
        fp = findViewById(R.id.forgotpassword);
        login_auth = FirebaseAuth.getInstance();


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eml = Eml.getText().toString();
                String pss = Pass.getText().toString();

                loginUser(eml, pss);


            }
        });


        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, FEmail.class);
                startActivity(intent);

            }
        });
    }

    private void loginUser(String email, String password) {

        login_auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, home.class);
                startActivity(intent);

                finish();

            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startActivity(new Intent(Login.this, home.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
    }
}