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
import android.widget.LinearLayout;
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
        Bitmap knight = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.gradient_knight);
        double oldKnightHeight = knight.getHeight();
        double oldKnightWidth = knight.getWidth();

        //set the height of the knight relative to the screen size
        double newKnightHeight = screenHeight/1.7;

        //find the amount the knight was scaled down (or up) to multiply the width by -- to maintain aspect ratio
        double knightScale = newKnightHeight/oldKnightHeight;
        double newKnightWidth = oldKnightWidth * knightScale;
        Bitmap resizedKnight = Bitmap.createScaledBitmap(knight, (int)newKnightWidth, (int)newKnightHeight, true);

        //set imageView to the knight
        ImageView imageView = findViewById(R.id.knight_img);
        imageView.setImageBitmap(resizedKnight);



        //set padding on title
        TextView title = findViewById(R.id.welcomeText);
        title.setPadding(0,screenHeight/35, 0, 0);

        //animate the title
        title.animate().alpha(1f).setDuration(500).setStartDelay(100);

        //animate the image view
        imageView.animate().alpha(1f).translationYBy(-100).setDuration(500).setStartDelay(100);


//        //set shadow relative to knight
//        Bitmap shadow = BitmapFactory.decodeResource(getApplicationContext().getResources(),
//                R.drawable.shadow);
//        double oldShadowHeight = shadow.getHeight();
//        double oldShadowWidth = shadow.getWidth();
//        double newShadowHeight = screenHeight/14;
//        double newShadowWidth = screenWidth/1.5;
//        Bitmap resizedShadow = Bitmap.createScaledBitmap(shadow, (int)newShadowWidth, (int)newShadowHeight, true);
//        ImageView shadowView = findViewById(R.id.shadow_img);
//        shadowView.setImageBitmap(resizedShadow);
//        //animate the image view
//        shadowView.animate().alpha(1f).translationYBy(-100).setDuration(500).setStartDelay(100);

        //set bottom padding of buttons
        LinearLayout buttonsLayout = findViewById(R.id.buttonsLinearLayout);
        buttonsLayout.setPadding(0,0, 0, screenHeight/35);

        //animate the buttons
        Button cameraButton = findViewById(R.id.cameraButton);
        Button savedButton = findViewById(R.id.savedButton);
        cameraButton.animate().alpha(1f).setDuration(500).setStartDelay(100);
        savedButton.animate().alpha(1f).setDuration(500).setStartDelay(100);

        /*mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);*/
    }
    public void camera(View view){
        Intent i = new Intent(getApplicationContext(), CameraActivity.class);
        //Intent i = new Intent(getApplicationContext(), DigitalBoardActivity.class);
        startActivity(i);
    }
    public void savedBoards(View view){
        Intent i = new Intent(getApplicationContext(), SavedBoardsActivity.class);
        startActivity(i);
    }
}
