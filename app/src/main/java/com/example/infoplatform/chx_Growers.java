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

public class chx_Growers extends AppCompatActivity {
    private Button Return;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chx_growers);
        insertData();

        recyclerView = findViewById(R.id.rv_info);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chx_UserAdapter adapter = new chx_UserAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setUserBeans(new chx_UserDao(this).queryNotesAll("1"));
        adapter.notifyDataSetChanged();

    }

    public void insertData() {
        chx_UserDao chxUserDao = new chx_UserDao(this);
        if (chxUserDao.queryNotesAll("1").size() == 0) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("17866765439");
            bean.setSex("男");
            bean.setAge("26");
            bean.setName("张率");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 1) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18898709963");
            bean.setSex("男");
            bean.setAge("28");
            bean.setName("欧阳锋");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 2) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18766549980");
            bean.setSex("男");
            bean.setAge("30");
            bean.setName("李蓓蓓");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 3) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18766320090");
            bean.setSex("女");
            bean.setAge("27");
            bean.setName("张安卓");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 4) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("13255647789");
            bean.setSex("男");
            bean.setAge("32");
            bean.setName("李农业");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 5) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("18077678940");
            bean.setSex("男");
            bean.setAge("33");
            bean.setName("王实训");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 6) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("17844673300");
            bean.setSex("女");
            bean.setAge("31");
            bean.setName("王二衡");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 7) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("15587599090");
            bean.setSex("女");
            bean.setAge("27");
            bean.setName("威宁");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }

        if (chxUserDao.queryNotesAll("1").size() == 8) {
            chx_UserBean bean = new chx_UserBean();
            bean.setPhone("17844673300");
            bean.setSex("女");
            bean.setAge("24");
            bean.setName("刘海");
            bean.setType("1");
            chxUserDao.insertUser(bean);
        }
        Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(chx_Growers.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
