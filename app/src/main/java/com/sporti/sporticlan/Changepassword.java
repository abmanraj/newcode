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

public class Changepassword extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText e3;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        e1=(EditText)findViewById(R.id.curentpass);
        e2=(EditText)findViewById(R.id.newpass);
        e3=(EditText)findViewById(R.id.confirmpass);
        bt=(Button)findViewById(R.id.submitpass);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current=e1.getText().toString();
                String newpass=e2.getText().toString();
                String cofirm=e3.getText().toString();
                if (current.isEmpty())
                {
                    Toast.makeText(Changepassword.this, "Old Password cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                if (newpass.isEmpty())
                {
                    Toast.makeText(Changepassword.this, "New Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (cofirm.isEmpty())
                {
                    Toast.makeText(Changepassword.this, "Confirm Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (!newpass.equals(cofirm))
                    {
                        Toast.makeText(Changepassword.this, "password and confirm_password not match", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        SharedPreferences sharedPreferences = getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                        int id = sharedPreferences.getInt("id", 0);
                        String[] keys = new String[]{"mode", "rid","password","newPassword"};
                        String[] values = new String[]{"changePassword",String.valueOf(id),current,newpass};
                        String jsonRequest = Utils.createJsonRequest(keys, values);
                        Toast.makeText(Changepassword.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();
                        Log.e("changepass",jsonRequest);

                        String url="https://sporticlan.000webhostapp.com/webservice.php";
                        new WebserviceCall(Changepassword.this, url, jsonRequest, "Sign in", true, new AsyncResponse() {
                            @Override
                            public void onCallback(String response) {
                                Log.d("myappchsngepass", response);
                                Toast.makeText(Changepassword.this, ""+response, Toast.LENGTH_SHORT).show();

                                modelchange m=new Gson().fromJson(response,modelchange.class);

                                if(m.getStatus()==1)
                                {
                                    Toast.makeText(Changepassword.this, ""+m.getMessage(), Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(Changepassword.this,Slider.class);
                                    startActivity(intent);
                                }

                            }
                        }).execute();
                    }

                }
            }

        });
    }
}
