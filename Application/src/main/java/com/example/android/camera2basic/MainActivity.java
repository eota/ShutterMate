package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.TapUserMessageTxt);
        startFadeInAnimation(text);

    }
    public void camera(View view){
        Intent i = new Intent(getApplicationContext(), CameraActivity.class);
        startActivity(i);
    }

    public void startFadeInAnimation(View view) {
        TextView t = text;
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        t.startAnimation(startAnimation);
    }

}
