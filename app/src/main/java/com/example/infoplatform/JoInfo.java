package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class JoInfo extends AppCompatActivity {
    private Button search;//查询作业信息按钮
    private Button add;//添加作业信息按钮
    private Button Return;//退回主界面按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jo_info);

        search=findViewById(R.id.btn_SearchJoInfo);
        //给button设置点击事件
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(JoInfo.this, SearchJoInfo.class);
                startActivity(intent);
            }
        });

        add = findViewById(R.id.btn_AddJoInfo);
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //跳转到Button1演示界面
                Intent intent = new Intent(JoInfo.this, AddJoInfo.class);
                startActivity(intent);
            }
        });

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(JoInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}