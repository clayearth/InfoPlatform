package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class chx_ContactUs extends AppCompatActivity {

    private Button Return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx__contact_us);

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_ContactUs.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}


