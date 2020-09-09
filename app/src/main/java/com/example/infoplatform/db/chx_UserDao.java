package com.example.infoplatform.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class chx_UserDao {
    Context context;
    chx_UserDBHelper dbHelper;

    public chx_UserDao(Context context) {
        this.context = context;
        dbHelper = new chx_UserDBHelper(context, "user.db", null, 1);
    }

    public void insertUser(chx_UserBean bean) {

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_name", bean.getName());
        cv.put("user_age", bean.getAge());
        cv.put("user_sex", bean.getSex());
        cv.put("user_phone", bean.getPhone());
        cv.put("user_type", bean.getType());

        sqLiteDatabase.insert("user_data", null, cv);
    }

    public int DeleteNote(int id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        int ret = 0;
        ret = sqLiteDatabase.delete("user_data", "user_id=?", new String[]{id + ""});
        return ret;
    }

    public Cursor getAllData(String note_owner) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "select * from user_data where note_owner=?";
        return sqLiteDatabase.rawQuery(sql, new String[]{note_owner});
    }

    public void updateNote(chx_UserBean bean) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_name", bean.getName());
        cv.put("user_age", bean.getAge());
        cv.put("user_sex", bean.getSex());
        cv.put("user_phone", bean.getPhone());
        cv.put("user_type", bean.getType());


        db.update("user_data", cv, "user_id=?", new String[]{bean.getUser_id() + ""});
        db.close();
    }


    public List<chx_UserBean> queryNotesAll(String type) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        List<chx_UserBean> noteList = new ArrayList<>();
        chx_UserBean note;
        String sql = "select * from user_data where user_type=? ";
        Cursor cursor = null;
        cursor = db.rawQuery(sql, new String[]{type});
        while (cursor.moveToNext()) {
            note = new chx_UserBean();
            note.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
            note.setName(cursor.getString(cursor.getColumnIndex("user_name")));
            note.setAge(cursor.getString(cursor.getColumnIndex("user_age")));
            note.setSex(cursor.getString(cursor.getColumnIndex("user_sex")));
            note.setPhone(cursor.getString(cursor.getColumnIndex("user_phone")));
            note.setType(cursor.getString(cursor.getColumnIndex("user_type")));

            noteList.add(note);
        }

        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }

        return noteList;
    }


}
