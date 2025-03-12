package com.example.databasehm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);


    @Query("SELECT * FROM notes")
    List<Note> getAllInfo();

    @Query("SELECT * FROM notes WHERE id = :id")
    Note getNoteByID(int id);
}
