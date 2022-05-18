package com.example.yatimjadid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenActivity extends BaseActivity {

    final private static int splashTimeOut = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                } else {
                    Intent i = new Intent(SplashScreenActivity.this, SigninActivity.class);
                    startActivity(i);
                }
                finish();


//                getSupportFragmentManager().beginTransaction()
//                        .add(android.R.id.content, new YatimSelectionCriteriaFragment ()).commit();
            }
        }, splashTimeOut);
    }
}