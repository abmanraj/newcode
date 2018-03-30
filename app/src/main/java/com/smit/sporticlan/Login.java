package com.smit.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smit.sporticlan.AsyncTasks.AsyncResponse;
import com.smit.sporticlan.AsyncTasks.WebserviceCall;
import com.smit.sporticlan.Helper.Utils;

import static com.smit.sporticlan.R.id.login;
import static com.smit.sporticlan.R.id.never;

public class Login extends AppCompatActivity {
    TextView t1;
    Button bt;
    EditText e1;
    EditText e2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=(TextView)findViewById(R.id.forgot);
        bt=(Button)findViewById(login);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.password);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Forgot.class);
                startActivity(i);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                if (e1.getText().toString().length()==0){
                    e1.setError("Please Enter Email Id");
                }
                else if (!e1.getText().toString().matches("^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")){
                    e1.setError("Please Enter Valid E-mail Id");
                }
                else if (e2.getText().toString().length()==0){
                    e2.setError("Please Enter Password");
                }

                else
                {
                    String[] keys = new String[]{"mode", "email","password"};
                    String[] values = new String[]{"Login",email,password};
                    String jsonRequest = Utils.createJsonRequest(keys, values);
                    Toast.makeText(Login.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();
                    Log.d("req",jsonRequest);
                    /*String URL = "http://192.168.17.1/web/webservice.php";*/
                    String url="https://sporticlan.000webhostapp.com/webservice.php";

                    new WebserviceCall(Login.this, url, jsonRequest, "Sign in", true, new AsyncResponse() {
                                @Override
                                public void onCallback(String response) {
                                    Toast.makeText(Login.this, ""+response, Toast.LENGTH_SHORT).show();
                                    Model md=new Gson().fromJson(response,Model.class);

                                    if(md.getStatus()==1)
                                    {
                                        e1.setText("");
                                        e2.setText("");
                                        SharedPreferences sharedPreferences=getSharedPreferences("User", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putInt("id",md.getRid());
                                        editor.commit();
                                        editor.apply();

                                        String rj= String.valueOf(md.getRid());
                                        Bundle bundle=new Bundle();
                                        bundle.putString("sp",rj);
                                        Intent mokal=new Intent(Login.this,Slider .class);
                                        /*mokal.putExtra("sp",rj);*/
                                        mokal.putExtras(bundle);
                                        startActivity(mokal);
                                    }
                                }

                            }).execute();
                }

            }
        });
    }
}
