package com.smit.sporticlan;

import android.content.Intent;
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
                    Intent i= new Intent(splash.this,Firstpage.class);
                    startActivity(i);
                }

            }
        };thread.start();

    }
}
