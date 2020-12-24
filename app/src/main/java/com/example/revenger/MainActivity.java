package com.example.revenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView signin;
    private View.OnClickListener tologin = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, loginActivity.class));
        }};
    private View.OnClickListener toSign = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, signup.class));
        }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) findViewById(R.id.loginbtn);
        login.setOnClickListener(tologin);
        signin=findViewById(R.id.tosign);
        signin.setOnClickListener(toSign);
    }
}


