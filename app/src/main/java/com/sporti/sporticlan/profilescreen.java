package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

import java.util.ArrayList;

public class profilescreen extends AppCompatActivity {
    ArrayList<ModelProfile.UserDetailsBean> data;
    TextView t1,t2,t3,t4,t5;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilescreen);
        t1=(TextView)findViewById(R.id.prname);
        t2=(TextView)findViewById(R.id.premail);
        t3=(TextView)findViewById(R.id.prphone);
        t4=(TextView)findViewById(R.id.prgender);
        t5=(TextView)findViewById(R.id.praddress);
        bt=(Button)findViewById(R.id.edpr);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(profilescreen.this,editprofile.class);
                startActivity(i);
            }
        });


        SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",0);
      //  Toast.makeText(profilescreen.this,""+id,Toast.LENGTH_LONG).show();
        String[] keys = new String[]{"mode","rid"};
        String[] values = new String[]{"getProfileDetail", String.valueOf(id)};
        String jsonRequest = Utils.createJsonRequest(keys, values);
        Log.d("smit",jsonRequest);
        String url="https://sporticlan.000webhostapp.com/webservice.php";
        new WebserviceCall(profilescreen.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
                //Toast.makeText(profilescreen.this, "" + response, Toast.LENGTH_SHORT).show();
                ModelProfile md = new Gson().fromJson(response, ModelProfile.class);

                if (md.getStatus()==1) {
                    String name=md.getUserDetails().getName();
                    String gender=md.getUserDetails().getGender();
                    String phone=md.getUserDetails().getMobile();
                    String address=md.getUserDetails().getAddress();
                    String email=md.getUserDetails().getEmail();
                    t1.setText("Name : "+name);
                    t4.setText("Gender : "+gender);
                    t3.setText("Phone : "+phone);
                    t5.setText("Address : "+address);
                    t2.setText("Email : "+email);
                    SharedPreferences preferences = getSharedPreferences("edprofile",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("name",name);
                    editor.putString("gender",gender);
                    editor.putString("phone",phone);
                    editor.putString("address",address);
                    editor.putString("email",email);
                    editor.commit();
                }
            }
        }).execute();
    }
}
