package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class STAType extends AppCompatActivity {
    private Button Return;//返回主界面按钮
    private Button Area;//地块信息统计
    private Button Organization;//防治组织信息统计
    private Button AllData;//各地区历年数据汇总
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sta_type);

        Organization=findViewById(R.id.btn_Organization);
        //给button设置点击事件
        Organization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(STAType.this, STA_Organization.class);
                startActivity(intent);
            }
        });

        Area = findViewById(R.id.btn_Area);
        Area.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //跳转到TextView演示界面
                Intent intent = new Intent(STAType.this, STA_Area.class);
                startActivity(intent);
            }
        });

        AllData = findViewById(R.id.btn_AllData);
        //给button设置点击事件
        AllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(STAType.this, STA_AllData.class);
                startActivity(intent);
            }
        });

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(STAType.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}