package com.smit.sporticlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;


public class Feedback extends AppCompatActivity {
    RatingBar rate;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        bt=(Button)findViewById(R.id.submit);
        rate=(RatingBar)findViewById(R.id.rating);
    }
}
