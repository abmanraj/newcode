package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    ListView lv;
    TextView tx;
    Button bt;
    com.sporti.sporticlan.Custom adapter;
    int count=0;
    ArrayList<com.sporti.sporticlan.ModelList.OrderDetailBean> orderDetailBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        lv=(ListView)findViewById(R.id.listid);
        tx=(TextView)findViewById(R.id.totalprice);
        bt=(Button)findViewById(R.id.buy);

        SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",0);

        String[] key = new String[]{"mode","rid"};
        String[] values = new String[]{"listingCart", String.valueOf(id)};
        String jsonRequest = Utils.createJsonRequest(key, values);
        String url="https://sporticlan.000webhostapp.com/webservice.php";
        Log.d("akjwd", jsonRequest);

        new WebserviceCall(Cart.this, url, jsonRequest, "Sign Up", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                //Log.d("myapp", response);
                //Toast.makeText(Cart.this, "" + response, Toast.LENGTH_LONG).show();
                ModelList ml = new Gson().fromJson(response, ModelList.class);

                if (ml.getStatus() == 1) {
                    orderDetailBeen = new ArrayList<>();
                    for (int i = 0; i < ml.getOrderDetail().size(); i++) {
                        orderDetailBeen.add(ml.getOrderDetail().get(i));
                        String s = ml.getOrderDetail().get(i).getTotal_price();
                        count = count + Integer.parseInt(s);
                    }
                    adapter = new Custom(Cart.this, R.layout.cartview, orderDetailBeen);
                    lv.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(Cart.this, ""+ml.getMessage(), Toast.LENGTH_SHORT).show();
                }
                tx.setText("Total Price : " + String.valueOf(count + " Rs"));
            }
        }).execute();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (0<count){
                    Toast.makeText(Cart.this, ""+count, Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Cart.this,Payment.class);
                    i.putExtra("Total_Price",+count);
                    startActivity(i);
                }else {
                    Toast.makeText(Cart.this, "Please Add Item", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
       Intent i=new Intent(Cart.this,Slider.class);
        startActivity(i);

    }
}
