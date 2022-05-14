package com.example.yatimjadid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends BaseActivity {

    final private static int splashTimeOut = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, SigninActivity.class);
                startActivity(i);
                finish();
//                getSupportFragmentManager().beginTransaction()
//                        .add(android.R.id.content, new YatimSelectionCriteriaFragment ()).commit();
            }
        }, splashTimeOut);
    }
}