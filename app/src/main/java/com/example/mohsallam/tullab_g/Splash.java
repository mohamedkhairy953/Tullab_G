package com.example.mohsallam.tullab_g;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


/**
 * Created by KhAiry on 6/6/2018.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        updateResources(this,"ar");

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, NavigationActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 3000);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private static void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = res.getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            config.setLayoutDirection(locale);

        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
    }
}
