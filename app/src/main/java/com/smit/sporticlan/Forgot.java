package com.smit.sporticlan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Forgot extends AppCompatActivity {
    EditText e1;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        e1=(EditText)findViewById(R.id.emailid);
        bt=(Button)findViewById(R.id.submit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Forgot.this,Login.class);
                startActivity(i);
            }
        });
    }
}
