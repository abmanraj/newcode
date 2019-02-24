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

import java.util.ArrayList;

/**
 * Created by smit on 2/1/2018.
 */

class custadpter extends BaseAdapter {
    int layout;
    ArrayList<ModelCategory.CategoryListBean>arrayList;
    LayoutInflater inflater;
    Context context;




    public custadpter(Context context, int sportlist, ArrayList<ModelCategory.CategoryListBean> data) {
        this.context=context;
        this.layout=sportlist;
        this.arrayList=data;
    }


    @Override
    public int getCount() {
        return arrayList.size();
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
        convertView=inflater.from(context).inflate(layout,null);
        ImageView iv=(ImageView)convertView.findViewById(R.id.image123);
        TextView tx=(TextView)convertView.findViewById(R.id.text);
        tx.setText(arrayList.get(position).getC_name().toString());

//        Picasso.with(context).load(arrayList.get(position).getC_image()).into(iv);
       String r=arrayList.get(position).getC_image().toString();
        String a=r.trim().replace("\\","");

       //Log.e("imageval",a);
      //  Toast.makeText(context, ""+a, Toast.LENGTH_SHORT).show();
       // Picasso.with(context).load(a).into(iv);
        Glide.with(context)
                .load(a)
                .placeholder(R.drawable.teniss)
                .override(200,200)
                .centerCrop()
                .into(iv);
        return convertView;
    }
}
