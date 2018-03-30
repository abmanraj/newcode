package com.smit.sporticlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class editprofile extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        ed1=(EditText)findViewById(R.id.edname);
        ed2=(EditText)findViewById(R.id.edemail);
        ed3=(EditText)findViewById(R.id.edphone);
        ed4=(EditText)findViewById(R.id.edgender);
        ed5=(EditText)findViewById(R.id.edaddress);
        bt=(Button)findViewById(R.id.update);
    }
}
