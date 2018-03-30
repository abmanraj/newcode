package com.smit.sporticlan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smit.sporticlan.AsyncTasks.AsyncResponse;
import com.smit.sporticlan.AsyncTasks.WebserviceCall;
import com.smit.sporticlan.Helper.Utils;

import java.util.ArrayList;

import static android.R.attr.data;
import static java.security.AccessController.getContext;

public class Sportproduct extends AppCompatActivity {
    GridView gv;
    ArrayList<ModelProduct.ProductListBean> data;
    ModelProduct md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportproduct);
        gv=(GridView)findViewById(R.id.gv);
        Intent intent=getIntent();
        String cid=getIntent().getStringExtra("c_id");
        Toast.makeText(this, ""+cid, Toast.LENGTH_SHORT).show();

        String[] keys = new  String[]{"mode","c_id"} ;
        String[] values= new  String[]{"ProductList",cid} ;
        String jsonRequest = Utils.createJsonRequest(keys, values);
// Toast.makeText(Category.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();

        String url = "https://sporticlan.000webhostapp.com/webservice.php";
             /*String url="http://192.168.2.13/web/webservice.php";*/

        new WebserviceCall(Sportproduct.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
                md = new Gson().fromJson(response, ModelProduct.class);

                if (md.getStatus().equalsIgnoreCase("1")) {
                    data = new ArrayList<>();
                    Log.d("size", String.valueOf(md.getProductList().size()));
                    for (int i = 0; i < md.getProductList().size(); i++) {
                        data.add(md.getProductList().get(i));
                        Log.e("arry:::", String.valueOf(data));

                    }

                    sportcustad ad= new sportcustad(Sportproduct.this,R.layout.sportlist,data);
                    gv.setAdapter(ad);


                }
            }
        }).execute();
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent;
                String r;

                intent =  new Intent(Sportproduct.this, Sportssubproduct.class);
                r=String.valueOf(md.getProductList().get(i).getP_id());
                intent.putExtra("pr_id",r);

                startActivity(intent);
            }
        });
    }
}
