package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BlockInfo extends AppCompatActivity {
    private Button search;//查询地块信息按钮
    private Button add;//添加地块信息按钮
    private Button Return;//退回主界面按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.block_info);

        search=findViewById(R.id.btn_SearchBlockInfo);
        //给button设置点击事件
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(BlockInfo.this, SearchBlockInfo.class);
                startActivity(intent);
            }
        });

        add = findViewById(R.id.btn_AddBlockInfo);
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //跳转到Button1演示界面
                Intent intent = new Intent(BlockInfo.this, AddBlockInfo.class);
                startActivity(intent);
            }
        });

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(BlockInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}