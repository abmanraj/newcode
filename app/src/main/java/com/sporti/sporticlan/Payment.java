package com.sporti.sporticlan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class Payment extends AppCompatActivity {
    TextView tx1,tx2,tx3,tx4;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        tx1=(TextView)findViewById(R.id.pname);
        tx2=(TextView)findViewById(R.id.pphone);
        tx3=(TextView)findViewById(R.id.paddress);
        tx4=(TextView)findViewById(R.id.pprice);
        bt=(Button)findViewById(R.id.psubmit);



        int tp=getIntent().getIntExtra("Total_Price",0);
        Toast.makeText(this, ""+tp, Toast.LENGTH_SHORT).show();


        SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",0);
        Toast.makeText(Payment.this,""+id,Toast.LENGTH_LONG).show();
        String[] keys = new String[]{"mode","rid"};
        String[] values = new String[]{"getProfileDetail", String.valueOf(id)};
        String jsonRequest = Utils.createJsonRequest(keys, values);
        Log.d("smit",jsonRequest);
        String url="https://sporticlan.000webhostapp.com/webservice.php";
        new WebserviceCall(Payment.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
                Toast.makeText(Payment.this, "" + response, Toast.LENGTH_SHORT).show();
                ModelProfile md = new Gson().fromJson(response, ModelProfile.class);

                if (md.getStatus()==1) {
                    tx1.setText("Name : "+md.getUserDetails().getName());
                    tx2.setText("Phone : "+md.getUserDetails().getMobile());
                    tx3.setText("Address : "+md.getUserDetails().getAddress());
                }
            }
        }).execute();

        tx4.setText("Total Price : "+tp);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                int id=sharedPreferences.getInt("id",0);
                Toast.makeText(Payment.this,""+id,Toast.LENGTH_LONG).show();
                String[] keys = new String[]{"mode","rid"};
                String[] values = new String[]{"Order", String.valueOf(id)};
                String jsonRequest = Utils.createJsonRequest(keys, values);
                Log.d("smit",jsonRequest);
                String url="https://sporticlan.000webhostapp.com/webservice.php";
                new WebserviceCall(Payment.this, url, jsonRequest, "Logging in", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                        Log.d("myapp", response);
                        Toast.makeText(Payment.this, "" + response, Toast.LENGTH_SHORT).show();
                        ModelOrder md = new Gson().fromJson(response, ModelOrder.class);

                        if (md.getStatus()==1) {
                            Toast.makeText(Payment.this, ""+md.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }).execute();


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Payment.this);
                alertDialogBuilder.setTitle("    Confirmation Order");
                alertDialogBuilder.setMessage("Your Order is successfully Placed..");
                        alertDialogBuilder.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(Payment.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                                        Intent i=new Intent(Payment.this,Slider.class);
                                        startActivity(i);
                                    }
                                });

               /* alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
*/
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                //alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.);



            }
        });
    }
}
