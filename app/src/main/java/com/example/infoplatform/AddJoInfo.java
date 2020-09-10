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


public class AddJoInfo extends AppCompatActivity {

    private EditText id;
    private EditText gpsno;
    private EditText area;
    private EditText begindate;
    private EditText enddate;
    private EditText navitime;
    private EditText mileage;
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
        setContentView(R.layout.add_jo_layout);
        initViews();

        /*
        oldData = getIntent();
        if (oldData.getStringExtra("haveData").equals("true")){
            initInfo();
        }

         */



    }

    //获取View
    public void initViews(){
        id = (EditText) findViewById(R.id.add_id);
        gpsno = (EditText) findViewById(R.id.add_gpsno);
        area = (EditText) findViewById(R.id.add_area);
        begindate = (EditText) findViewById(R.id.add_begindate);
        enddate = (EditText) findViewById(R.id.add_enddate);
        navitime = (EditText) findViewById(R.id.add_navitime);
        mileage = (EditText) findViewById(R.id.add_mileage);
        provice = (EditText) findViewById(R.id.add_provice);
        provice_code = (EditText) findViewById(R.id.add_provice_code);
        dbHelper = MydatabaseHelper.getInstance(this);
    }

    //按下确定后,修改好的数据插入数据库
    public void query(View v){
        //sex不能为空否则程序崩溃，因为在StudentAdapter中有一个ImageView要设置图片
        //我这里要求id,name,sex都不能为空
        String id_ = id.getText().toString().trim();
        String gpsno_ = gpsno.getText().toString().trim();
        String area_ = area.getText().toString().trim();
        String begindate_ = begindate.getText().toString().trim();
        String enddate_ = enddate.getText().toString().trim();
        String navitime_ = navitime.getText().toString().trim();
        String mileage_ = mileage.getText().toString().trim();
        String provice_ = provice.getText().toString().trim();
        String provice_code_ = provice_code.getText().toString().trim();

        if(!TextUtils.isEmpty(id_)&&!TextUtils.isEmpty(id_)&&!TextUtils.isEmpty(gpsno_)&&!TextUtils.isEmpty(area_)&&!TextUtils.isEmpty(begindate_)&&!TextUtils.isEmpty(enddate_)){

            SQLiteDatabase db=dbHelper.getReadableDatabase();
            db.beginTransaction();//开启事务
            db.execSQL("delete from jo where id=?",new String[]{oldID});
            Cursor cursor=db.rawQuery("select * from jo where id=?",new String[]{id_});
            if (cursor.moveToNext()){
                Toast.makeText(this,"该ID号已被使用,请重新输入!",Toast.LENGTH_LONG).show();
            }else {
                db.execSQL("insert into jo(id,gpsno,area,begindate,enddate,navitime,mileage,provice,provice_code) values (?,?,?,?,?,?,?,?,?)",new String[]{id_, gpsno_, area_,begindate_, enddate_,navitime_, mileage_, provice_,provice_code_,});
                db.setTransactionSuccessful();//事务成功
                db.endTransaction();//结束事务
                Intent intent=new Intent(this,JoInfo.class);
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(this,"ID,GPS编号,作业面积,开始时间,结束时间不能为空!",Toast.LENGTH_LONG).show();
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
        String oldGpsno= oldData.getStringExtra("gpsno");
        gpsno.setText(oldGpsno);
        String oldArea = oldData.getStringExtra("area");
        area.setText(oldArea);
        String oldBegindate = oldData.getStringExtra("begindate");
        begindate.setText(oldBegindate);
        String oldEnddate = oldData.getStringExtra("enddate");
        enddate.setText(oldEnddate);
        String oldNavitime = oldData.getStringExtra("navitime");
        navitime.setText(oldNavitime);
        String oldMileage = oldData.getStringExtra("mileage");
        mileage.setText(oldMileage);
        String oldProvice = oldData.getStringExtra("provice");
        provice.setText(oldProvice);
        String oldProvice_code = oldData.getStringExtra("provice_code");
        provice_code.setText(oldProvice_code);
    }


}
