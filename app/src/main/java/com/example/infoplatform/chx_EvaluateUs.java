package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infoplatform.db.chx_AppraiseDao;

public class chx_EvaluateUs extends AppCompatActivity {
    private Button Return;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx__evaluate_us);
        editText = findViewById(R.id.et_suggest);
        findViewById(R.id.btn_commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(chx_EvaluateUs.this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Toast.makeText(chx_EvaluateUs.this,"提交成功，感谢您的评价(*^_^*)",Toast.LENGTH_SHORT).show();
                }
                new chx_AppraiseDao(chx_EvaluateUs.this).insertUser(editText.getText().toString());
                finish();
            }
        });

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_EvaluateUs.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}