package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;


public class MainActivity extends AppCompatActivity {
    private PublisherAdView mPublisherAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);
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
