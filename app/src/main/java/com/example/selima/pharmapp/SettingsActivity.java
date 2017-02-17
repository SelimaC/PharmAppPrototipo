package com.example.selima.pharmapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.action_settings);

        ImageView notice = (ImageView) findViewById(R.id.notice);
        TextView notice_settings = (TextView) findViewById(R.id.notice_settings);

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.notice_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        notice_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.notice_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        ImageView help = (ImageView) findViewById(R.id.help);
        TextView help_settings = (TextView) findViewById(R.id.help_settings);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.help_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        help_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.help_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });


        ImageView profile = (ImageView) findViewById(R.id.profile);
        TextView profile_settings = (TextView) findViewById(R.id.profile_settings);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.profile_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        profile_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.profile_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        ImageView jolly = (ImageView) findViewById(R.id.jolly);
        TextView jolly_settings = (TextView) findViewById(R.id.jolly_settings);
        ImageView info = (ImageView) findViewById(R.id.info);
        jolly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.jolly_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        jolly_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.jolly_settings, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingsActivity.this);
                builder1.setTitle(R.string.title);
                builder1.setMessage(R.string.message);
                builder1.setCancelable(true);
                builder1.setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
