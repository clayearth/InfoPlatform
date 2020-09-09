package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class chx_AboutUs extends AppCompatActivity {

    private Button AboutUsButton1;//knowus/了解我们
    private Button AboutUsButton2;//contactus/联系我们
    private Button AboutUsButton3;//findus/找到我们
    private Button AboutUsButton4;//evaluateus/评价我们

   // private Button Return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx__about_us);

        AboutUsButton1=findViewById(R.id.btn_KnowUs);
        //给button设置点击事件
        AboutUsButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_AboutUs.this, chx_KnowUs.class);
                startActivity(intent);
            }
        });

        AboutUsButton2=findViewById(R.id.btn_ContactUs);
        //给button设置点击事件
        AboutUsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_AboutUs.this, chx_ContactUs.class);
                startActivity(intent);
            }
        });

        AboutUsButton3=findViewById(R.id.btn_FindUs);
        //给button设置点击事件
        AboutUsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_AboutUs.this, chx_FindUs.class);
                startActivity(intent);
            }
        });

        AboutUsButton4=findViewById(R.id.btn_EvaluateUs);
        //给button设置点击事件
        AboutUsButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_AboutUs.this, chx_EvaluateUs.class);
                startActivity(intent);
            }
        });
/*
        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_AboutUs.this, MainActivity.class);
                startActivity(intent);
            }
        });
        */
    }
}