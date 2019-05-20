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


public class Pop extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

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
    }

    public void brook(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'r');
        resultIntent.putExtra("pieceInt", R.drawable.chess_rdt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bknight(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'n');
        resultIntent.putExtra("pieceInt", R.drawable.chess_ndt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bbishop(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'b');
        resultIntent.putExtra("pieceInt", R.drawable.chess_bdt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bqueen(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'q');
        resultIntent.putExtra("pieceInt", R.drawable.chess_qdt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bking(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'k');
        resultIntent.putExtra("pieceInt", R.drawable.chess_kdt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bpawn(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'p');
        resultIntent.putExtra("pieceInt", R.drawable.chess_pdt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wrook(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'R');
        resultIntent.putExtra("pieceInt", R.drawable.chess_rlt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wknight(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'N');
        resultIntent.putExtra("pieceInt", R.drawable.chess_nlt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wbishop(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'B');
        resultIntent.putExtra("pieceInt", R.drawable.chess_blt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wqueen(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'Q');
        resultIntent.putExtra("pieceInt", R.drawable.chess_qlt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wking(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'K');
        resultIntent.putExtra("pieceInt", R.drawable.chess_klt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wpawn(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", 'P');
        resultIntent.putExtra("pieceInt", R.drawable.chess_plt);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void delete(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pieceChar", '0');
        resultIntent.putExtra("pieceInt", 0);
        resultIntent.putExtra("squareInt", intent.getIntExtra("squareInt", 0));
        resultIntent.putExtra("squareStr", intent.getStringExtra("squareStr"));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
