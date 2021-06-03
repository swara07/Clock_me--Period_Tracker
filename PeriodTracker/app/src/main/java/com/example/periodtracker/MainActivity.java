package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int i=RegisterActivity.num;
        Log.d("num",RegisterActivity.num+"");
        SessionManagement ss=new SessionManagement(MainActivity.this);
        final String check =ss.getSesion();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!check.equals("-1")){

                    Intent homeIntent= new Intent(new Intent(MainActivity.this,navBar.class));
                    startActivity(homeIntent);
                    finish();
                }
                else{
                    Intent homeIntent= new Intent(new Intent(MainActivity.this,RegisterActivity.class));
                    startActivity(homeIntent);
                    finish();
                }

            }
        },4000);

    }

    }
