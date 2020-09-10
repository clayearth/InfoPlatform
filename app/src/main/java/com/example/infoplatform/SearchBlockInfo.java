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

import com.example.infoplatform.adapter.BlockAdapter;
import com.example.infoplatform.db.Block_info;
import com.example.infoplatform.db.MydatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class SearchBlockInfo extends AppCompatActivity {

    private MydatabaseHelper dbHelper;
    private List<Block_info> block_list = new ArrayList<Block_info>();
    private ListView lv_block;
    private BlockAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.block_info_layout);
        dbHelper = MydatabaseHelper.getInstance(this);
        lv_block = findViewById(R.id.lv_block);
        initBlock();
        adapter=new BlockAdapter(SearchBlockInfo.this,R.layout.block_info_item,block_list);
        lv_block.setAdapter(adapter);
        //ListView点击事件
        lv_block.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //捕获地块的实例
                final Block_info block_info=block_list.get(position);
                AlertDialog.Builder builder=new AlertDialog.Builder(SearchBlockInfo.this);
                LayoutInflater factory=LayoutInflater.from(SearchBlockInfo.this);
                //加载AlertDialog自定义布局
                View textEntryView = factory.inflate(R.layout.block_lv_dialog,null);
                builder.setView(textEntryView);
                builder.setTitle("请选择需要的操作");

                //查看地块详细信息按钮
                Button select_button=textEntryView.findViewById(R.id.block_info_select);
                select_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SearchBlockInfo.this,Block_detailed_info.class);
                        intent.putExtra("id", block_info.getId());
                        intent.putExtra("location", block_info.getLocation());
                        intent.putExtra("area", block_info.getArea());
                        intent.putExtra("circle", block_info.getCircle());
                        intent.putExtra("address", block_info.getAddress());
                        intent.putExtra("createdat", block_info.getCreatedat());
                        intent.putExtra("createdby", block_info.getCreatedby());
                        intent.putExtra("provice",block_info.getProvice());
                        intent.putExtra("provice_code",block_info.getProvice_code());
                        startActivity(intent);
                    }
                });


                //删除地块信息按钮
                Button delete_button=textEntryView.findViewById(R.id.block_info_delete);
                delete_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder delete_builder=new AlertDialog.Builder(SearchBlockInfo.this);
                        delete_builder.setTitle("警告! !!!") ;
                        delete_builder.setMessage("您将删除该地块的信息,此操作不可以逆,请谨慎操作!");
                        delete_builder.setNegativeButton("取消", null);
                        delete_builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db=dbHelper.getReadableDatabase();
                                db.execSQL("delete from block where id=?",new String[]{block_info.getId()});
                                block_list.remove(position);//在List中移除学生实例
                                adapter.notifyDataSetChanged();//刷新listview列表
                            }

                        });
                        delete_builder.create().show();
                    }
                });
                //修改学生信息,通过intent传递旧学生信息
                Button update_button =textEntryView.findViewById(R.id.block_info_update);
                update_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SearchBlockInfo.this,AddBlockInfo.class);
                        intent.putExtra("haveData","true");
                        intent.putExtra("id", block_info.getId());
                        intent.putExtra("location", block_info.getLocation());
                        intent.putExtra("area", block_info.getArea());
                        intent.putExtra("circle", block_info.getCircle());
                        intent.putExtra("address", block_info.getAddress());
                        intent.putExtra("createdat", block_info.getCreatedat());
                        intent.putExtra("createdby", block_info.getCreatedby());
                        intent.putExtra("provice", block_info.getProvice());
                        intent.putExtra("provice_code", block_info.getProvice_code());
                        startActivity(intent);

                    }
                });
                builder.create().show();
            }
        });

    }


    //从数据库中检索所有学生信息并初始化学生信息
    public void initBlock(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from block order by id",null);
        while (cursor.moveToNext()){
            String id=cursor.getString(cursor.getColumnIndex("id"));
            String location = cursor.getString(cursor.getColumnIndex("location"));
            String area = cursor.getString(cursor.getColumnIndex("area"));
            String circle = cursor.getString(cursor.getColumnIndex("circle"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String createdat = cursor.getString(cursor.getColumnIndex("createdat"));
            String createdby = cursor.getString(cursor.getColumnIndex("createdby"));
            String provice = cursor.getString(cursor.getColumnIndex("provice"));
            String provice_code = cursor.getString(cursor.getColumnIndex("provice_code"));


            block_list.add(new Block_info(id,location,area,circle,address,createdat,createdby,provice,provice_code));
        }
        cursor.close();
    }
}
