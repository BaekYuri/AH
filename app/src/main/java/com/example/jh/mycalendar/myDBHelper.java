package com.example.jh.mycalendar;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDBHelper extends SQLiteOpenHelper {


    public myDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ToDoList (_id INTEGER PRIMARY KEY AUTOINCREMENT, isitcheck INTEGER, year INTEGER, month INTEGER, day INTEGER, info TEXT, type TEXT);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
        db.execSQL("DROP TABLE IF EXISTS ToDoList");
        onCreate(db);
    }

}

