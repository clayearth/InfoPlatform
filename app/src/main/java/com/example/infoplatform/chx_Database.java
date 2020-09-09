package com.example.infoplatform;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class chx_Database extends SQLiteOpenHelper {
    private static final String TAG = "chx_Database";

    public chx_Database(@Nullable Context context) {
        super(context, chx_Constants.database_name, null, chx_Constants.version_code);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建时的回调
        //只执行一次，创建时执行，更新时使用升级数据库，或删除db文件后重新运行
        Log.d(TAG,"创建数据库");
        String sql = "create table "+ chx_Constants.table_name +"(_id integer,name varchar,sex varchar,age integer,phone integer,area varchar)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //升级数据库时的回调
        Log.d(TAG,"升级数据库");
        //添加字段
        //sql: alter table table_name add phone integer;
        //String sql="alter table "+chx_Constants.table_name+" add phone integer";
        //sqLiteDatabase.execSQL(sql);
    }
}
