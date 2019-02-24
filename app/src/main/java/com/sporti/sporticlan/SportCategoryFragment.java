package com.sporti.sporticlan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Config;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sporti.sporticlan.AsyncTasks.AsyncResponse;
import com.sporti.sporticlan.AsyncTasks.WebserviceCall;
import com.sporti.sporticlan.Helper.Utils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportCategoryFragment extends Fragment {
    GridView l;
    custadpter cust;
    ArrayList<ModelCategory.CategoryListBean>data;

    public SportCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sport_category, container, false);

        l=(GridView)view.findViewById(R.id.list);
        String[] keys = new  String[]{"mode"} ;
        String[] values= new  String[]{"CategoryList"} ;
        String jsonRequest = Utils.createJsonRequest(keys, values);
// Toast.makeText(Category.this, ""+jsonRequest , Toast.LENGTH_SHORT).show();
          //  Log.d("req11",jsonRequest);
        String url = "https://sporticlan.000webhostapp.com/webservice.php";
             /*String url="http://192.168.2.13/web/webservice.php";*/

        new WebserviceCall(getContext(), url, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
             //   Log.d("myapp", response);
                //Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();
                final ModelCategory md = new Gson().fromJson(response, ModelCategory.class);

               if (md.getStatus().equalsIgnoreCase("1")) {
                    data = new ArrayList<>();
                 //  Log.d("size", String.valueOf(md.getCategoryList().size()));
                    for (int i = 0; i < md.getCategoryList().size(); i++) {
                        data.add(md.getCategoryList().get(i));
                       // Log.e("arry:::", String.valueOf(data));

                    }
                    cust = new custadpter(getContext(), R.layout.sportlist, data);
                    l.setAdapter(cust);

                    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Intent intent;

                            intent =  new Intent(getContext(), Sportproduct.class);
                            intent.putExtra("c_id",md.getCategoryList().get(i).getC_id());

                            startActivity(intent);
                        }
                    });
                }
            }
        }).execute();

        return view;
    }

}
