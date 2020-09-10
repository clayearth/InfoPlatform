package com.example.infoplatform;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class STA_AllData extends AppCompatActivity {
    //显示的图表
    public BarChart barChart;
    //保存数据的实体（下面定义了两组数据集合）
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
   // public ArrayList<BarEntry> entries1 = new ArrayList<>();
    //数据的集合（每组数据都需要一个数据集合存放数据实体和该组的样式）
    public BarDataSet dataset;

    //表格下方的文字
    public ArrayList<String> labels = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sta_figure);
        barChart = (BarChart) findViewById(R.id.bar_chart);
        entries.add(new BarEntry(80f, 0));
        entries.add(new BarEntry(58f, 1));
        entries.add(new BarEntry(67f, 2));
        entries.add(new BarEntry(60f, 3));
        entries.add(new BarEntry(84f, 4));
        entries.add(new BarEntry(68f, 5));
        entries.add(new BarEntry(51f, 6));
        entries.add(new BarEntry(78f, 7));
        entries.add(new BarEntry(47f, 8));
        entries.add(new BarEntry(83f, 9));

        labels.add("海淀区");
        labels.add("西城区");
        labels.add("朝阳区");
        labels.add("丰台区");
        labels.add("东城区");
        labels.add("房山区");
        labels.add("通州区");
        labels.add("顺义区");
        labels.add("昌平区");
        labels.add("大兴区");

        dataset = new BarDataSet(entries, "各地区历年数据汇总");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset);
        // dataSets.add(dataSet1);
        BarData data = new BarData(labels, dataSets);
        barChart.setData(data);



        //设置单个点击事件
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(getApplicationContext(),entry.getVal()+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        //设置显示动画效果
        barChart.animateY(2000);
        //设置图标右下放显示文字
        barChart.setDescription("防治组织统计图表");

    }
}
