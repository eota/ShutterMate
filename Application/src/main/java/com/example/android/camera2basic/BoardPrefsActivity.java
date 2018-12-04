package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class BoardPrefsActivity extends AppCompatActivity {

    protected Button whiteBtn;
    protected Button blackBtn;
    protected Drawable whiteSelected;
    protected Drawable whiteDeselected;
    protected Drawable blackSelected;
    protected Drawable blackDeselected;
    protected Switch wq;
    protected Switch wk;
    protected Switch bq;
    protected Switch bk;
    private boolean whitePressed;
    private boolean blackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_prefs);
        whiteBtn = findViewById(R.id.whiteBtn);
        blackBtn = findViewById(R.id.blackBtn);
        wq = findViewById(R.id.wqswitch);
        wk = findViewById(R.id.wkswitch);
        bq = findViewById(R.id.bqswitch);
        bk = findViewById(R.id.bkswitch);
        whiteSelected = getDrawable(R.drawable.whitemovebtnselected);
        whiteDeselected = getDrawable(R.drawable.whitemovebtn);
        blackSelected = getDrawable(R.drawable.blackmovebtnselected);
        blackDeselected = getDrawable(R.drawable.blackmovebtn);
        whitePressed = true;
        blackPressed = false;
        whiteBtn.setBackground(whiteSelected);
        blackBtn.setBackground(blackDeselected);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        getWindow().setLayout(width,height);
    }

    public void onWhitePressed(View view){
        whitePressed = true;
        blackPressed = false;
        if(whitePressed){
            whiteBtn.setBackground(whiteSelected);
            blackBtn.setBackground(blackDeselected);
        } else {
            whiteBtn.setBackground(whiteDeselected);
            blackBtn.setBackground(blackSelected);
        }
        //more stuff
    }

    public void onBlackPressed(View view){
        blackPressed = true;
        whitePressed = false;
        if(blackPressed){
            blackBtn.setBackground(blackSelected);
            whiteBtn.setBackground(whiteDeselected);
        } else {
            blackBtn.setBackground(blackDeselected);
            whiteBtn.setBackground(whiteSelected);
        }
        //more stuff
    }

    public void onGoPressed(View view){
        // if white turn -> evaluate white
        // if black turn -> evaluate black
        Intent i = new Intent(this, DigitalBoardActivity.class);
        i.putExtra("wqSwitch", wq.isChecked());
        i.putExtra("wkSwitch", wk.isChecked());
        i.putExtra("bqSwitch", bq.isChecked());
        i.putExtra("bkSwitch", bk.isChecked());
        i.putExtra("whiteTurn", whitePressed);
        setResult(2, i);
        finish();
        //startActivityForResult(i, 2);
    }

    public void cameraPressed(View view){
        Intent i = new Intent(this, CameraActivity.class);
        startActivity(i);
    }
}