package com.example.revenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class choose extends AppCompatActivity {
    View choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        choice=findViewById(R.id.view);
        choice.setOnClickListener(tochoose);

    }

    private View.OnClickListener tochoose = new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent = new Intent(choose.this, SlotActivity.class);
            startActivity(intent);

        }
    };

    }

