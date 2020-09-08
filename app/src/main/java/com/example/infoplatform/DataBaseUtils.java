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

public class DataBaseUtils {

    private static String driver = "com.mysql.jdbc.Driver";// MySql驱动

//    private static String url = "jdbc:mysql://localhost:3306/map_designer_test_db";

    private static String user = "root";// 用户名
    private static String password = "root";// 密码

    private static Connection getConn(){

        Connection connection = null;
        try{
            Class.forName(driver);// 动态加载类
            String ip = "192.168.136.1";// 写成本机地址，不能写成localhost，同时手机和电脑连接的网络必须是同一个
            // 尝试建立到给定数据库URL的连接
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/info", user, password);
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

            String sql = "select * from explore_area2";

//            String sql = "select * from MD_CHARGER";
            if (connection != null){// connection不为null表示与数据库建立了连接
                PreparedStatement ps = connection.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();
                int count1 = rs.getMetaData().getColumnCount();
                System.out.println(count1);//"---------------------"
                if (rs != null){
                    int count = rs.getMetaData().getColumnCount();
//                        Log.e("DBUtils","列总数：" + count);
                    while (rs.next()){
                        String reportId = rs.getString(1);
                        String contactId = rs.getString(2);
                        String areaId = rs.getString(3);
                        String plantType = rs.getString(4);
                        String quality = rs.getString(5);
                        String solid = rs.getString(6);
                        String pest = rs.getString(7);
                        String plantStage = rs.getString(8);
                        String reporter = rs.getString(9);
                        String report_id = rs.getString(10);
                        String contact_id = rs.getString(11);
                        String area_id = rs.getString(12);
                        String plant_type = rs.getString(13);
                        String quality_ = rs.getString(14);
                        String solid_ = rs.getString(15);
                        String pest_ = rs.getString(16);
                        String plant_stage = rs.getString(17);
                        String reporter_ = rs.getString(18);
                        System.out.println(reportId + contactId + areaId + plantType + quality + solid + pest + plantStage + reporter );
                        map.put(reportId,report_id);
                        map.put(contactId,contact_id);
                        map.put(areaId,area_id);
                        map.put(plantType,plant_type);
                        map.put(quality,quality_);
                        map.put(solid,solid_);
                        map.put(pest,pest_);
                        map.put(plantStage,plant_stage);
                        map.put(reporter,reporter_);//"---------------------" + report_id + contact_id + area_id + plant_type + quality_ + solid_ + pest_ + plant_stage + reporter_
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
            Log.e("DBUtils","异常：" + e.getMessage());
            return null;
        }

    }

}
