package com.example.infoplatform;


import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 * 数据库工具类：连接数据库用、获取数据库数据用
 * 相关操作数据库的方法均可写在该类
 */

public class DataBaseUtils_bak {

    private static String driver = "com.mysql.jdbc.Driver";// MySql驱动

//    private static String url = "jdbc:mysql://localhost:3306/map_designer_test_db";

    private static String user = "root";// 用户名
    private static String password = "root";// 密码

    private static Connection getConn(){
        Connection connection = null;
        try{
            Class.forName(driver);// 动态加载类
            String ip = "202.205.84.149";// 写成本机地址，不能写成localhost，同时手机和电脑连接的网络必须是同一个
            // 尝试建立到给定数据库URL的连接
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/tftz", user, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static HashMap<String, Object> getInfoByName(String name){

        HashMap<String, Object> map = new HashMap<>();
        // 根据数据库名称，建立连接
        Connection connection = getConn();

        try {
            // mysql简单的查询语句。这里是根据MD_CHARGER表的NAME字段来查询某条记录

            String sql = "select * from xm_provincenotice";//+ name ;

//            String sql = "select * from MD_CHARGER";
            if (connection != null){// connection不为null表示与数据库建立了连接
                PreparedStatement ps = connection.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();
                int count1 = rs.getMetaData().getColumnCount();
                System.out.println(count1+"---------------------");//
                if (rs != null){
                    int count = rs.getMetaData().getColumnCount();
//                        Log.e("DataBaseUtils","列总数：" + count);
                    while (rs.next()){
                        String xm_pn_id = rs.getString(1);
                        String xm_pn_code = rs.getString(2);
                        String xm_pn_title = rs.getString(3);
                        String xm_pn_subsidymoney = rs.getString(4);
                        String xm_pn_content = rs.getString(5);
                        String xm_pn_state = rs.getString(6);
                        String createdat = rs.getString(7);
                        String createdby = rs.getString(8);
                        String lastupdatedat = rs.getString(9);
                        String lastupdatedby = rs.getString(10);
                        String isdeleted = rs.getString(11);
                        String deletedat = rs.getString(12);
                        String deletedby = rs.getString(13);
                        String timestamp = rs.getString(14);
                        String dautoid = rs.getString(15);
                        String companyid = rs.getString(16);
                        String organizeid = rs.getString(17);
                        String provice = rs.getString(18);
                        String provice_code = rs.getString(19);
                        String city = rs.getString(20);
                        String city_code = rs.getString(21);
                        String district = rs.getString(22);
                        String district_code = rs.getString(23);

//                        String reportId = rs.getString(1);
//                        String contactId = rs.getString(2);
//                        String areaId = rs.getString(3);
//                        String plantType = rs.getString(4);
//                        String quality = rs.getString(5);
//                        String solid = rs.getString(6);
//                        String pest = rs.getString(7);
//                        String plantStage = rs.getString(8);
//                        String reporter = rs.getString(9);
//                        String report_id = rs.getString(10);
//                        String contact_id = rs.getString(11);
//                        String area_id = rs.getString(12);
//                        String plant_type = rs.getString(13);
//                        String quality_ = rs.getString(14);
//                        String solid_ = rs.getString(15);
//                        String pest_ = rs.getString(16);
//                        String plant_stage = rs.getString(17);
//                        String reporter_ = rs.getString(18);
//                        System.out.println(reportId + contactId + areaId + plantType + quality + solid + pest + plantStage + reporter );
                        map.put("省公告编号",xm_pn_id);
                        map.put("省公告编码",xm_pn_code);
                        map.put("省公告标题",xm_pn_title);
                        map.put("省补助金额（万元）",xm_pn_subsidymoney);
                        map.put("省公告内容",xm_pn_content);
                        if (xm_pn_state=="0") map.put("省公告状态","未发布");
                        else if  (xm_pn_state=="1") map.put("省公告状态","已发布");
                        else map.put("省公告状态","已撤回");
                        map.put("省公告创建日期",createdat);
                        map.put("省公告创建者",createdby);
                        map.put("最近更新时间",lastupdatedat);
                        map.put("最近更新者",lastupdatedby);
                        if (isdeleted=="0") map.put("是否被删除","未被删除");
                        else map.put("是否被删除","已删除");
                        map.put("删除时间",deletedat);
                        map.put("删除者",deletedby);
                        map.put("时间戳",timestamp);
                        map.put("自动生成序列号",dautoid);
                        map.put("公司id",companyid);
                        map.put("组织id",organizeid);
                        map.put("省名称",provice);
                        map.put("省编码",provice_code);
                        map.put("市名称",city);
                        map.put("市编码",city_code);
                        map.put("县名称",district);
                        map.put("县编码",district_code);
                        System.out.println(xm_pn_id +' '+ xm_pn_title);
                    }
                    connection.close();
                    ps.close();
                    return  map;
                }else {
                    return null;
                }
            }else {
                return  null;
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("DataBaseUtils","异常：" + e.getMessage());
            return null;
        }

    }
}

