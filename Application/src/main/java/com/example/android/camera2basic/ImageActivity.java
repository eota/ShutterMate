package com.example.android.camera2basic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class ImageActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.imageView);
        File pic = (File) getIntent().getExtras().get("pic.jpg");
        imageView.setImageURI(Uri.fromFile(pic));
    }
    public void board(View v){
        Intent i = new Intent(getApplicationContext(), DigitalBoardActivity.class);
        File pic = (File) getIntent().getExtras().get("pic.jpg");
        Log.d("imageToDigi", pic.getAbsolutePath());
        i.putExtra("pic", pic);
        i.putExtra("path", pic.getAbsolutePath());
        startActivity(i);
    }

}
