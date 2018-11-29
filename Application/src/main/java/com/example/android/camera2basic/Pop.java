package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class Pop extends AppCompatActivity {
    private static Integer piece = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        getWindow().setLayout(900,300);
    }

    public static Integer getPiece(){
        return piece;
    }

    public static void resetPiece(){
        piece = 0;
    }

    public void brook(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_rdt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bknight(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_ndt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bbishop(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_bdt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bqueen(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_qdt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bking(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_kdt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void bpawn(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_pdt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wrook(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_rlt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wknight(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_nlt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wbishop(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_blt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wqueen(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_qlt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wking(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_klt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void wpawn(View view){
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("piece", R.drawable.chess_plt60);
        resultIntent.putExtra("square", intent.getIntExtra("square", 0));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
