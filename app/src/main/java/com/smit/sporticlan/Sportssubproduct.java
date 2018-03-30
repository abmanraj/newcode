package com.smit.sporticlan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smit.sporticlan.AsyncTasks.AsyncResponse;
import com.smit.sporticlan.AsyncTasks.WebserviceCall;
import com.smit.sporticlan.Helper.Utils;

import java.util.ArrayList;

import static android.R.attr.data;
import static com.smit.sporticlan.R.id.gv;

public class Sportssubproduct extends AppCompatActivity {
    ListView lv;
    ArrayList<ModelSubProduct.SubproductListBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportssubproduct);
        lv=(ListView)findViewById(R.id.list);
        Intent intent=getIntent();
        String prid=getIntent().getStringExtra("pr_id");
        Toast.makeText(this, ""+prid, Toast.LENGTH_SHORT).show();

        String[] keys = new  String[]{"mode","p_id"} ;
        String[] values= new  String[]{"SubproductList",prid} ;
        String jsonRequest = Utils.createJsonRequest(keys, values);
        Toast.makeText(Sportssubproduct.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();
        Log.d("rj",jsonRequest);
        String url = "https://sporticlan.000webhostapp.com/webservice.php";
             /*String url="http://192.168.2.13/web/webservice.php";*/

        new WebserviceCall(Sportssubproduct.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
                final ModelSubProduct md = new Gson().fromJson(response, ModelSubProduct.class);

                if (md.getStatus().equalsIgnoreCase("1")) {
                    data = new ArrayList<>();
                    Log.d("size", String.valueOf(md.getSubproductList().size()));
                    for (int i = 0; i < md.getSubproductList().size(); i++) {
                        data.add(md.getSubproductList().get(i));
                        Log.e("arry:::", String.valueOf(data));

                    }

                    subproduct ad=new subproduct(Sportssubproduct.this,R.layout.spots_sub_product,data);
                    lv.setAdapter(ad);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Intent intent;
                            String r;

                            intent =  new Intent(Sportssubproduct.this,Productmainscreen.class);
                            r=String.valueOf(md.getSubproductList().get(i).getSp_id());
                            intent.putExtra("spr_id",r);

                            startActivity(intent);
                        }
                    });
                }
            }
        }).execute();
    }

    }

