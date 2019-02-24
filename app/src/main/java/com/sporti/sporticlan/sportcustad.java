package com.sporti.sporticlan;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.security.AccessControlContext;
import java.util.ArrayList;

/**
 * Created by smit on 2/6/2018.
 */

class sportcustad extends BaseAdapter {
    Context con;
    int layout;
    ArrayList<ModelProduct.ProductListBean>arrayListData;
    LayoutInflater i;


    public sportcustad(Sportproduct sportproduct, int sportlist, ArrayList<ModelProduct.ProductListBean> data) {

        this.con=sportproduct;
        this.layout=sportlist;
        this.arrayListData=data;
    }



    @Override
    public int getCount() {
        return arrayListData.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=i.from(con).inflate(layout,null);
        ImageView iv=(ImageView)convertView.findViewById(R.id.image123);
        TextView tx=(TextView)convertView.findViewById(R.id.text);
        tx.setText(arrayListData.get(position).getP_name().toString());
        String r=arrayListData.get(position).getP_image1().toString();
        String a=r.trim().replace("\\","");

       // Log.e("imageval",a);
        //Toast.makeText(con, ""+a, Toast.LENGTH_SHORT).show();
        // Picasso.with(context).load(a).into(iv);
        if(a!=null)
        {
            Glide.with(con)
                    .load(a)
                    .placeholder(R.drawable.teniss)
                    .override(200,200)
                    .centerCrop()
                    .into(iv);
        }
        return convertView;
    }
}
