package com.example.infoplatform.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class NoticeDao {
    Context context;
    NoticeDBHelper dbHelper;

    public NoticeDao(Context context) {
        this.context = context;
        dbHelper = new NoticeDBHelper(context, "info.db", null, 1);
    }

    public void insertNotice(NoticeBean bean) {

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("notice_title", bean.getTitle());
        cv.put("notice_place", bean.getPlace());
        cv.put("notice_body", bean.getBody());
        cv.put("notice_money", bean.getMoney());
        cv.put("notice_type", bean.getType());

        sqLiteDatabase.insert("notice_data", null, cv);
    }

    public int DeleteNote(int id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        int ret = 0;
        ret = sqLiteDatabase.delete("notice_data", "notice_id=?", new String[]{id + ""});
        return ret;
    }

    public Cursor getAllData(String note_owner) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "select * from notice_data where note_owner=?";
        return sqLiteDatabase.rawQuery(sql, new String[]{note_owner});
    }

    public void updateNote(NoticeBean bean) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("notice_title", bean.getTitle());
        cv.put("notice_place", bean.getPlace());
        cv.put("notice_body", bean.getBody());
        cv.put("notice_money", bean.getMoney());
        cv.put("notice_type", bean.getType());


        db.update("notice_data", cv, "notice_id=?", new String[]{bean.getNotice_id() + ""});
        db.close();
    }


    public List<NoticeBean> queryNotesAll(String type) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        List<NoticeBean> noteList = new ArrayList<>();
        NoticeBean note;
        String sql = "select * from notice_data where notice_type=? ";
        Cursor cursor = null;
        cursor = db.rawQuery(sql, new String[]{type});
        while (cursor.moveToNext()) {
            note = new NoticeBean();
            note.setNotice_id(cursor.getInt(cursor.getColumnIndex("notice_id")));
            note.setTitle(cursor.getString(cursor.getColumnIndex("notice_title")));
            note.setPlace(cursor.getString(cursor.getColumnIndex("notice_place")));
            note.setBody(cursor.getString(cursor.getColumnIndex("notice_body")));
            note.setMoney(cursor.getString(cursor.getColumnIndex("notice_money")));
            note.setType(cursor.getString(cursor.getColumnIndex("notice_type")));

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
