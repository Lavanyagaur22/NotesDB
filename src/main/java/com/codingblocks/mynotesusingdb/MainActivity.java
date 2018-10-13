package com.codingblocks.mynotesusingdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Note> notes = new ArrayList<>();
    ArrayList<Note> notes1;
    NotesDataBaseHelper notesDataBaseHelper;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesDataBaseHelper = new NotesDataBaseHelper(this);

        notes1= notesDataBaseHelper.getAllNotes();

        notes.clear();
        if (notes1.size() != 0) {

            notes=notes1;



        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final EditText title = findViewById(R.id.ettitle);
        final EditText des = findViewById(R.id.etdes);
        Button btnadd = findViewById(R.id.btnadd);


        notesAdapter = new NotesAdapter(notes, notesDataBaseHelper);
        recyclerView.setAdapter(notesAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title1 = title.getText().toString();

                String des1 = des.getText().toString();
                notes.add(new Note(title1, des1, "" + System.currentTimeMillis()));

                notesDataBaseHelper.insert(new Note(title1, des1, "" + System.currentTimeMillis()));
                notesAdapter.notifyDataSetChanged();

                Log.e("TAG", "onClick: "+notesDataBaseHelper.getAllNotes().size() );
            }
        });

       // notesDataBaseHelper.insert(new Note(title1, des1, "" + System.currentTimeMillis(), 0));


    }
}
