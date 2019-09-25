package com.xbcad.goalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //_________________________code attribution_______________________
                // The following method was taken from youtube:
                //Author : Sabith Pkc Mnr
                //Link: https://www.youtube.com/watch?v=jXtof6OUtcE
                setContentView(R.layout.activity_main);

                logo = findViewById(R.id.iv_Logo);

                hideNavigationBar();

                Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
                logo.startAnimation(fadeIn);

                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        //Opens the Login activity which allows for users to input their username and password
                        Intent homeIntent = new Intent(MainActivity.this, AuthActivity.class);
                        startActivity(homeIntent);
                        finish();
                    }
                },SPLASH_TIME_OUT);
                //_______________________end_______________________________________
            }

            private void hideNavigationBar() {
                this.getWindow().getDecorView()
                        .setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_FULLSCREEN|
                                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        );
            }
    }
