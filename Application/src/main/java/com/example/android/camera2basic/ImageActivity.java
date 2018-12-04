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
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

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
        Log.d("imageToDigi", pic.getAbsolutePath());
        final Intent i = new Intent(getApplicationContext(), DigitalBoardActivity.class);
        i.putExtra("pic", pic);
        i.putExtra("path", pic.getAbsolutePath());
        String str = "img";
        final TextView tv = findViewById(R.id.textView);
        tv.setText("Sending data...");
        MultipartRequest multipartRequest = new MultipartRequest("http://100.64.112.41:8080/digitize",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv.setText("error!");
                        Log.d("img", "That didn't work!");
                    }
                },
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        tv.setText(response);
                        i.putExtra("boardstate", response);
                        startActivity(i);
                    }
                }, pic, str);
        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(
                100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(multipartRequest);
    }
}

