package com.example.android.camera2basic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
                    pieceImageView.setImageResource(R.drawable.chess_rdt);
                    break;
                case 'n':
                    pieceImageView.setImageResource(R.drawable.chess_ndt);
                    break;
                case 'b':
                    pieceImageView.setImageResource(R.drawable.chess_bdt);
                    break;
                case 'q':
                    pieceImageView.setImageResource(R.drawable.chess_qdt);
                    break;
                case 'k':
                    pieceImageView.setImageResource(R.drawable.chess_kdt);
                    break;
                case 'p':
                    pieceImageView.setImageResource(R.drawable.chess_pdt);
                    break;
                case 'R':
                    pieceImageView.setImageResource(R.drawable.chess_rlt);
                    break;
                case 'N':
                    pieceImageView.setImageResource(R.drawable.chess_nlt);
                    break;
                case 'B':
                    pieceImageView.setImageResource(R.drawable.chess_blt);
                    break;
                case 'Q':
                    pieceImageView.setImageResource(R.drawable.chess_qlt);
                    break;
                case 'K':
                    pieceImageView.setImageResource(R.drawable.chess_klt);
                    break;
                case 'P':
                    pieceImageView.setImageResource(R.drawable.chess_plt);
                    break;
                default:
                    pieceImageView.setImageResource(R.drawable.empty);
            }
        }

        public char getPiece() {
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
        }

        public void highlight(PieceSquare piece) {
            unhighlight();
            piece.highlight();
            highlighted = piece;
        }

        public void highlight(String squareName) {
            unhighlight();
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

        public void unhighlight() {
            if (highlighted != null) {
                highlighted.unhighlight();
                highlighted = null;
            }
        }

        public void wipe(String squareName) {
            PieceSquare piece = board.get(squareName);
            piece.wipe();
        }

        public void wipe(PieceSquare pieceSquare) {
            pieceSquare.wipe();
        }

        public void setPiece(String squareName, char piece) {
            board.get(squareName).setPiece(piece);
        }

        public void setPiece(PieceSquare pieceSquare, char piece) {
            pieceSquare.setPiece(piece);
        }

        public char getPiece(String squareName) {
            return board.get(squareName).getPiece();
        }

        public char getPiece(PieceSquare pieceSquare) {
            return pieceSquare.getPiece();
        }

        public void setFromFEN(String fen) {
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
                    PieceSquare pieceSquare = get("" + column + row);
                    if(column == 'i') {
                        break;
                    }
                    if(piece.length() == 0){
                        continue;
                    }
                    char charPiece = piece.charAt(0);
                    //if piece is an actual piece (a letter)
                    if(Character.isLetter(charPiece)){
                        setPiece(pieceSquare, charPiece);
                        column++;
                    }
                    //if piece is number
                    if(Character.isDigit(charPiece)){
                        while(charPiece > '0'){
                            pieceSquare.wipe();
                            column++;
                            charPiece--;
                        }
                    }
                }
                row--;
                if (row == 0) {
                    break;
                }
            }
        }

        public PieceSquare get(String squareName) {
            return board.get(squareName);
        }

        public void put(String squareName, PieceSquare pieceSquare) {
            board.put(squareName, pieceSquare);
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
                    if(this.getPiece(square) != ' '){
                        //if(squareChars.get(square)!='0') {
                        //append and then reset the counter
                        if (counter != 0) {
                            fen = fen + counter;
                            counter = 0;
                        }
                        //append the piece
                        fen = fen + this.getPiece(square);
                       // }
//                        else{
//                            counter++;
//                        }
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
            Log.d("fen", fen);
            return fen;
        }

    }

    private Board board;
    private Toolbar mTopToolbar;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("result", "in result");
        board.unhighlight();
        if (requestCode == 1) {
            Log.d("result", "code was 1");
            if (resultCode == RESULT_OK) {
                Log.d("result", "result ok");
                char pieceChar = data.getCharExtra("pieceChar", '0');
                int pieceInt = data.getIntExtra("pieceInt",0);
                String squareStr = data.getStringExtra("squareStr");

                if (pieceInt == 0){
                    board.wipe(squareStr);
                } else{
                    board.setPiece(squareStr, pieceChar);
                }
            }
        }
        else if (resultCode == 2){
            Boolean wq = data.getBooleanExtra("wqSwitch",true);
            Boolean wk = data.getBooleanExtra("wkSwitch",true);
            Boolean bq = data.getBooleanExtra("bqSwitch",true);
            Boolean bk = data.getBooleanExtra("bkSwitch",true);
            Boolean whiteTurn = data.getBooleanExtra("whiteTurn",true);
            if (whiteTurn) {
                getBestMoveWhite(wq, wk, bq, bk);
            } else if (!whiteTurn){
                getBestMoveBlack(wq, wk, bq, bk);
            } else {
                Log.e("turn error: ", "Error finding whose turn");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_board);
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.widthPixels;
        int screenHeight = display.heightPixels;
        //set bottom padding of buttons
        LinearLayout buttonsLayout = findViewById(R.id.buttonsLinearLayout);
        buttonsLayout.setPadding(0,0, 0, screenHeight/35);
        LinearLayout buttonsLayout2 = findViewById(R.id.buttonsLinearLayout2);
        buttonsLayout2.setPadding(0,0, 0, screenHeight/35);

        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        board = new Board();
        String fen = getIntent().getExtras().getString("boardstate");
        board.setFromFEN(fen);
    }

    public void nextMove(View view){
        Intent i = new Intent(DigitalBoardActivity.this, NextMovePop.class);
        i.putExtra("squareInt", 1);
        i.putExtra("squareStr", "square");
        startActivityForResult(i, 2);
    }

    public void getBestMoveWhite(boolean wq, boolean wk, boolean bq, boolean bk){
        RequestQueue queue = Volley.newRequestQueue(this);
        String fen = board.getFen();
        Log.d("white", fen);
        String url ="http://" + getString(R.string.ip_address) + "/nextMove?fen=";
        url = url + fen;
        url = url + "%20w%20";
        if(wk){
            url = url + "K";
        }
        if(wq){
            url = url + "Q";
        }
        if(bk){
            url = url + "k";
        }
        if(bq){
            url = url + "q";
        }
        if(!wk && !wq && !bk && !bq){
            url = url + "-";
        }
        url = url + "%20-%200%201";
//        mTextView.setText(url);
        Log.d("fen url", url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        //drawLineFromResponse(response);
                        //fenTxt.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }

    public void getBestMoveBlack(boolean wq, boolean wk, boolean bq, boolean bk){
//        final TextView mTextView = findViewById(R.id.activeFen);
//        final TextView fenTxt = findViewById(R.id.fenTextView);
        RequestQueue queue = Volley.newRequestQueue(this);
        String fen = board.getFen();
        Log.d("white", fen);
        String url ="http://" + getString(R.string.ip_address) + "/nextMove?fen=";
        url = url + fen;
        url = url + "%20b%20";
        if(wk){
            url = url + "K";
        }
        if(wq){
            url = url + "Q";
        }
        if(bk){
            url = url + "k";
        }
        if(bq){
            url = url + "q";
        }
        if(!wk && !wq && !bk && !bq){
            url = url + "-";
        }
        url = url + "%20-%200%201";
//        mTextView.setText(url);
        Log.d("fen url", url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("server", response);
                        //drawLineFromResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
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
