package com.example.revenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class loginActivity extends AppCompatActivity {
    ImageView backbutton;
    TextView sign;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backbutton = findViewById(R.id.backbtn);
        backbutton.setOnClickListener(backlogin);
        sign=findViewById(R.id.signup);
        sign.setOnClickListener(toSign);
        book=findViewById(R.id.button1);
        book.setOnClickListener(tochoose);
       // book.setOnClickListener(bookme);


    }

    private View.OnClickListener backlogin = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };
    private View.OnClickListener toSign = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(loginActivity.this, signup.class));
        }
    };
    private View.OnClickListener tochoose = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(loginActivity.this, choose.class));
        }
    };



}
/*public class loginActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    Button button;
    public FirebaseAuth Auth = FirebaseAuth.getInstance();
    public FirebaseAuth.AuthStateListener authlistener;
    String email, pass;
    ProgressBar bar;

    public View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick (View view){
            email = editText.getText().toString().trim();
            pass = editText2.getText().toString().trim();
            logInUser();

        }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editTextTextPersonName);
        editText2 = (EditText)findViewById(R.id.editTextTextPassword);
        button = (Button)findViewById(R.id.button1);
        Auth = FirebaseAuth.getInstance();
        button.setOnClickListener(buttonListener);
        bar = (ProgressBar)findViewById(R.id.progressBar);
        bar.setVisibility(View.INVISIBLE);

        authlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in

                } else {
                    // User is signed out

                }
                // ...
            }
        };
        // ...
    }

    @Override
    public void onStart() {
        super.onStart();
        Auth.addAuthStateListener(authlistener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authlistener != null) {
            Auth.removeAuthStateListener(authlistener);
        }
    }

    public void logInUser(){
        bar.setVisibility(View.VISIBLE);

        Auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {

                            Intent loggedInActivity = new Intent(loginActivity.this
                                    , choose.class);
                            startActivity(loggedInActivity);

                        }
                        else{

                            Toast.makeText(getApplicationContext(), "There was an error, try again", Toast.LENGTH_SHORT).show();
                        }


                    }
                });


    }
}*/


