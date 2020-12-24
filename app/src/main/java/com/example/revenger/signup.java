package com.example.revenger;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signup extends AppCompatActivity {
    ImageView backbutton;
    EditText Name, phone, mail, pass;
    ProgressBar run;
    FirebaseAuth fauth;
    Button sin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        backbutton = findViewById(R.id.returnn);
        backbutton.setOnClickListener(backlogin);
        Name = findViewById(R.id.editTextprenom);
        mail = findViewById(R.id.editTextmail);
        pass = findViewById(R.id.editTextPassword);
        phone = findViewById(R.id.editphone);
        run = findViewById(R.id.progressBar2);
        fauth = FirebaseAuth.getInstance();
        sin = findViewById(R.id.sign);
        if (fauth.getCurrentUser()!=null)
        { startActivity(new Intent(getApplicationContext(),loginActivity.class));
        finish();}
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= mail.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mail.setError("email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    pass.setError("password required");
                    return;
                }
                if (password.length() < 6) {
                    pass.setError("more than 6 ");
                }
                run.setVisibility(View.VISIBLE);
                fauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signup.this,"user created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),loginActivity.class));

                        }else {
                            Toast.makeText(signup.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }


                });


            }
        });
    }

    private View.OnClickListener backlogin = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };
}








