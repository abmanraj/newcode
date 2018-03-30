package com.smit.sporticlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Productmainscreen extends AppCompatActivity {
    ImageView i;
    TextView tx1;
    TextView tx2;
    TextView tx3;
    Button bt1;
    Button bt2;
    TextView tx4;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productmainscreen);
        i=(ImageView)findViewById(R.id.image);
        tx1=(TextView)findViewById(R.id.name);
        tx2=(TextView)findViewById(R.id.price);
        tx3=(TextView)findViewById(R.id.dec);
        bt1=(Button)findViewById(R.id.minus);
        bt2=(Button)findViewById(R.id.plus);
        tx4=(TextView)findViewById(R.id.qty);
        tx4.setText(""+count);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1){
                    count=count-1;
                    tx4.setText(""+count);

                }else {
                    finish();

                }

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                tx4.setText(""+count);
            }
        });
    }
}
