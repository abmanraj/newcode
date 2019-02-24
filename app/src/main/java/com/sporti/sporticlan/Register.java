package com.sporti.sporticlan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

public class Register extends AppCompatActivity {
 Button bt;
    EditText e1,e2,e3,e4,e5,e6;
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bt=(Button)findViewById(R.id.Register);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.phone);
        e4=(EditText)findViewById(R.id.address);
        e5=(EditText)findViewById(R.id.pass);
        e6=(EditText)findViewById(R.id.pass1);
        rg=(RadioGroup)findViewById(R.id.gen);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = e1.getText().toString();
                String email = e2.getText().toString();
                String phone= e3.getText().toString();
                String address = e4.getText().toString();
                String pass = e5.getText().toString();
                String pass1 = e6.getText().toString();

                int rgs_id = rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(rgs_id);

                String str1=rb.getText().toString();

                if (name.isEmpty())
                {
                    Toast.makeText(Register.this, "name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                if (phone.isEmpty())
                {
                    Toast.makeText(Register.this, "mobile_number cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (email.isEmpty())
                {
                    Toast.makeText(Register.this, "email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (!e2.getText().toString().matches("^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")){
                    e2.setError("Please Enter Valid E-mail Id");
                }
                if (pass.isEmpty())
                {
                    Toast.makeText(Register.this, "password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (pass1.isEmpty())
                {
                    Toast.makeText(Register.this, "confirm_password cannot be empty", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if (!pass.equals(pass1))
                    {
                        Toast.makeText(Register.this, "password and confirm_password not match", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        String[] keys = new String[]{"mode", "name","gender","mobile","email","password","address"};
                        String[] values = new String[]{"Register", name, str1, phone, email, pass,address};
                        String jsonRequest = Utils.createJsonRequest(keys, values);
                     /*   Toast.makeText(Register.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();*/

                        String URL = "http://192.168.17.1/web/webservice.php";
                        String url="https://sporticlan.000webhostapp.com/webservice.php";

                        new WebserviceCall(Register.this, url, jsonRequest, "Sign Up", true, new AsyncResponse() {
                            @Override
                            public void onCallback(String response) {
                                Log.d("myapp", response);
                               /* Toast.makeText(Register.this, ""+response, Toast.LENGTH_SHORT).show();*/

                                Modelreg md=new Gson().fromJson(response,Modelreg.class);

                                if(md.getStatus()==1)
                                {
                                    Intent mokal=new Intent(Register.this,Login.class);
                                    startActivity(mokal);
                                }

                            }
                        }).execute();
                    }

                }
            }
        });
    }

}
