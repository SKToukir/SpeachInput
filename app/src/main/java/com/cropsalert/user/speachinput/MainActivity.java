package com.cropsalert.user.speachinput;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends ActionBarActivity implements Animation.AnimationListener{


    MediaPlayer mediaPlayer;

    Thread background;

    ImageView ivCircle1, ivCircle2,ivCircle3;
    static Animation rotateAnimation1;
    static Animation rotateAnimation2;
    static Animation rotateAnimation3;

    static Animation rotateAnimation4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCircle1 = (ImageView) findViewById(R.id.ivCircle1);
        ivCircle2 = (ImageView) findViewById(R.id.ivCircle2);
        ivCircle3 = (ImageView) findViewById(R.id.ivCircle3);
        rotateAnimation1 = AnimationUtils.loadAnimation(this, R.anim.rotate_animation_start);
        rotateAnimation2 = AnimationUtils.loadAnimation(this, R.anim.rotate_animation_start);
        rotateAnimation3 = AnimationUtils.loadAnimation(this, R.anim.rotate_animation_start);

        rotateAnimation4 = AnimationUtils.loadAnimation(this, R.anim.rotate_animation_end);



        ivCircle1.setVisibility(View.VISIBLE);

        ivCircle1.startAnimation(rotateAnimation1);
        rotateAnimation1.setAnimationListener(this);


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        ivCircle2.startAnimation(rotateAnimation2);
        rotateAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivCircle3.startAnimation(rotateAnimation3);
                rotateAnimation3.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ivCircle1.startAnimation(rotateAnimation1);
                        ivCircle3.startAnimation(rotateAnimation4);
                        ivCircle2.startAnimation(rotateAnimation4);
                        ivCircle1.startAnimation(rotateAnimation4);
                        rotateAnimation4.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Intent intent = new Intent(MainActivity.this, SpeechForCalling.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
