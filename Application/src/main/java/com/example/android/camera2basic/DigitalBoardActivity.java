package com.example.android.camera2basic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Hashtable;


public class DigitalBoardActivity extends AppCompatActivity {

    public class PieceSquare {
        private char piece;
        private String square;
        private ImageView squareImageView;
        private ImageView pieceImageView;
        private boolean highlighted;

        public PieceSquare(String square, ImageView pieceImageView, ImageView squareImageView) {
            this.pieceImageView = pieceImageView;
            this.squareImageView = squareImageView;
            this.square = square;
            this.piece = ' ';
            highlighted = false;
        }

        public void setPiece(char piece){
            this.piece = piece;
            switch (piece){
                case 'r':
                    pieceImageView.setImageResource(R.drawable.chess_rdt60);
                    break;
                case 'n':
                    pieceImageView.setImageResource(R.drawable.chess_ndt60);
                    break;
                case 'b':
                    pieceImageView.setImageResource(R.drawable.chess_bdt60);
                    break;
                case 'q':
                    pieceImageView.setImageResource(R.drawable.chess_qdt60);
                    break;
                case 'k':
                    pieceImageView.setImageResource(R.drawable.chess_kdt60);
                    break;
                case 'p':
                    pieceImageView.setImageResource(R.drawable.chess_pdt60);
                    break;
                case 'R':
                    pieceImageView.setImageResource(R.drawable.chess_rlt60);
                    break;
                case 'N':
                    pieceImageView.setImageResource(R.drawable.chess_nlt60);
                    break;
                case 'B':
                    pieceImageView.setImageResource(R.drawable.chess_blt60);
                    break;
                case 'Q':
                    pieceImageView.setImageResource(R.drawable.chess_qlt60);
                    break;
                case 'K':
                    pieceImageView.setImageResource(R.drawable.chess_klt60);
                    break;
                case 'P':
                    pieceImageView.setImageResource(R.drawable.chess_plt60);
                    break;
                default:
                    pieceImageView.setImageResource(R.drawable.empty);
            }
        }

        public int getPiece() {
            return piece;
        }

        public boolean isHighlighted() {
            return highlighted;
        }

        public void highlight() {
            squareImageView.setColorFilter(Color.argb(255, 255, 255, 255));
            highlighted = true;
        }

        public void unhighlight() {
            squareImageView.setColorFilter(null);
            highlighted = false;
        }

        public void wipe() {
            pieceImageView.setImageResource(R.drawable.empty);
            this.piece = ' ';
            highlighted = false;
        }

        public void setOnClickListener() {
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int squareInt = view.getId();
                    board.highlight(square);
                    Intent i = new Intent(DigitalBoardActivity.this, Pop.class);
                    i.putExtra("squareInt", squareInt);
                    i.putExtra("squareStr", square);
                    startActivityForResult(i, 1);
                }
            };
            pieceImageView.setOnClickListener(listener);
        }
    }

    public class Board {
        private Hashtable<String, PieceSquare> board;
        private PieceSquare highlighted;

        public Board() {
            board = new Hashtable<>();
        }

        public void highlight(PieceSquare piece) {
            piece.highlight();
            highlighted = piece;
        }

        public void highlight(String squareName) {
            PieceSquare piece = board.get(squareName);
            piece.highlight();
            highlighted = piece;
        }

        public void unhighlight(PieceSquare piece) {
            piece.unhighlight();
            highlighted = null;
        }

        public void unhighlight(String squareName) {
            PieceSquare piece = board.get(squareName);
            piece.unhighlight();
            highlighted = null;
        }

        public PieceSquare get(String squareName) {
            return board.get(squareName);
        }

        public void put(String squareName, PieceSquare pieceSquare) {
            board.put(squareName, pieceSquare);
        }
    }

    private Board board;
    private Toolbar mTopToolbar;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("result", "in result");
        if (requestCode == 1) {
            Log.d("result", "code was 1");
            if (resultCode == RESULT_OK) {
                Log.d("result", "result ok");
                Character pieceChar = data.getCharExtra("pieceChar", '0');
                Integer pieceInt = data.getIntExtra("pieceInt",0);
                Integer square = data.getIntExtra("squareInt",0);
                String squareStr = data.getStringExtra("squareStr");

                PieceSquare pieceSquare = board.get(squareStr);

                if (pieceInt == 0){
                    pieceSquare.wipe();
                    board.unhighlight(pieceSquare);
                } else{
                    pieceSquare.setPiece(pieceChar);
                    board.unhighlight(pieceSquare);
                }
            }
        }
//        else if (resultCode == 2){
//            Boolean wq = data.getBooleanExtra("wqSwitch",true);
//            Boolean wk = data.getBooleanExtra("wkSwitch",true);
//            Boolean bq = data.getBooleanExtra("bqSwitch",true);
//            Boolean bk = data.getBooleanExtra("bkSwitch",true);
//            Boolean whiteTurn = data.getBooleanExtra("whiteTurn",true);
//            if (whiteTurn) {
//                getBestMoveWhite(wq, wk, bq, bk);
//            } else if (!whiteTurn){
//                getBestMoveBlack(wq, wk, bq, bk);
//            } else {
//                Log.e("turn error: ", "Error finding whose turn");
//            }
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_board);
        //size knight relative to screen size
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.widthPixels;
        int screenHeight = display.heightPixels;
        //set bottom padding of buttons
        LinearLayout buttonsLayout = findViewById(R.id.buttonsLinearLayout);
        buttonsLayout.setPadding(0,0, 0, screenHeight/35);
        LinearLayout buttonsLayout2 = findViewById(R.id.buttonsLinearLayout2);
        buttonsLayout2.setPadding(0,0, 0, screenHeight/35);

        board = new Board();
        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        for (char i = 'a'; i <= 'h'; i++){
            for (int j = 1; j <= 8; j++){
                String squareName = "" + i + j;
                int pieceID = getResources().getIdentifier(squareName, "id", getPackageName());
                int squareID = getResources().getIdentifier( squareName + "Square", "id", getPackageName());
                final ImageView pieceView = findViewById(pieceID);
                final ImageView squareView = findViewById(squareID);
                PieceSquare piece = new PieceSquare(squareName, pieceView, squareView);
                piece.setOnClickListener();
                board.put(squareName, piece);
            }
        }

        String fen = getIntent().getExtras().getString("boardstate");
        setFromFEN(fen);
    }

    public void setFromFEN(String fen){
        String[] arr = fen.split("/");
        Character column;
        String[] rowChars;
        Integer row = 8;
        //for each row in the fen code
        for (int i = 1; i < 9; i++){
            column = 'a';
            rowChars = arr[i - 1].trim().split("");
            //for each piece in each row
            for (String piece : rowChars){
                PieceSquare pieceSquare = board.get("" + column + row);
                String square = column.toString() + row;
                if(column == 'i') {
                    break;
                }
                if(piece.length() == 0){
                    continue;
                }
                char charPiece = piece.charAt(0);
                //if piece is an actual piece (a letter)
                if(Character.isLetter(charPiece)){
                    pieceSquare.setPiece(charPiece);
                    column++;
                }
                //if piece is number
                if(Character.isDigit(charPiece)){
                    while(charPiece > '0'){
                        pieceSquare.wipe();
                        column++;
                        charPiece--;
                        square = column.toString() + row;
                    }
                }
            }
            row--;
            if (row == 0) {
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            Toast.makeText(DigitalBoardActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
