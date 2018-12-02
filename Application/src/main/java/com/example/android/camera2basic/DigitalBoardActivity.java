package com.example.android.camera2basic;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import static java.sql.Types.NULL;


public class DigitalBoardActivity extends AppCompatActivity {
    ImageView a1br;
    ImageView a1bn;
    ImageView a1bb;
    String path;
    Hashtable<String, Integer> squares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_board);
        squares = new Hashtable<>();
        TextView mTextView = findViewById(R.id.fenView);
        path = getIntent().getExtras().getString("path");
        mTextView.setText(path);
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void set(View view){
        setFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }

    public void sendImg(View v){
        path = getIntent().getExtras().getString("path");
        final TextView mTextView = findViewById(R.id.fenView);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://98.234.140.213/digitize?img=@";
        url = url + path;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        mTextView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        //GET /nextMove?fen=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR%20w%20KQkq%20-%200%201 HTTP/1.1
        //GET /nextMove?fen=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR%20w%20KQkq%20-%200%201 HTTP/1.1
        //GET /nextMove?fen=r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R%20w%20-%20-%200%201 HTTP/1.1

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void getBestMove(View v){
        final TextView mTextView = findViewById(R.id.fenView);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://98.234.140.213/nextMove?fen=r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R w - - 0 1";
        //url = url + "?fen=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        mTextView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        //GET /nextMove?fen=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR%20w%20KQkq%20-%200%201 HTTP/1.1
        //GET /nextMove?fen=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR%20w%20KQkq%20-%200%201 HTTP/1.1
        //GET /nextMove?fen=r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R%20w%20-%20-%200%201 HTTP/1.1

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void setFromFEN(String fen){
        String[] arr = fen.split("/");
        Character column;
        String[] rowChars;
        Integer row = 1;
        //for each row in the fen code
        for (int i = 0; i < arr.length; i++){
            column = 'a';
            rowChars = arr[i].split("");
            //for each piece in each row
            for (String piece : rowChars){
                if(row == 9 || column == 'i') {
                    break;
                }
                if(piece.length() == 0){
                    continue;
                }
                Character charPiece = piece.charAt(0);
                //if piece is an actual piece (a letter)
                if(Character.isLetter(charPiece)){
                    Log.d("fen", column.toString() + row + " is " + charPiece);
                    show(column.toString() + row, charToResource(charPiece));
                    column++;
                }
                //if piece is number
                if(Character.isDigit(charPiece)){
                    Log.d("fen", "skipping " + charPiece + " rows");
                    while(charPiece > '0'){
                        column++;
                        charPiece--;
                    }
                }
            }
            row++;
            if(row == 9) {
                break;
            }
        }
    }

    public Integer charToResource(Character piece){
        switch (piece){
            case 'r':
                return R.drawable.chess_rdt60;
            case 'n':
                return R.drawable.chess_ndt60;
            case 'b':
                return R.drawable.chess_bdt60;
            case 'q':
                return R.drawable.chess_qdt60;
            case 'k':
                return R.drawable.chess_kdt60;
            case 'p':
                return R.drawable.chess_pdt60;
            case 'R':
                return R.drawable.chess_rlt60;
            case 'N':
                return R.drawable.chess_nlt60;
            case 'B':
                return R.drawable.chess_blt60;
            case 'Q':
                return R.drawable.chess_qlt60;
            case 'K':
                return R.drawable.chess_klt60;
            case 'P':
                return R.drawable.chess_plt60;
            default:
                return 0;
        }
    }

    public void show(String squareStr, Integer piece){
        Integer square = getResId(squareStr, R.id.class);
        ImageView newPiece = new ImageView(DigitalBoardActivity.this);
        newPiece.setImageResource(piece);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        ConstraintSet set = new ConstraintSet();
        if(squares.containsKey(squareStr)){
            if(squares.get(squareStr) != 0) {
                ImageView oldPiece = findViewById(squares.get(squareStr));
                constraintLayout.removeView(oldPiece);
            }
        }
        constraintLayout.addView(newPiece);
        newPiece.setId(View.generateViewId());
        squares.put(squareStr, newPiece.getId());
        set.clone(constraintLayout);
        set.constrainHeight(newPiece.getId(),150);
        set.constrainWidth(newPiece.getId(),150);
        set.connect(newPiece.getId(), ConstraintSet.TOP, square, ConstraintSet.TOP, 0);
        set.connect(newPiece.getId(), ConstraintSet.RIGHT, square, ConstraintSet.RIGHT, 5);
        set.connect(newPiece.getId(), ConstraintSet.LEFT, square, ConstraintSet.LEFT, 0);
        set.connect(newPiece.getId(), ConstraintSet.BOTTOM, square, ConstraintSet.BOTTOM, 0);
        set.applyTo(constraintLayout);
        startFadeInAnimation(newPiece, newPiece); //Comment to disable fade-in
    }

    public void a1click(View view){
        ImageView square = findViewById(R.id.a1);
        square.setColorFilter(Color.argb(255, 255, 255, 255));
    }

    public void startFadeInAnimation(View view, ImageView iv) {
        View img = iv;
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation_short);
        img.startAnimation(startAnimation);
    }
}