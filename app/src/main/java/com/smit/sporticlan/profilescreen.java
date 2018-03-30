package com.smit.sporticlan;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smit.sporticlan.AsyncTasks.AsyncResponse;
import com.smit.sporticlan.AsyncTasks.WebserviceCall;
import com.smit.sporticlan.Helper.Utils;

import java.util.ArrayList;

public class profilescreen extends AppCompatActivity {
    ArrayList<ModelProfile.UserDetailsBean> data;
    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilescreen);
        t1=(TextView)findViewById(R.id.prname);
        t2=(TextView)findViewById(R.id.premail);
        t3=(TextView)findViewById(R.id.prphone);
        t4=(TextView)findViewById(R.id.prgender);
        t5=(TextView)findViewById(R.id.praddress);


        SharedPreferences sharedPreferences=getSharedPreferences("User", Context.MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",0);
        Toast.makeText(profilescreen.this,""+id,Toast.LENGTH_LONG).show();
        String[] keys = new String[]{"mode","rid"};
        String[] values = new String[]{"getProfileDetail", String.valueOf(id)};
        String jsonRequest = Utils.createJsonRequest(keys, values);
        Log.d("smit",jsonRequest);
        String url="https://sporticlan.000webhostapp.com/webservice.php";
        new WebserviceCall(profilescreen.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
                Toast.makeText(profilescreen.this, "" + response, Toast.LENGTH_SHORT).show();
                ModelProfile md = new Gson().fromJson(response, ModelProfile.class);

                if (md.getStatus()==1) {
                    t1.setText(""+md.getUserDetails().getName());
                    t4.setText(""+md.getUserDetails().getGender());
                    t3.setText(md.getUserDetails().getMobile());
                    t5.setText(md.getUserDetails().getAddress());
                    t2.setText(md.getUserDetails().getEmail());
                }
            }
        }).execute();
    }
}
