package com.example.periodtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "clockme.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String Tablename="moods";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (name TEXT, email TEXT,length integer, duration integer, datee TEXT)");
        db.execSQL("CREATE TABLE moods (name TEXT, email TEXT,day1 integer, day2 integer,day3 integer, day4 integer,day5 integer, day6 integer)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Tablename);
        onCreate(db);

    }


    public void addUser(String name, String email, int length, int duration , String datee) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM registeruser", null);
        db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        ContentValues cV1 = new ContentValues();
        cV.put("name", name);
        cV.put("email", email);
        cV.put("length", length);
        cV.put("duration", duration);
        cV.put("datee", datee);
        cV1.put("name", name);
        cV1.put("email", email);
        cV1.put("day1", 0);
        cV1.put("day2", 0);
        cV1.put("day3", 0);
        cV1.put("day4", 0);
        cV1.put("day5", 0);
        cV1.put("day6", 0);
        db.insert("registeruser", null, cV);
        db.insert("moods",null,cV1);
        db.close();

    }

    public String getdate(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String din;
        Cursor cursor = db.rawQuery("SELECT * FROM registeruser WHERE email=?", new String[]{name});
        if (cursor.moveToFirst()) {
            din=cursor.getString(cursor.getColumnIndex("datee"));

            return din ;

        }
        else
            return "nothing";
    }


    public int getdur(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        int dur;
        Cursor cursor = db.rawQuery("SELECT * FROM registeruser WHERE email=?", new String[]{name});
        if (cursor.moveToFirst()) {
            dur=cursor.getInt(cursor.getColumnIndex("duration"));

            return dur ;

        }
        else
            return 0;
    }

    public void addmoods(String email,int score){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM moods  WHERE email=?", new String[]{email});
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (cursor.moveToFirst()) {
            int c1 = cursor.getInt(cursor.getColumnIndex("day2"));
            int c2 = cursor.getInt(cursor.getColumnIndex("day3"));
            int c3 = cursor.getInt(cursor.getColumnIndex("day4"));
            int c4 = cursor.getInt(cursor.getColumnIndex("day5"));
            int c5 = cursor.getInt(cursor.getColumnIndex("day6"));
            values.put("day1", c1);
            values.put("day2", c2);
            values.put("day3", c3);
            values.put("day4", c4);
            values.put("day5", c5);
            values.put("day6", score);
        }
        db.update(Tablename, values, "email=?", new String[]{email});

    }

    public int[] graph_content(String name) {
        int[] array = new int[6];
        SQLiteDatabase db = this.getReadableDatabase();
        //("SELECT * FROM " + TABLE_NAME + " where " + PEOPLE_RATION_NUMBER + "='" + rationNumber + "'", null);

        Cursor cursor = db.rawQuery("SELECT * FROM moods WHERE email=?", new String[]{name});
        //Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_COLOR + " WHERE ID = " + id + " ",null);
        if (cursor.moveToFirst()) {
            int c1 = cursor.getInt(cursor.getColumnIndex("day1"));
            int c2 = cursor.getInt(cursor.getColumnIndex("day2"));
            int c3 = cursor.getInt(cursor.getColumnIndex("day3"));
            int c4 = cursor.getInt(cursor.getColumnIndex("day4"));
            int c5 = cursor.getInt(cursor.getColumnIndex("day5"));
            int c6 = cursor.getInt(cursor.getColumnIndex("day6"));
            array[0] = c1;
            array[1] = c2;
            array[2] = c3;
            array[3] = c4;
            array[4] = c5;
            array[5] = c6;

        }
        return array;

    }


}
