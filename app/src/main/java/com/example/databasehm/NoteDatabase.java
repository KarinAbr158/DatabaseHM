package com.example.databasehm;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase instance;

    public abstract NoteDAO noteDao();

    public static synchronized NoteDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            NoteDatabase.class,
                            "note_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
