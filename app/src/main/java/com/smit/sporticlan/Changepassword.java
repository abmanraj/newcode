package com.smit.sporticlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Changepassword extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText e3;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        e1=(EditText)findViewById(R.id.curentpass);
        e2=(EditText)findViewById(R.id.newpass);
        e3=(EditText)findViewById(R.id.confirmpass);
        bt=(Button)findViewById(R.id.submitpass);

    }
}
