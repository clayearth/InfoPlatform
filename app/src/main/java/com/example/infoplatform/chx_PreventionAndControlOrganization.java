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

public class chx_PreventionAndControlOrganization extends AppCompatActivity {
    private Button Return;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx_prevention_and_control_organization);
        insertData();

        recyclerView = findViewById(R.id.rv_info);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chx_UserAdapter adapter = new chx_UserAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setUserBeans(new chx_UserDao(this).queryNotesAll("3"));
        adapter.notifyDataSetChanged();

    }

    public void insertData() {
        chx_UserDao chxUserDao = new chx_UserDao(this);
        if (chxUserDao.queryNotesAll("3").size() == 0) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("15576659045");
            bean.setSex("男");
            bean.setAge("45");
            bean.setName("王五");
            bean.setType("3");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("3").size() == 1) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18876009744");
            bean.setSex("女");
            bean.setAge("36");
            bean.setName("陈坤");
            bean.setType("3");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("3").size() == 2) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("15523323345");
            bean.setSex("男");
            bean.setAge("34");
            bean.setName("王雅漾");
            bean.setType("3");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("3").size() == 3) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("15565578970");
            bean.setSex("女");
            bean.setAge("29");
            bean.setName("孙兰蔻");
            bean.setType("3");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("3").size() == 4) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("15590098789");
            bean.setSex("男");
            bean.setAge("20");
            bean.setName("屈臣氏");
            bean.setType("3");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("3").size() == 5) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18898872209");
            bean.setSex("女");
            bean.setAge("32");
            bean.setName("杨碧柔");
            bean.setType("3");
            chxUserDao.insertUser(bean);
        }

        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_PreventionAndControlOrganization.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}