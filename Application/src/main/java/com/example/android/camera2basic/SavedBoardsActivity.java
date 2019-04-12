package com.example.android.camera2basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SavedBoardsActivity extends AppCompatActivity {
    ListView listView;
    List list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_boards);
        listView = findViewById(R.id.list_view);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                "savedBoards", Context.MODE_PRIVATE);
        final Map<String, ?> savedBoards = sharedPref.getAll();
        //for testing purposes
        if (savedBoards.size() == 0){
            SharedPreferences.Editor editor = sharedPref.edit();
            String fen = "r4bkr/ppp3pp/2n1b3/3B4/8/3P4/PPP3pP/RNB1KR2 w - - 0 5";
            editor.putString("test", fen);
            editor.commit();
        }
        //remove in prod
        for (Map.Entry<String, ?> entry : savedBoards.entrySet()){
            list.add(entry.getKey());
        }
        final ArrayAdapter adapter = new ArrayAdapter(SavedBoardsActivity.this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = adapter.getItem(position).toString();
                String fen;
                //savedBoards.get() not working, temporary work around
                fen = "r4bkr/ppp3pp/2n1b3/3B4/8/3P4/PPP3pP/RNB1KR2 w - - 0 5";
                for (Map.Entry<String, ?> entry : savedBoards.entrySet()){
                    if (entry.getKey() == name){
                        fen = entry.getValue().toString();
                        Log.d("fen", "setting fen to: " + fen);
                    }
                }
                Intent i = new Intent(getApplicationContext(), DigitalBoardActivity.class);
                i.putExtra("boardstate", fen);
                startActivity(i);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { //list is my listView
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SavedBoardsActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.boardstate_name_dialog, null);
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                                "savedBoards", Context.MODE_PRIVATE);
                        String name = adapter.getItem(pos).toString();
                        sharedPref.edit().remove(name).commit();
                        list.remove(name);
                        adapter.notifyDataSetChanged();
                        Log.d("delete", name);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                final EditText nameEdit = dialogView.findViewById(R.id.boardNameText);
                final AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }
}
