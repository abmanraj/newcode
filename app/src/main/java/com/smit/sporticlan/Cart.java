package com.smit.sporticlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    ListView lv;
    TextView tx;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        lv=(ListView)findViewById(R.id.listid);
        tx=(TextView)findViewById(R.id.totalprice);
        bt=(Button)findViewById(R.id.buy);
    }
}
