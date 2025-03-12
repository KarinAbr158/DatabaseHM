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

    Button btn;
    TextView tv;
    Random rn;
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
        NoteDAO noteDao = database.noteDao();
        
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        rn = new Random();

        new Thread(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(new Note("idk what to write", 16, "50%"));
                noteDao.insert(new Note("maybe now i'll know what to write", 5, "77%"));
            }
        });
        List<Note> notes = noteDao.getAllInfo();

                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note temp = notes.get(rn.nextInt(notes.size()));
                tv.setText(temp.toString());
            }
        });
    }
}