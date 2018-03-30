package com.smit.sporticlan;

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

import java.util.ArrayList;

/**
 * Created by smit on 2/7/2018.
 */

class subproduct extends BaseAdapter {
    Context context;
    int layot;
    LayoutInflater inflater;
    ArrayList<ModelSubProduct.SubproductListBean>arrayListData;

    public subproduct(Sportssubproduct sportssubproduct, int spots_sub_product, ArrayList<ModelSubProduct.SubproductListBean> data) {
        this.context=sportssubproduct;
        this.layot=spots_sub_product;
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
        convertView=inflater.from(context).inflate(layot,null);
        ImageView iv=(ImageView)convertView.findViewById(R.id.imagesm);
        TextView tx1=(TextView)convertView.findViewById(R.id.name);
        TextView tx2=(TextView)convertView.findViewById(R.id.descripsion);
        TextView tx3=(TextView)convertView.findViewById(R.id.price);

        tx1.setText("Name : "+arrayListData.get(position).getSp_name().toString());
        tx2.setText("Discription : "+arrayListData.get(position).getSp_dis().toString());
        tx3.setText("Price : "+arrayListData.get(position).getSp_price());
        String r=arrayListData.get(position).getSp_image().toString();
        String a=r.trim().replace("\\","");

        Log.e("imageval",a);
        Toast.makeText(context, ""+a, Toast.LENGTH_SHORT).show();
        // Picasso.with(context).load(a).into(iv);
        if(a!=null)
        {
            Glide.with(context)
                    .load(a)
                    .placeholder(R.drawable.teniss)
                    .override(200,200)
                    .centerCrop()
                    .into(iv);
        }
        return convertView;
    }
}
