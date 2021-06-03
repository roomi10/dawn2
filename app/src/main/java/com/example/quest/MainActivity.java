package com.example.quest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

   ConstraintLayout side;
    TextView name;
    Button begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        side = findViewById(R.id.layout);
        side.setBackgroundColor(Color.parseColor("#050202"));
        name = findViewById(R.id.name);
        begin = findViewById(R.id.begin);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity.this, GameActivity.class);
                startActivity(e);
            }
        });
        }
    }

