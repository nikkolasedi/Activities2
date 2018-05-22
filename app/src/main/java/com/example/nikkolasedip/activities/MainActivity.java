package com.example.nikkolasedip.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity


        implements NavigationView.OnNavigationItemSelectedListener {

    private ShareActionProvider mShareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                share();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openSetting();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu1) {
            //open screen2
            changeGif("giphy1");


        } else if (id == R.id.menu2) {
            changeGif("giphy2");

        } else if (id == R.id.menu3) {
            changeGif("giphy3");


        } else if (id == R.id.menu4) {
            changeGif("giphy4");


        } else if (id == R.id.menu5) {
            changeGif("giphy5");

        } else if (id == R.id.menu6) {
            changeGif("giphy6");

        } else if (id == R.id.menu7) {
            openActivity2();
        } else if (id == R.id.menu8) {
            openActivity3();
        } else if (id == R.id.menu9) {
            openActivityAd();

    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

    }

    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);

    }

    public void openActivityAd() {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void openSetting() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void changeGif(String gifName) {
        int resID = getResources().getIdentifier(gifName,
                "drawable", getPackageName());
        GifImageView gifImageView = (GifImageView) findViewById(R.id.gif_image_view);
        gifImageView.setImageResource(resID);
    }


    private Uri imageUri;
    private Intent intent;
    String mLastResourceId;
    public void setImageResourceId(int resId) {
        mLastResourceId = getResources().getResourceEntryName(resId);
    }
    public void share() {


        imageUri = Uri.parse("android.resource://com.example.nikkolasedip.activities/" + R.drawable.gif);

        intent = new Intent(Intent.ACTION_SEND);
//image
        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
//type of things
        intent.setType("image/*");
        //sending
        startActivity(intent);
    }




}
