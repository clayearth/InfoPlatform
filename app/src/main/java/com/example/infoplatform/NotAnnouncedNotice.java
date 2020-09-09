package com.example.infoplatform;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infoplatform.adapter.NoticeAdapter;
import com.example.infoplatform.db.NoticeBean;
import com.example.infoplatform.db.NoticeDao;

public class NotAnnouncedNotice extends AppCompatActivity {
    private Button Return;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("--------进入页面建立---------------------");//

        super.onCreate(savedInstanceState);
        System.out.println("--------完成页面建立---------------------");//

        setContentView(R.layout.activity_not_announced_notice);
        insertData();

        System.out.println("--------完成插入---------------------");//

        recyclerView = findViewById(R.id.rv_info_notice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoticeAdapter adapter = new NoticeAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoticeBeans(new NoticeDao(this).queryNotesAll("0"));
        adapter.notifyDataSetChanged();

    }

    public void insertData() {
        NoticeDao NoticeDao = new NoticeDao(this);
        if (NoticeDao.queryNotesAll("0").size() == 0) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2020年欲防治玉米螟公告（暂定）");
            bean.setBody("2020年要把专业化统防统治实施重点放在玉米螟防控上，力争经过2—3个月时间，防控全部实行专业化统防统治，着力提升专业化统防统治现代化水平。");
            bean.setMoney("50万元");
            bean.setPlace("吉林省");
            bean.setType("0");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("0").size() == 1) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2020年度稻瘟病防治公告（测试）");
            bean.setBody("2020年度稻瘟病防治公告测试，请注意及时防治。");
            bean.setMoney("30万元");
            bean.setPlace("新疆省");
            bean.setType("0");
            NoticeDao.insertNotice(bean);
        }

       /* if (NoticeDao.queryNotesAll("0").size() == 2) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2019年度玉米螟防治公告");
            bean.setBody("2019年度玉米螟防治公告，请合理安排防治时间，采取必要防治措施。");
            bean.setMoney("30万元");
            bean.setPlace("黑龙江省");
            bean.setType("0");
            NoticeDao.insertNotice(bean);
        }*/

        /*Return=findViewById(R.id.btngal);
        //给button设置点击事件
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面
                Intent intent = new Intent(AnnouncedNotice.this, MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
