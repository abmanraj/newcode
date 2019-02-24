package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

import static android.R.attr.id;

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
        SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
        final int id=sharedPreferences.getInt("id",0);
        SharedPreferences sharedPreference=getSharedPreferences("edprofile", Context.MODE_PRIVATE);
        String name=sharedPreference.getString("name",null);
        String gen=sharedPreference.getString("gender",null);
        String ph=sharedPreference.getString("phone",null);
        String add=sharedPreference.getString("address",null);
        String em=sharedPreference.getString("email",null);

        ed1.setText(name);
        ed2.setText(em);
        ed3.setText(ph);
        ed4.setText(gen);
        ed5.setText(add);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strname=ed1.getText().toString();
                String gender=ed4.getText().toString();
                String mobile=ed3.getText().toString();
                String email=ed2.getText().toString();
                String address=ed5.getText().toString();
                String[] keys = new String[]{"mode","rid","name","gender","mobile","email","address"};
                String[] values = new String[]{"editProfile", String.valueOf(id),strname,gender,mobile,email,address};
                String jsonRequest = Utils.createJsonRequest(keys, values);
                Log.d("smit",jsonRequest);
                String url="https://sporticlan.000webhostapp.com/webservice.php";
                new WebserviceCall(editprofile.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {

                        try {
                            Log.d("myapp", response);
                            Toast.makeText(editprofile.this, "" + response, Toast.LENGTH_SHORT).show();
                            Modeledit md = new Gson().fromJson(response, Modeledit.class);

                            if (md.getStatus() == 1) {
                                Toast.makeText(editprofile.this, "" + md.getMessage(), Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(editprofile.this,Login.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(editprofile.this, "" + md.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).execute();
            }
        });

    }
}
