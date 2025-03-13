package com.example.databasehm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    Random rn;
    List<Note> notes;
    NoteDAO noteDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        NoteDatabase database = NoteDatabase.getInstance(this);
        noteDao = database.noteDao();
        rn = new Random();
        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        Note a = new Note("alon the meh", 56, "10%");
        Note b = new Note("ben the OG", 100000, "30%");
        Note c = new Note("karin the GOAT", 1, "40%");
        noteDao.insert(a);
        noteDao.insert(b);
        noteDao.insert(c);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes = noteDao.getAllInfo();
                int temp = rn.nextInt(notes.size());
                Note note = notes.get(temp);
                tv.setText(note.toString());
            }
        });
    }
}