package com.example.android.camera2basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DigitalBoardActivity extends AppCompatActivity {

    protected String boardState;

    protected ImageView board;
    protected TextView boardStateTextView;
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
        setContentView(R.layout.activity_digital_board);
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

        listPieces = new ArrayList<>();
        listPieces.add(blackRook1);
        listPieces.add(whiteRook1);
        listPieces.add(blackKnight1);
        listPieces.add(whiteKnight1);
        listPieces.add(blackBishop1);
        listPieces.add(whiteBishop1);
        listPieces.add(blackQueen);
        listPieces.add(whiteQueen);
        listPieces.add(blackRook2);
        listPieces.add(whiteRook2);
        listPieces.add(blackKnight2);
        listPieces.add(whiteKnight2);
        listPieces.add(blackBishop2);
        listPieces.add(whiteBishop2);



        boardStateTextView = findViewById(R.id.boardStateTextView);
        boardState = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";  //Starting board
        //initBoard(listPieces);
        constructBoard("r");
    }

    protected void constructBoard(String boardState) {
        // Given boardState
        // 1) Clear board
        // 2) Start filling in pieces to the squares
        String word = "r";
        boardStateTextView.setText(word);
        for (char c : word.toCharArray()) {
            switch (c) {
                case 'r':
                    placePiece(whiteRook1, 1, 1);

                case 'n':
                    placePiece(whiteKnight1, 2, 1);

                case 'b':
                    placePiece(whiteBishop1, 3, 1);

                case 'q':
                    placePiece(whiteQueen, 4, 1);

                case 'k':
                    placePiece(whiteKing, 5, 1);

                case 'p':
                    //placePiece(whitePawn1, 2, 1);

                case '8': //placePiece(whiteRook1);

                case 'R':
                    placePiece(blackRook1, 2, 1);

                case 'N':
                    placePiece(blackKnight1, 2, 1);

                case 'B':
                    placePiece(blackBishop1, 2, 1);

                case 'Q':
                    placePiece(blackQueen, 2, 1);

                case 'K':
                    placePiece(blackKing, 2, 1);

                case 'P': //placePiece(blackPawn1);

                default:
                    //placePiece(whiteRook1, 1, 1);
            }
        }
    }

    protected void placePiece(ImageView pieceImg, int row, int col) {
        int offset = 5;
        int boardWidth = board.getLayoutParams().width;
        //int boardHeight = board.getHeight();
        pieceImg.setX((boardWidth/8 * (col-1)) + offset);
        pieceImg.setY((boardWidth/8 * (row-1)) + offset);

    }

    public void moveImageView(ImageView view, int row, int col) {
//        TranslateAnimation animation = new TranslateAnimation(0.0f, 46f*col, 0.0f, 46f*row);
//        animation.setDuration(700);
//        animation.setFillAfter(true);
//        view.startAnimation(animation);

        view.setX(46*col);
        view.setY(-46*row);

    }

    private void initBoard(ArrayList<ImageView> list) {
        int col = 3;
        int row = 3;
            for (ImageView iv : list) {
                placePiece(iv, row, col);
                col++;
                if(col > 8){
                    row = 7;
                    col = 1;
                }
                if(row > 8){
                    break;
                }
            }
    }
}