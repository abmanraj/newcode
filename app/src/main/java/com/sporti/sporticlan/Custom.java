package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

import java.util.ArrayList;

/**
 * Created by smit on 4/3/2018.
 */

public class Custom extends BaseAdapter {
    Context context;
    ArrayList<ModelList.OrderDetailBean> orderDetailBeen;
    int cartview;
    LayoutInflater inflater;
    String sp_id;


    public Custom(Cart cart, int cartview, ArrayList<ModelList.OrderDetailBean> orderDetailBeen) {
        this.context = cart;
        this.cartview = cartview;
        this.orderDetailBeen = orderDetailBeen;
    }


    @Override
    public int getCount() {
        return orderDetailBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView=inflater.from(context).inflate(cartview,null);

        ImageView imageView=(ImageView)convertView.findViewById(R.id.cartimg);
        TextView textView=(TextView)convertView.findViewById(R.id.iname);
        TextView textView1=(TextView)convertView.findViewById(R.id.iprice);
        TextView textView2=(TextView)convertView.findViewById(R.id.iqty);
        Button bt=(Button)convertView.findViewById(R.id.remove);

        textView.setText("Name:"+orderDetailBeen.get(position).getSp_name().toString());
        textView1.setText("Price:"+orderDetailBeen.get(position).getTotal_price());
        textView2.setText("Quantity:"+orderDetailBeen.get(position).getUnit());

        String r=orderDetailBeen.get(position).getSp_image();
        String a=r.trim().replace("\\","");

        Log.e("imageval",a);
        //Toast.makeText(context, ""+a, Toast.LENGTH_SHORT).show();
        // Picasso.with(context).load(a).into(iv);
        Glide.with(context)
                .load(a)
                .placeholder(R.drawable.teniss)
                .override(200,200)
                .centerCrop()
                .into(imageView);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp_id=String.valueOf(orderDetailBeen.get(position).getSp_id());
               // Toast.makeText(context, ""+sp_id, Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = context.getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
                int id = sharedPreferences.getInt("id", 0);
                String[] key = new String[]{"mode", "rid", "sp_id"};
                String[] values = new String[]{"removeCartItem", String.valueOf(id), String.valueOf(sp_id)};
                String jsonRequest = Utils.createJsonRequest(key, values);
                Log.d("rj",jsonRequest);
                String url="https://sporticlan.000webhostapp.com/webservice.php";

                new WebserviceCall(context, url, jsonRequest, "Sign Up", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                      //  Log.d("myapp", response);
                       // Toast.makeText(context, "" + response, Toast.LENGTH_SHORT).show();

                        ModelRemove mr = new Gson().fromJson(response, ModelRemove.class);

                        if (mr.getStatus() == 1) {
                           // Toast.makeText(context, "" + mr.getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(context,Cart.class);
                            context.startActivity(intent);
                        }

                    }
                }).execute();
            }

        });
        return convertView;
    }




}
