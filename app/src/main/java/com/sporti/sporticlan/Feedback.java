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
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;


public class Feedback extends AppCompatActivity {
    RatingBar rate;
    Button bt;
    EditText ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        bt=(Button)findViewById(R.id.submit);
        rate=(RatingBar)findViewById(R.id.rating);
        ed=(EditText)findViewById(R.id.edit);


        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                String feedback = ed.getText().toString();
                Float rating = rate.getRating();

                if (feedback.isEmpty()) {
                    Toast.makeText(Feedback.this, " feedback cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                if (rating.equals("0")) {
                    Toast.makeText(Feedback.this, "Rating cannot be empty", Toast.LENGTH_SHORT).show();
                } else {


                    SharedPreferences sharedPreferences = getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                    int id = sharedPreferences.getInt("id", 0);
                    String[] key = new String[]{"mode", "rid", "feedback", "rate"};
                    String[] values = new String[]{"addFeedback", String.valueOf(id), feedback, String.valueOf(rating)};
                    String jsonRequest = Utils.createJsonRequest(key, values);
                    String url="https://sporticlan.000webhostapp.com/webservice.php";
                    Log.d("akjwd", jsonRequest);


                    new WebserviceCall(Feedback.this, url, jsonRequest, "Sign Up", true, new AsyncResponse() {
                        @Override
                        public void onCallback(String response) {
                            Log.d("myapp", response);
                            Toast.makeText(Feedback.this, "" + response, Toast.LENGTH_SHORT).show();

                            ModelFeedback ml = new Gson().fromJson(response, ModelFeedback.class);

                            if (ml.getStatus() == 1) {

                                Toast.makeText(Feedback.this, "" + ml.getMessage(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Feedback.this, Slider.class);
                                startActivity(intent);
                            }
                        }
                    }).execute();
                }
            }
        });
    }
}
