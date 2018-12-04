package com.example.android.camera2basic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import static java.sql.Types.NULL;
class Highlight {
    public static Integer highlighted = 0;

    static public void setHighlight(Integer square){
        highlighted = square;
    }

    static public Integer getHighlight(){
        return highlighted;
    }
}

public class DigitalBoardActivity extends AppCompatActivity {
    ImageView a1;
    ImageView a2;
    ImageView a3;
    ImageView a4;
    ImageView a5;
    ImageView a6;
    ImageView a7;
    ImageView a8;
    ImageView b1;
    ImageView b2;
    ImageView b3;
    ImageView b4;
    ImageView b5;
    ImageView b6;
    ImageView b7;
    ImageView b8;
    ImageView c1;
    ImageView c2;
    ImageView c3;
    ImageView c4;
    ImageView c5;
    ImageView c6;
    ImageView c7;
    ImageView c8;
    ImageView d1;
    ImageView d2;
    ImageView d3;
    ImageView d4;
    ImageView d5;
    ImageView d6;
    ImageView d7;
    ImageView d8;
    ImageView e1;
    ImageView e2;
    ImageView e3;
    ImageView e4;
    ImageView e5;
    ImageView e6;
    ImageView e7;
    ImageView e8;
    ImageView f1;
    ImageView f2;
    ImageView f3;
    ImageView f4;
    ImageView f5;
    ImageView f6;
    ImageView f7;
    ImageView f8;
    ImageView g1;
    ImageView g2;
    ImageView g3;
    ImageView g4;
    ImageView g5;
    ImageView g6;
    ImageView g7;
    ImageView g8;
    ImageView h1;
    ImageView h2;
    ImageView h3;
    ImageView h4;
    ImageView h5;
    ImageView h6;
    ImageView h7;
    ImageView h8;
    Hashtable<String, Integer> squareIds;
    Hashtable<String, Character> squareChars;

    private LineView lv;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("result", "in result");
        if (requestCode == 1) {
            Log.d("result", "code was 1");
            if (resultCode == RESULT_OK) {
                Log.d("result", "result ok");
                Character pieceChar = data.getCharExtra("pieceChar", '0');
                Integer piece = data.getIntExtra("pieceInt",0);
                Integer square = data.getIntExtra("square",0);

                if(piece == 0){
                    wipeSquare(squareResToString(square));
                    ImageView old = findViewById(Highlight.highlighted);
                    old.setColorFilter(null);
                    Highlight.setHighlight(0);
                }
                else{
                    Log.d("show", "showing now " + pieceChar);
                    showFromIdChar(square, pieceChar);
                    ImageView old = findViewById(Highlight.highlighted);
                    old.setColorFilter(null);
                    Highlight.setHighlight(0);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_board);
        TextView text = findViewById(R.id.activeFen);
        squareIds = new Hashtable<>();
        squareChars = new Hashtable<>();
        String fen = getIntent().getExtras().getString("boardstate");
        setFromFEN(fen);
        text.setText("Boardstate set!");
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer square = squareOnClick(view);
                Highlight.setHighlight(square);
                Intent i = new Intent(DigitalBoardActivity.this, Pop.class);
                i.putExtra("square", square);
                startActivityForResult(i, 1);
            }
        };
        squareIds = new Hashtable<>();
        squareChars = new Hashtable<>();
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);
        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        g4 = findViewById(R.id.g4);
        g5 = findViewById(R.id.g5);
        g6 = findViewById(R.id.g6);
        g7 = findViewById(R.id.g7);
        g8 = findViewById(R.id.g8);
        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        h7 = findViewById(R.id.h7);
        h8 = findViewById(R.id.h8);
        a1.setOnClickListener(listener);
        a2.setOnClickListener(listener);
        a3.setOnClickListener(listener);
        a4.setOnClickListener(listener);
        a5.setOnClickListener(listener);
        a6.setOnClickListener(listener);
        a7.setOnClickListener(listener);
        a8.setOnClickListener(listener);
        b1.setOnClickListener(listener);
        b2.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        b4.setOnClickListener(listener);
        b5.setOnClickListener(listener);
        b6.setOnClickListener(listener);
        b7.setOnClickListener(listener);
        b8.setOnClickListener(listener);
        c1.setOnClickListener(listener);
        c2.setOnClickListener(listener);
        c3.setOnClickListener(listener);
        c4.setOnClickListener(listener);
        c5.setOnClickListener(listener);
        c6.setOnClickListener(listener);
        c7.setOnClickListener(listener);
        c8.setOnClickListener(listener);
        d1.setOnClickListener(listener);
        d2.setOnClickListener(listener);
        d3.setOnClickListener(listener);
        d4.setOnClickListener(listener);
        d5.setOnClickListener(listener);
        d6.setOnClickListener(listener);
        d7.setOnClickListener(listener);
        d8.setOnClickListener(listener);
        e1.setOnClickListener(listener);
        e2.setOnClickListener(listener);
        e3.setOnClickListener(listener);
        e4.setOnClickListener(listener);
        e5.setOnClickListener(listener);
        e6.setOnClickListener(listener);
        e7.setOnClickListener(listener);
        e8.setOnClickListener(listener);
        f1.setOnClickListener(listener);
        f2.setOnClickListener(listener);
        f3.setOnClickListener(listener);
        f4.setOnClickListener(listener);
        f5.setOnClickListener(listener);
        f6.setOnClickListener(listener);
        f7.setOnClickListener(listener);
        f8.setOnClickListener(listener);
        g1.setOnClickListener(listener);
        g2.setOnClickListener(listener);
        g3.setOnClickListener(listener);
        g4.setOnClickListener(listener);
        g5.setOnClickListener(listener);
        g6.setOnClickListener(listener);
        g7.setOnClickListener(listener);
        g8.setOnClickListener(listener);
        h1.setOnClickListener(listener);
        h2.setOnClickListener(listener);
        h3.setOnClickListener(listener);
        h4.setOnClickListener(listener);
        h5.setOnClickListener(listener);
        h6.setOnClickListener(listener);
        h7.setOnClickListener(listener);
        h8.setOnClickListener(listener);

        lv = findViewById(R.id.lineView);
        PointF p1 = new PointF(0,0);
        PointF p2 = new PointF(0,0);
        lv.setPointA(p1);
        lv.setPointB(p2);
    }

    public String getFen(){
        String fen = "";
        Integer counter = 0;
        String square;
        //for each row
        for(Integer row = 8; row > 0; row--){
            //for each column
            for(Character column = 'a'; column < 'i'; column++){
                square = column.toString() + row;
                //if the square contains anything
                if(squareChars.containsKey(square)){
                    if(squareChars.get(square)!='0') {
                        //append and then reset the counter
                        if (counter != 0) {
                            fen = fen + counter;
                            counter = 0;
                        }
                        //append the piece
                        fen = fen + squareChars.get(square);
                    }
                    else{
                        counter++;
                    }
                }
                //if the square is empty just increment the counter
                else{
                    counter++;
                }
            }
            if(counter != 0){
                fen = fen + counter;
                counter = 0;
            }
            if(row > 1) {
                fen = fen + '/';
            }
        }
        fen = fen.trim();
        return fen;
    }

    public void getBestMoveWhite(){
        final TextView mTextView = findViewById(R.id.activeFen);
        Switch castlewk = findViewById(R.id.wkswitch);
        Switch castlewq = findViewById(R.id.wqswitch);
        Switch castlebk = findViewById(R.id.bkswitch);
        Switch castlebq = findViewById(R.id.bqswitch);
        RequestQueue queue = Volley.newRequestQueue(this);
        String fen = getFen();
        Log.d("white", fen);
        String url ="http://100.64.112.41:8080/nextMove?fen=";
        url = url + fen;
        url = url + "%20w%20";
        if(castlewk.isChecked()){
            url = url + "K";
        }
        if(castlewq.isChecked()){
            url = url + "Q";
        }
        if(castlebk.isChecked()){
            url = url + "k";
        }
        if(castlebq.isChecked()){
            url = url + "q";
        }
        if(!castlewk.isChecked() && !castlewq.isChecked() && !castlebk.isChecked() && !castlebq.isChecked()){
            url = url + "-";
        }
        mTextView.setText(url);
        Log.d("fen url", url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        mTextView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
        drawLineFromResponse(mTextView.getText());
    }

    public void getBestMoveBlack(){
        final TextView mTextView = findViewById(R.id.activeFen);
        RequestQueue queue = Volley.newRequestQueue(this);
        //pass from intent
        Switch castlewk = findViewById(R.id.wkswitch);
        Switch castlewq = findViewById(R.id.wqswitch);
        Switch castlebk = findViewById(R.id.bkswitch);
        Switch castlebq = findViewById(R.id.bqswitch);
        //pass from intent
        String fen = getFen();
        Log.d("white", fen);
        String url ="http://100.64.112.41:8080/nextMove?fen=";
        url = url + fen;
        url = url + "%20b%20";
        if(castlewk.isChecked()){
            url = url + "K";
        }
        if(castlewq.isChecked()){
            url = url + "Q";
        }
        if(castlebk.isChecked()){
            url = url + "k";
        }
        if(castlebq.isChecked()){
            url = url + "q";
        }
        if(!castlewk.isChecked() && !castlewq.isChecked() && !castlebk.isChecked() && !castlebq.isChecked()){
            url = url + "-";
        }
        mTextView.setText(url);
        Log.d("fen url", url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        mTextView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
        drawLineFromResponse(mTextView.getText());
    }

    public void drawLineFromResponse(CharSequence response){
        String responseStr = (String) response;
        String[] parsedResponse = responseStr.split(" ");
        String move = parsedResponse[0];
        String[] moveChars = move.split("");
        String squareFrom = moveChars[0] + moveChars[1];
        String squareTo = moveChars[2] + moveChars[3];
        ImageView fromIV = findViewById(getResId(squareFrom, R.id.class));
        ImageView toIV = findViewById(getResId(squareTo, R.id.class));
        drawLine(fromIV, toIV);
    }

    public void displayFen(View v){
        TextView fenView = findViewById(R.id.activeFen);
        String fen = "";
        Integer counter = 0;
        String square;
        //for each row
        for(Integer row = 1; row < 9; row++){
            //for each column
            for(Character column = 'a'; column < 'i'; column++){
                square = column.toString() + row;
                //if the square contains anything
                if(squareChars.containsKey(square)){
                    if(squareChars.get(square)!='0') {
                        //append and then reset the counter
                        if (counter != 0) {
                            fen = fen + counter;
                            counter = 0;
                        }
                        //append the piece
                        fen = fen + squareChars.get(square);
                        Log.d("fen", "in " + square + " is " + squareChars.get(square));
                    }
                    else{
                        counter++;
                    }
                }
                //if the square is empty just increment the counter
                else{
                    counter++;
                }
            }
            if(counter != 0){
                fen = fen + counter;
                counter = 0;
            }
            if(row < 8) {
                fen = fen + '/';
            }
        }
        fenView.setText(fen);
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
        drawLine(e7,e5);
    }

    public void wipeSquare(String square){
        Log.d("wipe", "wiping " + square);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        if(squareIds.containsKey(square)){
            if(squareIds.get(square) != 0) {
                ImageView oldPiece = findViewById(squareIds.get(square));
                constraintLayout.removeView(oldPiece);
            }
        }
        squareChars.put(square, '0');
        squareIds.put(square, 0);
    }

    public void evaluate(View v){
        getBestMoveBlack();
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
                String square = column.toString() + row;
                if(column == 'i') {
                    break;
                }
                if(piece.length() == 0){
                    continue;
                }
                Character charPiece = piece.charAt(0);
                //if piece is an actual piece (a letter)
                if(Character.isLetter(charPiece)){
                    showFromStringChar(square, charPiece);
                    column++;
                }
                //if piece is number
                if(Character.isDigit(charPiece)){
                    while(charPiece > '0'){
                        wipeSquare(square);
                        column++;
                        charPiece--;
                        square = column.toString() + row;
                    }
                }
            }
            row++;
            if(row == 9) {
                break;
            }
        }
    }

    public void showFromStringChar(String squareStr, Character piece){
        Integer square = getResId(squareStr, R.id.class);
        showFromIdChar(square, piece);
    }


    public void showFromIdChar(Integer square, Character piece){
        ImageView newPiece = new ImageView(DigitalBoardActivity.this);
        newPiece.setImageResource(charToResource(piece));
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        ConstraintSet set = new ConstraintSet();
        String squareStr = squareResToString(square);
        if(squareIds.containsKey(squareStr)){
            if(squareIds.get(squareStr) != 0) {
                ImageView oldPiece = findViewById(squareIds.get(squareStr));
                constraintLayout.removeView(oldPiece);
                wipeSquare(squareStr);
            }
        }
        constraintLayout.addView(newPiece);
        newPiece.setId(View.generateViewId());
        squareIds.put(squareStr, newPiece.getId());
        squareChars.put(squareStr, piece);
        set.clone(constraintLayout);
        set.constrainHeight(newPiece.getId(),150);
        set.constrainWidth(newPiece.getId(),150);
        set.connect(newPiece.getId(), ConstraintSet.TOP, square, ConstraintSet.TOP, 0);
        set.connect(newPiece.getId(), ConstraintSet.RIGHT, square, ConstraintSet.RIGHT, 5);
        set.connect(newPiece.getId(), ConstraintSet.LEFT, square, ConstraintSet.LEFT, 0);
        set.connect(newPiece.getId(), ConstraintSet.BOTTOM, square, ConstraintSet.BOTTOM, 0);
        set.applyTo(constraintLayout);
    }

    public Integer squareOnClick(View v) {
        ImageView square = (ImageView) v;
        square.setColorFilter(Color.argb(255, 255, 255, 255));
        Integer highlighted = Highlight.getHighlight();
        if (highlighted != 0){
            ImageView old = findViewById(highlighted);
            old.setColorFilter(null);
        }
        return square.getId();
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

    public String squareResToString(Integer square){
        switch (square){
            case R.id.a1:
                return "a1";
            case R.id.a2:
                return "a2";
            case R.id.a3:
                return "a3";
            case R.id.a4:
                return "a4";
            case R.id.a5:
                return "a5";
            case R.id.a6:
                return "a6";
            case R.id.a7:
                return "a7";
            case R.id.a8:
                return "a8";
            case R.id.b1:
                return "b1";
            case R.id.b2:
                return "b2";
            case R.id.b3:
                return "b3";
            case R.id.b4:
                return "b4";
            case R.id.b5:
                return "b5";
            case R.id.b6:
                return "b6";
            case R.id.b7:
                return "b7";
            case R.id.b8:
                return "b8";
            case R.id.c1:
                return "c1";
            case R.id.c2:
                return "c2";
            case R.id.c3:
                return "c3";
            case R.id.c4:
                return "c4";
            case R.id.c5:
                return "c5";
            case R.id.c6:
                return "c6";
            case R.id.c7:
                return "c7";
            case R.id.c8:
                return "c8";
            case R.id.d1:
                return "d1";
            case R.id.d2:
                return "d2";
            case R.id.d3:
                return "d3";
            case R.id.d4:
                return "d4";
            case R.id.d5:
                return "d5";
            case R.id.d6:
                return "d6";
            case R.id.d7:
                return "d7";
            case R.id.d8:
                return "d8";
            case R.id.e1:
                return "e1";
            case R.id.e2:
                return "e2";
            case R.id.e3:
                return "e3";
            case R.id.e4:
                return "e4";
            case R.id.e5:
                return "e5";
            case R.id.e6:
                return "e6";
            case R.id.e7:
                return "e7";
            case R.id.e8:
                return "e8";
            case R.id.f1:
                return "f1";
            case R.id.f2:
                return "f2";
            case R.id.f3:
                return "f3";
            case R.id.f4:
                return "f4";
            case R.id.f5:
                return "f5";
            case R.id.f6:
                return "f6";
            case R.id.f7:
                return "f7";
            case R.id.f8:
                return "f8";
            case R.id.g1:
                return "g1";
            case R.id.g2:
                return "g2";
            case R.id.g3:
                return "g3";
            case R.id.g4:
                return "g4";
            case R.id.g5:
                return "g5";
            case R.id.g6:
                return "g6";
            case R.id.g7:
                return "g7";
            case R.id.g8:
                return "g8";
            case R.id.h1:
                return "h1";
            case R.id.h2:
                return "h2";
            case R.id.h3:
                return "h3";
            case R.id.h4:
                return "h4";
            case R.id.h5:
                return "h5";
            case R.id.h6:
                return "h6";
            case R.id.h7:
                return "h7";
            case R.id.h8:
                return "h8";
            default:
                return "null";
        }
    }

    private void drawLine(ImageView fromPos, ImageView toPos){
        float offset = a1.getWidth()/2;
        lv.setPointA(new PointF(fromPos.getX()+offset,fromPos.getY()+offset));
        lv.setPointB(new PointF(toPos.getX()+offset,toPos.getY()+offset));
        lv.bringToFront();
        lv.draw();
    }

    public void cameraPressed(View view){
        Intent i = new Intent(this, CameraActivity.class);
        startActivity(i);
    }

}