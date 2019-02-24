package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Productmainscreen extends AppCompatActivity {
    ImageView i;
    TextView tx1;
    TextView tx2;
    TextView tx3,Total;
    Button bt1;
    String pr;
    Button bt2,buy,add;
    TextView tx4;
    ArrayList<ModelMain.DataBean> arrayListData;
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
        buy=(Button)findViewById(R.id.buy);
        add=(Button)findViewById(R.id.add);
        Total=(TextView)findViewById(R.id.total);
        tx4.setText(""+count);
        final String pid =getIntent().getStringExtra("spr_id");
       // Toast.makeText(this, ""+pid, Toast.LENGTH_SHORT).show();
        String[] keys = new String[]{"mode", "sp_id"};
        String[] values = new String[]{"FinalProductList",pid};
        String jsonRequest = Utils.createJsonRequest(keys, values);
       // Toast.makeText(Productmainscreen.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();

        String url="https://sporticlan.000webhostapp.com/webservice.php";

        new WebserviceCall(Productmainscreen.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
              //  Toast.makeText(Productmainscreen.this, ""+response, Toast.LENGTH_SHORT).show();

                ModelMain md=new Gson().fromJson(response,ModelMain.class);
                if(md.getStatus()==1) {
                   tx1.setText("Name : "+md.getData().getSp_name());
                    tx2.setText("Price : "+md.getData().getSp_price());
                    tx3.setText("Discription : "+md.getData().getSp_dis());
                    pr=md.getData().getSp_price();
                    Total.setText("Total Price : "+md.getData().getSp_price());
                    String r=md.getData().getSp_image().toString();
                    String a=r.trim().replace("\\","");

                    Log.e("imageval",a);
                    //Toast.makeText(Productmainscreen.this, ""+a, Toast.LENGTH_SHORT).show();
                    // Picasso.with(context).load(a).into(iv);
                    if(a!=null)
                    {
                        Glide.with(Productmainscreen.this)
                                .load(a)
                                .placeholder(R.drawable.teniss)
                                .override(200,200)
                                .centerCrop()
                                .into(i);
                    }
                }
            }
        }).execute();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>1){
                    count=count-1;
                    tx4.setText(""+count);
                    int total=count*Integer.parseInt(pr);
                    Total.setText("Total Price :"+total);                }

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                tx4.setText(""+count);
                int total=count*Integer.parseInt(pr);
                Total.setText("Total Price :"+total);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                int id=sharedPreferences.getInt("id",0);
                String[] key=new String[]{"mode","rid","sp_id","unit"};
                String[] values=new String[]{"AddtoCart",String.valueOf(id),String.valueOf(pid), String.valueOf(count)};
                String jsonRequest = Utils.createJsonRequest(key, values);
                String url="https://sporticlan.000webhostapp.com/webservice.php";
                Log.d("skcdms",jsonRequest);

                new WebserviceCall(Productmainscreen.this, url, jsonRequest, "Sign Up", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                        Log.d("myapp", response);
                       // Toast.makeText(Productmainscreen.this, ""+response, Toast.LENGTH_SHORT).show();

                        ModelCart mc=new Gson().fromJson(response,ModelCart.class);

                        if(mc.getStatus().equalsIgnoreCase("1"))
                        {
                           // Toast.makeText(Productmainscreen.this,""+mc.getMessage(), Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }

                    }
                }).execute();
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                int id=sharedPreferences.getInt("id",0);
                String[] key=new String[]{"mode","rid","sp_id","unit"};
                String[] values=new String[]{"AddtoCart",String.valueOf(id),String.valueOf(pid), String.valueOf(count)};
                String jsonRequest = Utils.createJsonRequest(key, values);
                String url="https://sporticlan.000webhostapp.com/webservice.php";
                Log.d("skcdms",jsonRequest);

                new WebserviceCall(Productmainscreen.this, url, jsonRequest, "Sign Up", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                        Log.d("myapp", response);
                       // Toast.makeText(Productmainscreen.this, ""+response, Toast.LENGTH_SHORT).show();

                        ModelCart mc=new Gson().fromJson(response,ModelCart.class);

                        if(mc.getStatus().equalsIgnoreCase("1"))
                        {
                            Intent intent=new Intent(Productmainscreen.this,Cart.class);
                            startActivity(intent);
                            onBackPressed();
                        }

                    }
                }).execute();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

