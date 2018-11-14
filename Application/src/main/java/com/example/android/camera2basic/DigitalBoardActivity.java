package com.example.android.camera2basic;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DigitalBoardActivity extends AppCompatActivity {

    protected String boardState;

    protected ImageView board;
    //protected TextView boardStateTextView;
    protected ArrayList<ImageView> listPieces;
    protected ImageView blackRook1;
    protected ImageView whiteRook1;
    protected ImageView blackRook2;
    protected ImageView whiteRook2;
    protected ImageView blackKnight1;
    protected ImageView whiteKnight1;
    protected ImageView blackKnight2;
    protected ImageView whiteKnight2;
    protected ImageView blackBishop1;
    protected ImageView whiteBishop1;
    protected ImageView blackBishop2;
    protected ImageView whiteBishop2;
    protected ImageView blackQueen;
    protected ImageView whiteQueen;
    protected ImageView blackKing;
    protected ImageView whiteKing;
    protected ImageView blackPawn1;
    protected ImageView whitePawn1;
    protected ImageView blackPawn2;
    protected ImageView whitePawn2;
    protected ImageView blackPawn3;
    protected ImageView whitePawn3;
    protected ImageView blackPawn4;
    protected ImageView whitePawn4;
    protected ImageView blackPawn5;
    protected ImageView whitePawn5;
    protected ImageView blackPawn6;
    protected ImageView whitePawn6;
    protected ImageView blackPawn7;
    protected ImageView whitePawn7;
    protected ImageView blackPawn8;
    protected ImageView whitePawn8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitalboard);
        board = findViewById(R.id.board);
        blackRook1 = findViewById(R.id.blackRook);
        whiteRook1 = findViewById(R.id.whiteRook);
        blackKnight1 = findViewById(R.id.blackKnight);
        whiteKnight1 = findViewById(R.id.whiteKnight);
        blackBishop1 = findViewById(R.id.blackBishop);
        whiteBishop1 = findViewById(R.id.whiteBishop);
        blackQueen = findViewById(R.id.blackQueen);
        whiteQueen = findViewById(R.id.whiteQueen);
        blackKing = findViewById(R.id.blackKing);
        whiteKing = findViewById(R.id.whiteKing);
        blackRook2 = findViewById(R.id.blackRook2);
        whiteRook2 = findViewById(R.id.whiteRook2);
        blackKnight2 = findViewById(R.id.blackKnight2);
        whiteKnight2 = findViewById(R.id.whiteKnight2);
        blackBishop2 = findViewById(R.id.blackBishop2);
        whiteBishop2 = findViewById(R.id.whiteBishop2);

        whitePawn1 = findViewById(R.id.whitePawn1);
        whitePawn2 = findViewById(R.id.whitePawn2);
        whitePawn3 = findViewById(R.id.whitePawn3);
        whitePawn4 = findViewById(R.id.whitePawn4);
        whitePawn5 = findViewById(R.id.whitePawn5);
        whitePawn6 = findViewById(R.id.whitePawn6);
        whitePawn7 = findViewById(R.id.whitePawn7);
        whitePawn8 = findViewById(R.id.whitePawn8);

        blackPawn1 = findViewById(R.id.blackPawn1);
        blackPawn2 = findViewById(R.id.blackPawn2);
        blackPawn3 = findViewById(R.id.blackPawn3);
        blackPawn4 = findViewById(R.id.blackPawn4);
        blackPawn5 = findViewById(R.id.blackPawn5);
        blackPawn6 = findViewById(R.id.blackPawn6);
        blackPawn7 = findViewById(R.id.blackPawn7);
        blackPawn8 = findViewById(R.id.blackPawn8);



        listPieces = new ArrayList<>();
        listPieces.add(blackRook1);
        listPieces.add(whiteRook1);
        listPieces.add(blackKnight1);
        listPieces.add(whiteKnight1);
        listPieces.add(blackBishop1);
        listPieces.add(whiteBishop1);
        listPieces.add(blackQueen);
        listPieces.add(whiteQueen);
        listPieces.add(blackKing);
        listPieces.add(whiteKing);
        listPieces.add(blackRook2);
        listPieces.add(whiteRook2);
        listPieces.add(blackKnight2);
        listPieces.add(whiteKnight2);
        listPieces.add(blackBishop2);
        listPieces.add(whiteBishop2);

        //boardStateTextView = findViewById(R.id.boardStateTextView);
        boardState = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";  //Starting board
        initBoard();
        //constructBoard("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }

    protected void constructBoard(String boardState) {
        // Given boardState
        // 1) Clear board
        // 2) Start filling in pieces to the squares
        String word = "r";
        //boardStateTextView.setText(word);
        for (char c : boardState.toCharArray()) {

            switch (c) {
                case 'r':
                    placePiece(whiteRook1, 1, 1);

                case 'n':
                    placePiece(whiteKnight1, 1, 2);

                case 'b':
                    placePiece(whiteBishop1, 1, 3);

                case 'q':
                    placePiece(whiteQueen, 1, 4);

                case 'k':
                    placePiece(whiteKing, 1, 5);

                case 'p':
                    ImageView newPawn = new ImageView(this);
                    newPawn.setImageResource(R.drawable.chess_plt60);
                    newPawn.setLayoutParams(new LinearLayoutCompat.LayoutParams(48,48));
                    placePiece(newPawn, 2,1);
                    //placePiece(whitePawn1, 2, 1);

                case '8': //placePiece(whiteRook1);

                case 'R':
                    placePiece(blackRook1, 8, 1);

                case 'N':
                    placePiece(blackKnight1, 8, 2);

                case 'B':
                    placePiece(blackBishop1, 8, 3);

                case 'Q':
                    placePiece(blackQueen, 8, 4);

                case 'K':
                    placePiece(blackKing, 8, 5);

                case 'P': //placePiece(blackPawn1);

                default:
                    //placePiece(whiteRook1, 1, 1);
            }
        }
    }

    protected void placePiece(ImageView pieceImg, int row, int col) {
        int offset = 4;
        int boardWidth = board.getLayoutParams().width;
        //int boardHeight = board.getHeight();
        pieceImg.setX((boardWidth/8 * (col-1)) + offset);
        pieceImg.setY((boardWidth/8 * (row-1)) + offset);
    }

    private void initBoard() {
        placePiece(whiteRook1, 8, 1);
        placePiece(whiteKnight1, 8, 2);
        placePiece(whiteBishop1, 8, 3);
        placePiece(whiteQueen, 8, 4);
        placePiece(whiteKing, 8, 5);
        placePiece(whiteBishop2, 8, 6);
        placePiece(whiteKnight2, 8, 7);
        placePiece(whiteRook2, 8, 8);

        placePiece(blackRook1, 1, 1);
        placePiece(blackKnight1, 1, 2);
        placePiece(blackBishop1, 1, 3);
        placePiece(blackQueen, 1, 4);
        placePiece(blackKing, 1, 5);
        placePiece(blackBishop2, 1, 6);
        placePiece(blackKnight2, 1, 7);
        placePiece(blackRook2, 1, 8);

        placePiece(whitePawn1, 7, 1);
        placePiece(whitePawn2, 7, 2);
        placePiece(whitePawn3, 7, 3);
        placePiece(whitePawn4, 7, 4);
        placePiece(whitePawn5, 7, 5);
        placePiece(whitePawn6, 7, 6);
        placePiece(whitePawn7, 7, 7);
        placePiece(whitePawn8, 7, 8);

        placePiece(blackPawn1, 2, 1);
        placePiece(blackPawn2, 2, 2);
        placePiece(blackPawn3, 2, 3);
        placePiece(blackPawn4, 2, 4);
        placePiece(blackPawn5, 2, 5);
        placePiece(blackPawn6, 2, 6);
        placePiece(blackPawn7, 2, 7);
        placePiece(blackPawn8, 2, 8);


    }

    public void boardStateDemo(View view){
        placePiece(whitePawn4, 5, 4);
        placePiece(blackPawn4, 4, 4);

        placePiece(whiteKnight2, 6, 6);
        placePiece(blackKnight1, 3, 3);

        placePiece(whiteQueen, 5, 2);

        //placePiece();


    }
}