package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class chx_UserType extends AppCompatActivity {
    private Button Return;//返回主界面按钮
    private Button chx_growers;//种植户信息界面
    private Button chx_PPU;//植保站人员信息界面
    private Button chx_pco;//防治组织人员信息界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx__user_type);
        chx_growers=findViewById(R.id.btn_Growers);
        //给button设置点击事件
        chx_growers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_UserType.this, chx_Growers.class);
                startActivity(intent);
            }
        });

        chx_PPU = findViewById(R.id.btn_PlantProtectionUnit);
        chx_PPU.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //跳转到Button1演示界面
                Intent intent = new Intent(chx_UserType.this, chx_PlantProtectionUnit.class);
                startActivity(intent);
            }
        });

        chx_pco=findViewById(R.id.btn_PreventionAndControlOrganization);
        //给button设置点击事件
        chx_pco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_UserType.this, chx_PreventionAndControlOrganization.class);
                startActivity(intent);
            }
        });

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_UserType.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}