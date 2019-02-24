package com.sporti.sporticlan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebLiveFragment extends Fragment {
WebView w;

    public WebLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_web_live, container, false);
       w=(WebView)view.findViewById(R.id.web);
        w.loadUrl("http:www.cricbuzz.com");
        w.setWebViewClient(new WebViewClient());
        return view;
    }

}
