package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.databinding.ActivitySplashBinding;

import static com.apps.cyberco2.unfaded.utils.Constants.SPLASH_TIME;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent main = new Intent(Splash.this, SelectAccountActivity.class);
                                    startActivity(main);
                                    finish();

                                }
                            }, SPLASH_TIME
        );
    }
}
