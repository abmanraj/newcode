package com.sporti.sporticlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Aboutus extends AppCompatActivity {
    TextView t1;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        t1=(TextView)findViewById(R.id.about);
        t2=(TextView)findViewById(R.id.text);

        String str="Basically it is a sports application. It will be used for analysis on different sports. It is an android application. Sporticlan with its key partner will help a sports portal realize its dream to consolidate and present sports information, broadcast events and conduct electronic commerce for sporting enthusiasts at all levels. At the national level organizations have leveraged the online rich media to connect with the sports fan.";
        t2.setText(str);
    }
}
