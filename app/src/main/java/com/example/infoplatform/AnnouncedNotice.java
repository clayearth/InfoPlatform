package com.example.infoplatform;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infoplatform.adapter.NoticeAdapter;
import com.example.infoplatform.db.NoticeBean;
import com.example.infoplatform.db.NoticeDao;

public class AnnouncedNotice extends AppCompatActivity {
    private Button Return;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("--------进入页面建立---------------------");//

        super.onCreate(savedInstanceState);
        System.out.println("--------完成页面建立---------------------");//

        setContentView(R.layout.activity_announced_notice);
        insertData();

        System.out.println("--------完成插入---------------------");//

        recyclerView = findViewById(R.id.rv_info_notice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoticeAdapter adapter = new NoticeAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoticeBeans(new NoticeDao(this).queryNotesAll("1"));
        adapter.notifyDataSetChanged();

    }

    public void insertData() {
        NoticeDao NoticeDao = new NoticeDao(this);
        if (NoticeDao.queryNotesAll("1").size() == 0) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2018年防治玉米螟公告");
            bean.setBody("2018年要把专业化统防统治实施重点放在玉米螟防控上，力争经过2—3个月时间，防控全部实行专业化统防统治；防控能力和水平显著提升；防治效果、效益和效率显著提高。要实现上述目标，必须重点着力抓好专业化防治队伍建设；着力推进规范化管理；着力抓好指导服务工作；着力抓好典型示范；着力提升专业化统防统治现代化水平。");
            bean.setMoney("50万元");
            bean.setPlace("北京市");
            bean.setType("1");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("1").size() == 1) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2018年度稻瘟病防治公告");
            bean.setBody("2018年度稻瘟病防治公告测试，请注意及时防治。");
            bean.setMoney("50万元");
            bean.setPlace("辽宁省");
            bean.setType("1");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("1").size() == 2) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2019年度玉米螟防治公告");
            bean.setBody("2019年度玉米螟防治公告，请合理安排防治时间，采取必要防治措施。");
            bean.setMoney("30万元");
            bean.setPlace("吉林省");
            bean.setType("1");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("1").size() == 3) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2019年防治玉米螟公告");
            bean.setBody("力争经过2—3个月时间，防控全部实行专业化统防统治；防控能力和水平显著提升；防治效果、效益和效率显著提高。");
            bean.setMoney("10万元");
            bean.setPlace("宁夏回族自治区");
            bean.setType("1");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("1").size() == 4) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2020年度玉米螟防治公告");
            bean.setBody("防控能力和水平显著提升；防治效果、效益和效率显著提高。");
            bean.setMoney("75万元");
            bean.setPlace("黑龙江省");
            bean.setType("1");
            NoticeDao.insertNotice(bean);
        }

        if (NoticeDao.queryNotesAll("1").size() == 5) {
            NoticeBean bean = new NoticeBean();
            bean.setTitle("2020年度稻瘟病防治公告");
            bean.setBody("2018年度稻瘟病防治公告，请各单位注意及时防治。");
            bean.setMoney("40万元");
            bean.setPlace("辽宁省");
            bean.setType("1");
            NoticeDao.insertNotice(bean);
        }

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
