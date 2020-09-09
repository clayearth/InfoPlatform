package com.example.infoplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infoplatform.adapter.chx_UserAdapter;
import com.example.infoplatform.db.chx_UserBean;
import com.example.infoplatform.db.chx_UserDao;

public class chx_PlantProtectionUnit extends AppCompatActivity {



    private Button Return;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx_plant_protection_unit);
        insertData();

        recyclerView = findViewById(R.id.rv_info);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chx_UserAdapter adapter = new chx_UserAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setUserBeans(new chx_UserDao(this).queryNotesAll("2"));
        adapter.notifyDataSetChanged();

    }

    public void insertData() {
        chx_UserDao chxUserDao = new chx_UserDao(this);
        if (chxUserDao.queryNotesAll("2").size() == 0) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("17789077567");
            bean.setSex("女");
            bean.setAge("30");
            bean.setName("王一恒");
            bean.setType("2");

            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("2").size() == 1) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18955377288");
            bean.setSex("男");
            bean.setAge("25");
            bean.setName("王田齐");
            bean.setType("2");

            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("2").size() == 2) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("13877895564");
            bean.setSex("男");
            bean.setAge("26");
            bean.setName("李佳");
            bean.setType("2");
            chxUserDao.insertUser(bean);
        }
        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_PlantProtectionUnit.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}