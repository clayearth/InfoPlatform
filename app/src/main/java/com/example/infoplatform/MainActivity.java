package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //声明按钮组件
    private Button UserTypeButton;
    private Button AboutUsButton;
    private Button NoticeTypeButton;
    private Button STA_Button;
    private Button BlockInfoButton;
    private Button JoInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserTypeButton=findViewById(R.id.btn_UserType);
        //给button设置点击事件
        UserTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this, chx_UserType.class);
                startActivity(intent);
            }
        });

        NoticeTypeButton=findViewById(R.id.btn_NoticeType);
        //给button设置点击事件
        NoticeTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this, NoticeType.class);
                startActivity(intent);
            }
        });

        STA_Button=findViewById(R.id.btn_STA);
        //给button设置点击事件
        STA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面STA
                Intent intent = new Intent(MainActivity.this, STAType.class);
                startActivity(intent);
            }
        });

        BlockInfoButton=findViewById(R.id.btn_BlockInfo);
        //给button设置点击事件
        BlockInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this, BlockInfo.class);
                startActivity(intent);
            }
        });

        JoInfoButton=findViewById(R.id.btn_JoInfo);
        //给button设置点击事件
        JoInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this, JoInfo.class);
                startActivity(intent);
            }
        });

        AboutUsButton=findViewById(R.id.btn_AboutUs);
        //给button设置点击事件
        AboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this, chx_AboutUs.class);
                startActivity(intent);
            }
        });

        chx_Database helper = new chx_Database(this);
        helper.getWritableDatabase();
    }
}