package com.example.infoplatform.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MydatabaseHelper extends SQLiteOpenHelper {
    private  static  MydatabaseHelper instance;
    //创建地块表
    public static final String CREATE_BLOCK="create table block(id integer primary key autoincrement,location text ,area float ,circle float ,address text, createdat text, createdby text, provice text, provice_code text)";
    //创建作业表
    public static final String CREATE_JO="create table jo(id integer primary key autoincrement,gpsno text ,area text,begindate text,enddate text,navitime text,mileage text,provice text, provice_code text)";

    private MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public  void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BLOCK);
        db.execSQL(CREATE_JO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  static MydatabaseHelper getInstance(Context context){
        if (instance==null){
            instance=new MydatabaseHelper(context,"studen_tmanager.db",null,3);

        }
        return instance;
    }
}
