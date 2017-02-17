package com.example.selima.pharmapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /* This code is used to show WelcomeActivity only once, when the app is started*/
        SharedPreferences pref = getSharedPreferences("ActivityPREF",    Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){

        } else {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
            finish();
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();
        }

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        if (savedInstanceState == null)
        {
           transaction.add(R.id.container, new TodayFragment(),"TODAY").commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.today);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent i = new Intent(getApplicationContext(), NewOccasionalMedicineActivity.class);
                startActivityForResult(i, 1);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Log.d("FRAGMENT", "f : "+ getActiveFragment());
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        String tag = "";
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (id == R.id.nav_today) {
            fragment = new TodayFragment();
            tag = "TODAY";
            getSupportActionBar().setTitle(R.string.today);
            fab.show();
            fab.setImageResource(android.R.drawable.ic_menu_edit);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), NewOccasionalMedicineActivity.class);
                    startActivityForResult(i, 1);
                }
            });
        } else if (id == R.id.nav_teraphy) {
            fragment = new TherapyFragment();
            tag = "THERAPY";
            getSupportActionBar().setTitle(R.string.teraphy);
            fab.show();
            fab.setImageResource(R.drawable.plus);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), NewTeraphyActivity.class);
                    startActivityForResult(i, 2);
                }
            });
        } else if (id == R.id.nav_journey) {
            fragment = new JourneyFragment();
            tag = "JOURNEY";
            getSupportActionBar().setTitle(R.string.journey);
            fab.hide();
        } else if (id == R.id.nav_doctors) {
            fragment = new DoctorsFragment();
            tag = "DOCTORS";
            getSupportActionBar().setTitle(R.string.doctors);
            fab.show();
            fab.setImageResource(R.drawable.plus);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 Snackbar.make(view, R.string.newDoctor, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }
            });
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivityForResult(i, 5);
        }

        if(!tag.equals("")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment, tag).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onResume(){
        super.onResume();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new TodayFragment(),"TODAY").commit();
        getSupportActionBar().setTitle(R.string.today);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewOccasionalMedicineActivity.class);
                startActivityForResult(i, 1);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        switch (requestCode){
            case 1:
                transaction.replace(R.id.container, new TodayFragment(),"TODAY").commit();
                getSupportActionBar().setTitle(R.string.today);

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), NewOccasionalMedicineActivity.class);
                        startActivityForResult(i, 1);
                    }
                });

                navigationView.getMenu().getItem(0).setChecked(true);
            case 2:
                transaction.replace(R.id.container, new TherapyFragment(),"THERAPY").commit();
                getSupportActionBar().setTitle(R.string.teraphy);

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), NewOccasionalMedicineActivity.class);
                        startActivityForResult(i, 2);
                    }
                });

                navigationView.getMenu().getItem(1).setChecked(true);

            case 5:
                transaction.replace(R.id.container, new TodayFragment(),"TODAY").commit();
                getSupportActionBar().setTitle(R.string.today);

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), NewOccasionalMedicineActivity.class);
                        startActivityForResult(i, 1);
                    }
                });

                navigationView.getMenu().getItem(0).setChecked(true);
            default:
        }
    }

}
