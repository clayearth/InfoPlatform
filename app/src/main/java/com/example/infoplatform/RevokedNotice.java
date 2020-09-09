package com.example.infoplatform;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infoplatform.adapter.NoticeAdapter;
import com.example.infoplatform.db.NoticeBean;
import com.example.infoplatform.db.NoticeDao;

public class RevokedNotice extends AppCompatActivity {
    private Button Return;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("--------进入页面建立---------------------");//

        super.onCreate(savedInstanceState);
        System.out.println("--------完成页面建立---------------------");//

        setContentView(R.layout.activity_revoked_notice);
        insertData();

        System.out.println("--------完成插入---------------------");//

        recyclerView = findViewById(R.id.rv_info_notice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoticeAdapter adapter = new NoticeAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoticeBeans(new NoticeDao(this).queryNotesAll("2"));
        adapter.notifyDataSetChanged();

    }

    public void insertData() {
        NoticeDao NoticeDao = new NoticeDao(this);
        if (NoticeDao.queryNotesAll("2").size() == 0) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2010年欲防治玉米螟公告");
            bean.setBody("2010年2018年要把专业化统防统治实施重点放在玉米螟防控上，力争防控全部实行专业化统防统治；防控能力和水平显著提升；防治效果、效益和效率显著提高。着力抓好典型示范；着力提升专业化统防统治现代化水平。");
            bean.setMoney("50万元");
            bean.setPlace("西藏省");
            bean.setType("2");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("2").size() == 1) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2019年度稻瘟病防治测试公告");
            bean.setBody("2019年度稻瘟病防治公告测试，请注意及时防治。");
            bean.setMoney("30万元");
            bean.setPlace("云南省");
            bean.setType("2");
            NoticeDao.insertNotice(bean);
        }

       /* if (NoticeDao.queryNotesAll("2").size() == 2) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2019年度玉米螟防治公告");
            bean.setBody("2019年度玉米螟防治公告，请合理安排防治时间，采取必要防治措施。");
            bean.setMoney("30万元");
            bean.setPlace("黑龙江省");
            bean.setType("2");
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
