package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalshscreen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i =new Intent(SplashScreen.this,MainActivity.class);

                startActivity(i);
                finish();

            }
        },2000);
    }
}