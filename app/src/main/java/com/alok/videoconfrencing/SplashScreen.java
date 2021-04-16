package com.alok.videoconfrencing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static final String TAG = "SplashScreen";
    private static final int SPLASH_TIME_OUT = 3000;
    private final Context context = this;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash_screen );

        new Handler ( ).postDelayed ( () -> {
            startActivity ( new Intent ( context , MainActivity.class ) );
            finish ( );
        } , SPLASH_TIME_OUT );

    }
}