package com.example.infoplatform.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class chx_AppraiseDao {
    Context context;
    chx_AppraiseDBHelper dbHelper;

    public chx_AppraiseDao(Context context) {
        this.context = context;
        dbHelper = new chx_AppraiseDBHelper(context, "appraise.db", null, 1);
    }

    public void insertUser(String bean) {

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("app_content", bean);
        sqLiteDatabase.insert("appraise", null, cv);
    }
}
