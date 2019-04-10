package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;


public class MainActivity extends AppCompatActivity {
    private PublisherAdView mPublisherAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //size knight relative to screen size
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.widthPixels;
        int screenHeight = display.heightPixels;
        double knightWidth = screenWidth/1.7;
        double knightHeight = screenHeight/1.7;
        Bitmap knight = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.black_knight);
        Bitmap resizedKnight = Bitmap.createScaledBitmap(knight, (int)knightWidth, (int)knightHeight, true);
        //set imageView to the knight
        ImageView imageView = findViewById(R.id.knight_img);
        imageView.setImageBitmap(resizedKnight);
        //animating the title
        TextView title = findViewById(R.id.welcomeText);
        title.animate().alpha(1f).setDuration(1000).setStartDelay(500);
        //animating the imageview
        imageView.animate().alpha(1f).translationYBy(-100).setDuration(1000).setStartDelay(500);
        //animating the buttons
        Button cameraButton = findViewById(R.id.cameraButton);
        Button savedButton = findViewById(R.id.savedButton);
        cameraButton.animate().alpha(1f).setDuration(1000).setStartDelay(500);
        savedButton.animate().alpha(1f).setDuration(1000).setStartDelay(500);
        /*mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);*/
    }
    public void camera(View view){
        Intent i = new Intent(getApplicationContext(), CameraActivity.class);
        startActivity(i);
    }
    public void savedBoards(View view){
        Intent i = new Intent(getApplicationContext(), SavedBoardsActivity.class);
        startActivity(i);
    }
}
