package com.example.infoplatform;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infoplatform.db.MydatabaseHelper;


public class AddBlockInfo extends AppCompatActivity {

    private EditText id;
    private EditText location;
    private EditText area;
    private EditText circle;
    private EditText address;
    private EditText createdat;
    private EditText createdby;
    private EditText provice;
    private EditText provice_code;
    private MydatabaseHelper dbHelper;
    private String oldID;//用于防治修改信息时将ID也修改了，而原始的有该ID的地块信息还保存在数据库中
    private Intent oldData;//从修改地块数据界面跳转过来的旧数据

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.add_block_layout);
        initViews();


        /*oldData = getIntent();
        if (oldData.getStringExtra("haveData").equals("true")){
            initInfo();
        }*/



    }

    //获取View
    public void initViews(){
        id = (EditText) findViewById(R.id.add_id);
        location = (EditText) findViewById(R.id.add_location);
        area = (EditText) findViewById(R.id.add_area);
        circle = (EditText) findViewById(R.id.add_circle);
        address = (EditText) findViewById(R.id.add_address);
        createdat = (EditText) findViewById(R.id.add_createdat);
        createdby = (EditText) findViewById(R.id.add_createdby);
        provice = (EditText) findViewById(R.id.add_provice);
        provice_code = (EditText) findViewById(R.id.add_provice_code);
        dbHelper = MydatabaseHelper.getInstance(this);
    }

    //按下确定后,修改好的数据插入数据库
    public void query(View v){
        //sex不能为空否则程序崩溃，因为在StudentAdapter中有一个ImageView要设置图片
        //我这里要求id,name,sex都不能为空
        String id_ = id.getText().toString().trim();
        String location_ = location.getText().toString().trim();
        String area_ = area.getText().toString().trim();
        String circle_ = circle.getText().toString().trim();
        String address_ = address.getText().toString().trim();
        String createdat_ = createdat.getText().toString().trim();
        String createdby_ = createdby.getText().toString().trim();
        String provice_ = provice.getText().toString().trim();
        String provice_code_ = provice_code.getText().toString().trim();

        if(!TextUtils.isEmpty(id_)&&!TextUtils.isEmpty(id_)&&!TextUtils.isEmpty(location_)&&!TextUtils.isEmpty(area_)&&!TextUtils.isEmpty(circle_)&&!TextUtils.isEmpty(address_)){

            SQLiteDatabase db=dbHelper.getReadableDatabase();
            db.beginTransaction();//开启事务
            db.execSQL("delete from block where id=?",new String[]{oldID});
            Cursor cursor=db.rawQuery("select * from block where id=?",new String[]{id_});
            if (cursor.moveToNext()){
                Toast.makeText(this,"该ID号已被使用,请重新输入!",Toast.LENGTH_LONG).show();
            }else {
                db.execSQL("insert into block(id,location,area,circle,address,createdat,createdby,provice,provice_code) values (?,?,?,?,?,?,?,?,?)",new String[]{id_, location_, area_,circle_, address_,createdat_, createdby_, provice_,provice_code_,});
                db.setTransactionSuccessful();//事务成功
                db.endTransaction();//结束事务
                Intent intent=new Intent(this,BlockInfo.class);
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(this,"ID,坐标,面积,周长,地址不能为空!",Toast.LENGTH_LONG).show();
        }
    }
    //按下取消按钮后跳关闭此页面
    public void cancle(View v){
        finish();

    }

    //恢复旧数据
    public void initInfo(){
        String oldId = oldData.getStringExtra("id");
        oldID = oldId;
        id.setText(oldId);
        String oldLocation= oldData.getStringExtra("location");
        location.setText(oldLocation);
        String oldArea = oldData.getStringExtra("area");
        area.setText(oldArea);
        String oldCircle = oldData.getStringExtra("circle");
        circle.setText(oldCircle);
        String oldAddress = oldData.getStringExtra("address");
        address.setText(oldAddress);
        String oldCreatedat = oldData.getStringExtra("createdat");
        createdat.setText(oldCreatedat);
        String oldCreatedby = oldData.getStringExtra("createdby");
        createdby.setText(oldCreatedby);
        String oldProvice = oldData.getStringExtra("provice");
        provice.setText(oldProvice);
        String oldProvice_code = oldData.getStringExtra("provice_code");
        provice_code.setText(oldProvice_code);
    }


}
