package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread= new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    SharedPreferences sharedPreferences=getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                    int id=sharedPreferences.getInt("id",0);
                    if (id==0){
                        Intent i= new Intent(splash.this,Firstpage.class);
                        startActivity(i);
                    }else {
                        Intent i= new Intent(splash.this,Slider.class);
                        startActivity(i);
                    }

                }

            }
        };thread.start();

    }
}
