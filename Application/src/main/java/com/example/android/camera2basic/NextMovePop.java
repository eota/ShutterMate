package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;


public class NextMovePop extends AppCompatActivity {


    Switch bkingSwitch;
    Switch bqueenSwitch;
    Switch wkingSwitch;
    Switch wqueenSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nextmovepop);

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.widthPixels;
        int screenHeight = display.heightPixels;
        double popHeight = screenHeight/3.15;
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = screenWidth;
        params.height = 300;
        params.y = (int)popHeight;
        getWindow().setAttributes(params);

        bkingSwitch = findViewById(R.id.bkingswitch);
        bqueenSwitch = findViewById(R.id.bqueenswitch);
        wkingSwitch = findViewById(R.id.wkingswitch);
        wqueenSwitch = findViewById(R.id.wqueenswitch);

    }

    public void whiteMove(View view){
        Intent i = new Intent(this, DigitalBoardActivity.class);
        i.putExtra("wqSwitch", wqueenSwitch.isChecked());
        i.putExtra("wkSwitch", wkingSwitch.isChecked());
        i.putExtra("bqSwitch", bqueenSwitch.isChecked());
        i.putExtra("bkSwitch", bkingSwitch.isChecked());
        i.putExtra("whiteTurn", true);
        setResult(2, i);
        finish();
    }

    public void blackMove(View view){
        Intent i = new Intent(this, DigitalBoardActivity.class);
        i.putExtra("wqSwitch", wqueenSwitch.isChecked());
        i.putExtra("wkSwitch", wkingSwitch.isChecked());
        i.putExtra("bqSwitch", bqueenSwitch.isChecked());
        i.putExtra("bkSwitch", bkingSwitch.isChecked());
        i.putExtra("whiteTurn", false);
        setResult(2, i);
        finish();
    }

}
