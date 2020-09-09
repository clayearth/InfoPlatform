package com.example.infoplatform.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class chx_UserDBHelper extends SQLiteOpenHelper {
    public chx_UserDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table if not exists user_data(" +
                "user_id integer primary key autoincrement," +
                "user_name varchar,"+
                "user_age varchar,"+
                "user_sex varchar,"+
                "user_type varchar,"+

                "user_phone varchar)";
        sqLiteDatabase.execSQL(sql);
        System.out.println("user_data database create------------");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
