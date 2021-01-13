package com.example.chat_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText send_email;
    Button btn_reset;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        send_email = findViewById(R.id.send_email);
        btn_reset = findViewById(R.id.btn_reset);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = send_email.getText().toString();
                if (email.equals("")){
                    Toast.makeText(com.example.chat_application.ResetPasswordActivity.this, "please enter email!", Toast.LENGTH_SHORT).show();
                } else {
                    ProgressDialog progressDialog = new ProgressDialog(ResetPasswordActivity.this);
                    progressDialog.setMessage("Sending mail ...");
                    progressDialog.show();

                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            progressDialog.cancel();
                            if (task.isSuccessful()){
                                Toast.makeText(com.example.chat_application.ResetPasswordActivity.this, "Email is sent successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(com.example.chat_application.ResetPasswordActivity.this, com.example.chat_application.LoginActivity.class));
                            } else {
                                String error = task.getException().getMessage();
                                Toast.makeText(com.example.chat_application.ResetPasswordActivity.this, error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
