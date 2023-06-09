package com.hellotestapp.myapplication.sqlitedatabse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyDatabse1 extends SQLiteOpenHelper {
    Context activity;
    public String TABLE = "Tables";

    public MyDatabse1(@Nullable Context context) {
        super(context, "TAsk.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table " + TABLE + "(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,number TEXT,isfav INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void InsertData(String username, String number,int isfav) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("number", number);
        values.put("isfav", isfav);
        db.insert(TABLE, null, values);
    }

    public List<User> RetriveData() {
        List<User> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "Select * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);
        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                list.add(new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return list;
    }

    public void UpdateData(int id, String username, String number,int isfave) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("number", number);
        values.put("isfav", isfave);
        db.update(TABLE, values, "id=" + id, null);
    }

    public void DeleteData(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE, "id=?" + id, new String[]{String.valueOf(id)});
    }
}
