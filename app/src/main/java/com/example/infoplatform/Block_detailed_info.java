package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Block_detailed_info extends AppCompatActivity {

    private TextView id;
    private TextView location;
    private TextView area;
    private TextView circle;
    private TextView address;
    private TextView createdat;
    private TextView createdby;
    private TextView provice;
    private TextView provice_code;
    private Intent oldData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.block_detailed_info_layout);
        initViews();
        initinfo();
    }

    //取得控件
    public void initViews(){
        id =findViewById(R.id.add_id);
        location = findViewById(R.id.add_location);
        area   = findViewById(R.id.add_area);
        circle = findViewById(R.id.add_circle);
        address  = findViewById(R.id.add_address);
        createdat = findViewById(R.id.add_createdat);
        createdby = findViewById(R.id.add_createdby);
        provice = findViewById(R.id.add_provice);
        provice_code = findViewById(R.id.add_provice_code);
        oldData = getIntent();



    }
    //显示地块详细信息
    public void initinfo(){
        String oldID =oldData.getStringExtra("id");
        id.setText(oldID);
        String oldLocation = oldData.getStringExtra("location");
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
