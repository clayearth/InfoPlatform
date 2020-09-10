package com.example.infoplatform;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infoplatform.adapter.JoAdapter;
import com.example.infoplatform.db.Jo_info;
import com.example.infoplatform.db.MydatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class SearchJoInfo extends AppCompatActivity {

    private MydatabaseHelper dbHelper;
    private List<Jo_info> jo_list = new ArrayList<Jo_info>();
    private ListView lv_jo;
    private JoAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jo_info_layout);
        dbHelper = MydatabaseHelper.getInstance(this);
        lv_jo = findViewById(R.id.lv_jo);
        initJo();
        adapter=new JoAdapter(SearchJoInfo.this,R.layout.jo_info_item,jo_list);
        lv_jo.setAdapter(adapter);
        //ListView点击事件

        lv_jo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //捕获作业的实例
                final Jo_info jo_info=jo_list.get(position);
                AlertDialog.Builder builder=new AlertDialog.Builder(SearchJoInfo.this);
                LayoutInflater factory=LayoutInflater.from(SearchJoInfo.this);
                //加载AlertDialog自定义布局
                View textEntryView = factory.inflate(R.layout.jo_lv_dialog,null);
                builder.setView(textEntryView);
                builder.setTitle("请选择需要的操作");

                //查看作业详细信息按钮
                Button select_button=textEntryView.findViewById(R.id.jo_info_select);
                select_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SearchJoInfo.this,Jo_detailed_info.class);
                        intent.putExtra("id", jo_info.getId());
                        intent.putExtra("gpsno", jo_info.getGpsno());
                        intent.putExtra("area", jo_info.getArea());
                        intent.putExtra("begindate", jo_info.getBegindate());
                        intent.putExtra("enddate", jo_info.getEnddate());
                        intent.putExtra("navitime", jo_info.getNavitime());
                        intent.putExtra("mileage", jo_info.getMileage());
                        intent.putExtra("provice",jo_info.getProvice());
                        intent.putExtra("provice_code",jo_info.getProvice_code());
                        startActivity(intent);
                    }
                });


                //删除作业信息按钮
                Button delete_button=textEntryView.findViewById(R.id.jo_info_delete);
                delete_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder delete_builder=new AlertDialog.Builder(SearchJoInfo.this);
                        delete_builder.setTitle("警告! !!!") ;
                        delete_builder.setMessage("您将删除该作业的信息,此操作不可以逆,请谨慎操作!");
                        delete_builder.setNegativeButton("取消", null);
                        delete_builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db=dbHelper.getReadableDatabase();
                                db.execSQL("delete from jo where id=?",new String[]{jo_info.getId()});
                                jo_list.remove(position);//在List中移除作业实例
                                adapter.notifyDataSetChanged();//刷新listview列表
                            }

                        });
                        delete_builder.create().show();
                    }
                });
                //修改作业信息,通过intent传递旧作业信息
                Button update_button =textEntryView.findViewById(R.id.jo_info_update);
                update_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SearchJoInfo.this,AddJoInfo.class);
                        intent.putExtra("haveData","true");
                        intent.putExtra("id", jo_info.getId());
                        intent.putExtra("gpsno", jo_info.getGpsno());
                        intent.putExtra("area", jo_info.getArea());
                        intent.putExtra("begindate", jo_info.getBegindate());
                        intent.putExtra("enddate", jo_info.getEnddate());
                        intent.putExtra("navitime", jo_info.getNavitime());
                        intent.putExtra("mileage", jo_info.getMileage());
                        intent.putExtra("provice", jo_info.getProvice());
                        intent.putExtra("provice_code", jo_info.getProvice_code());
                        startActivity(intent);

                    }
                });
                builder.create().show();
            }


        });



    }




    //从数据库中检索所有作业信息并初始化作业信息
    public void initJo(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from jo order by id",null);
        while (cursor.moveToNext()){
            String id=cursor.getString(cursor.getColumnIndex("id"));
            String gpsno = cursor.getString(cursor.getColumnIndex("gpsno"));
            String area = cursor.getString(cursor.getColumnIndex("area"));
            String begindate = cursor.getString(cursor.getColumnIndex("begindate"));
            String enddate = cursor.getString(cursor.getColumnIndex("enddate"));
            String navitime = cursor.getString(cursor.getColumnIndex("navitime"));
            String mileage = cursor.getString(cursor.getColumnIndex("mileage"));
            String provice = cursor.getString(cursor.getColumnIndex("provice"));
            String provice_code = cursor.getString(cursor.getColumnIndex("provice_code"));


            jo_list.add(new Jo_info(id,gpsno,area,begindate,enddate,navitime,mileage,provice,provice_code));
        }
        cursor.close();
    }
}
