package com.sporti.sporticlan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Slider extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SportCategoryFragment fragment=new SportCategoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mybutton) {
            SharedPreferences sharedPreferences = getSharedPreferences("UserDetail", Context.MODE_PRIVATE);
            id = sharedPreferences.getInt("id", 0);
            Intent i=new Intent(Slider.this,Cart.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.live) {
            WebLiveFragment fragment=new WebLiveFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            SportCategoryFragment fragment=new SportCategoryFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
        } else if (id == R.id.nav_change) {
            Intent i=new Intent(Slider.this,Changepassword.class);
            startActivity(i);
        } else if (id == R.id.nav_edprofile) {
            Intent i=new Intent(Slider.this,profilescreen.class);
            startActivity(i);
        } else if (id == R.id.nav_feedback) {
            Intent i=new Intent(Slider.this,Feedback.class);
            startActivity(i);

        } else if (id == R.id.nav_about) {
            Intent i=new Intent(Slider.this,Aboutus.class);
            startActivity(i);
        }
        else if (id == R.id.nav_logout) {
            getSharedPreferences("UserDetail", Context.MODE_PRIVATE).edit().clear().apply();
            Intent i=new Intent(Slider.this,Login.class);
            startActivity(i);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
