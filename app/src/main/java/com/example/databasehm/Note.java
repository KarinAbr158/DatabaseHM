package com.example.databasehm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private Integer num;
    private String sentence;
    private String percents;

    public Note(String s, int i, String p) {
        this.num = i;
        this.percents = p;
        this.sentence = s;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", num=" + num +
                ", sentence='" + sentence + '\'' +
                ", percents='" + percents + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getPercents() {
        return percents;
    }

    public void setPercents(String percents) {
        this.percents = percents;
    }
}
