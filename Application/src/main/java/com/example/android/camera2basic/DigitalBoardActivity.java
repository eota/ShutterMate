package com.example.android.camera2basic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.TextView;

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
    Hashtable<Integer, Integer> squares;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("result", "in result");
        if (requestCode == 1) {
            Log.d("result", "code was 1");
            if (resultCode == RESULT_OK) {
                Log.d("result", "result ok");
                Integer piece = data.getIntExtra("piece",0);
                Integer square = data.getIntExtra("square",0);

                if(piece == 0){
                    //do nothing
                }
                else{
                    Log.d("show", "showing now");
                    showFromId(square, piece);
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

        squares = new Hashtable<>();
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
                    showFromString(column.toString() + row, charToResource(charPiece));
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

    public void showFromString(String squareStr, Integer piece){
        Integer square = getResId(squareStr, R.id.class);
        ImageView newPiece = new ImageView(DigitalBoardActivity.this);
        newPiece.setImageResource(piece);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        ConstraintSet set = new ConstraintSet();
        if(squares.containsKey(square)){
            if(squares.get(square) != 0) {
                ImageView oldPiece = findViewById(squares.get(square));
                constraintLayout.removeView(oldPiece);
            }
        }
        constraintLayout.addView(newPiece);
        newPiece.setId(View.generateViewId());
        squares.put(square, newPiece.getId());
        set.clone(constraintLayout);
        set.constrainHeight(newPiece.getId(),150);
        set.constrainWidth(newPiece.getId(),150);
        set.connect(newPiece.getId(), ConstraintSet.TOP, square, ConstraintSet.TOP, 0);
        set.connect(newPiece.getId(), ConstraintSet.RIGHT, square, ConstraintSet.RIGHT, 5);
        set.connect(newPiece.getId(), ConstraintSet.LEFT, square, ConstraintSet.LEFT, 0);
        set.connect(newPiece.getId(), ConstraintSet.BOTTOM, square, ConstraintSet.BOTTOM, 0);
        set.applyTo(constraintLayout);
    }

    public void showFromId(Integer square, Integer piece){
        ImageView newPiece = new ImageView(DigitalBoardActivity.this);
        newPiece.setImageResource(piece);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        ConstraintSet set = new ConstraintSet();
        if(squares.containsKey(square)){
            if(squares.get(square) != 0) {
                ImageView oldPiece = findViewById(squares.get(square));
                constraintLayout.removeView(oldPiece);
            }
        }
        constraintLayout.addView(newPiece);
        newPiece.setId(View.generateViewId());
        squares.put(square, newPiece.getId());
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
}