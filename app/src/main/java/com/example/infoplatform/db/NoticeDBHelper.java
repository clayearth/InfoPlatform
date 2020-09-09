package com.example.infoplatform.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class NoticeDBHelper extends SQLiteOpenHelper {
    public NoticeDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table if not exists notice_data(" +
                "notice_id integer primary key autoincrement," +
                "notice_title varchar,"+
                "notice_place varchar,"+
                "notice_body varchar,"+
                "notice_money varchar,"+

                "notice_type varchar)";
        sqLiteDatabase.execSQL(sql);
        System.out.println("notice database create------------");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
