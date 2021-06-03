package com.example.quest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.DnsResolver;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;


public class GameActivity extends AppCompatActivity {
    Story story;
    ConstraintLayout layout;
    LinearLayout action_container;
    Button left, right;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = findViewById(R.id.layout);
        text = findViewById(R.id.text);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        story = new Story(this);

    }

    public void apply(){
        text.setText(story.current_situation.getSituation());
        ((LinearLayout) findViewById(R.id.action_container)).removeAllViews();
        for (Answer a :story.current_situation.getAnswers()){
            final int buttonId = a.getNext();
            Button button = new Button(this);
            button.setText(a.getAnswer());
            ((LinearLayout) findViewById(R.id.action_container)).addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    go(buttonId); }
                private void go(int buttonId) {
                    story.go(buttonId);
                    apply();
                }
            });


        }
    }

    private void saveActivityPreferences() {
        SharedPreferences activityPreferences = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putInt("id", this.story.current_situation.getMainId());
        editor.commit();
    }

}

