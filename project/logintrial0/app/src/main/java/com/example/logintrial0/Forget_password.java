package com.example.logintrial0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_password extends AppCompatActivity {

    private Button forget_button;
    private EditText fEmail;
    private String email;
    private FirebaseAuth auth;
    TextView login_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        auth = FirebaseAuth.getInstance();
        fEmail = findViewById(R.id.forget_email);
        forget_button = findViewById(R.id.forget_button);
        login_ = findViewById(R.id.login_);


        forget_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();

            }
        });
    }

    private void validateData() {
        email = fEmail.getText().toString();
        if (email.isEmpty()) {
            fEmail.setError("Required");

        }else{
            forgetPass();
        }


    }

    private void forgetPass() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Forget_password.this,"Check Your Email",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Forget_password.this ,login.class));
                            finish();
                        }else{
                            Toast.makeText(Forget_password.this,"Error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        login_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Forget_password.this,login.class));
            }
        });
    }


}