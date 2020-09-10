package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Jo_detailed_info extends AppCompatActivity {

    private TextView id;
    private TextView gpsno;
    private TextView area;
    private TextView begindate;
    private TextView enddate;
    private TextView navitime;
    private TextView mileage;
    private TextView provice;
    private TextView provice_code;
    private Intent oldData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.jo_detailed_info_layout);
        initViews();
        initinfo();
    }

    //取得控件
    public void initViews(){
        id =findViewById(R.id.add_id);
        gpsno = findViewById(R.id.add_gpsno);
        area   = findViewById(R.id.add_area);
        begindate = findViewById(R.id.add_begindate);
        enddate  = findViewById(R.id.add_enddate);
        navitime = findViewById(R.id.add_navitime);
        mileage = findViewById(R.id.add_mileage);
        provice = findViewById(R.id.add_provice);
        provice_code = findViewById(R.id.add_provice_code);
        oldData = getIntent();



    }
    //显示地块详细信息
    public void initinfo(){
        String oldID =oldData.getStringExtra("id");
        id.setText(oldID);
        String oldGpsno = oldData.getStringExtra("gpsno");
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
