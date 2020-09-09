package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NoticeType extends AppCompatActivity {
    private Button Return;//返回主界面按钮
    private Button NotAnnounced;//未发布公告界面
    private Button Announced;//已发布公告界面
    private Button Revoke;//已删除公告页面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_type);

        NotAnnounced=findViewById(R.id.btn_NotAnnounced);
        //给button设置点击事件
        NotAnnounced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(NoticeType.this, NotAnnouncedNotice.class);
                startActivity(intent);
            }
        });

        Announced = findViewById(R.id.btn_Announced);
        Announced.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //跳转到TextView演示界面
                Intent intent = new Intent(NoticeType.this, AnnouncedNotice.class);
                startActivity(intent);
            }
        });

        Revoke = findViewById(R.id.btn_Revoked);
        //给button设置点击事件
        Revoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(NoticeType.this, RevokedNotice.class);
                startActivity(intent);
            }
        });

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(NoticeType.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}