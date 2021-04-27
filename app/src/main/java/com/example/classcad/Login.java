package com.example.classcad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText m1Email;
    EditText m1Pass;
    Button mLogin;
    TextView miflog;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        m1Email = findViewById(R.id.email);
        m1Pass = findViewById(R.id.pass);

        fAuth = FirebaseAuth.getInstance();
        mLogin = findViewById(R.id.loginbt);
        miflog = findViewById(R.id.iflog);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = m1Email.getText().toString().trim();
                String pass = m1Pass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    m1Email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    m1Pass.setError("Password is required");
                    return;
                }
                if(pass.length()<6){
                    m1Pass.setError("Password must be greater than 6 characters");
                    return;
                }else{
                    m1Pass.setError("Error");
                }



                //auth user

                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Login.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Login.this,"Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void iflog(View view) {
        startActivity(new Intent(getApplicationContext(),Register.class));
        finish();
    }
}