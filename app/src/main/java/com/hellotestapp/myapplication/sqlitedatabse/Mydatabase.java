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

public class Mydatabase extends SQLiteOpenHelper {
    Context context;
    String Table = "Student";

    public Mydatabase(@Nullable Context context) {
        super(context,"test.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createtable = "Create table " + Table + "(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,number TEXT,isfav INTEGER)";
        sqLiteDatabase.execSQL(createtable);
    }

    public void insertdata(String name,String number,int isfav){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",name);
        contentValues.put("number",number);
        contentValues.put("isfav",isfav);
        sqLiteDatabase.insert(Table,"",contentValues);
    }

    public List<User> retrivedata(){
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "Select * from " + Table;
        Cursor cursor = db.rawQuery(query,null);
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
                User user = new User(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3));
                userList.add(user);
                cursor.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            cursor.close();
        }
        return userList;
    }

    public void updatedata(int id,String name,String number,int isfav){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",name);
        contentValues.put("number",number);
        contentValues.put("isfav",isfav);
        sqLiteDatabase.update(Table,contentValues,"id=" + id,null);
    }

    public void deletedata(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Table,"id=?" + id,new String[]{String.valueOf(id)});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
