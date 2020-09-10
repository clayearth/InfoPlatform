package com.example.infoplatform.db;



public class Jo_info {
    private String id;
    private String gpsno;
    private String area;
    private String begindate;
    private String enddate;
    private String navitime;
    private String mileage;
    private String provice;
    private String provice_code;


    public Jo_info(String id, String gpsno, String area, String begindate, String enddate, String navitime, String mileage, String provice, String provice_code) {

        this.id = id;
        this.gpsno = gpsno;
        this.area = area;
        this.begindate = begindate;
        this.enddate = enddate;
        this.navitime=navitime;
        this.mileage= mileage;
        this.provice=provice;
        this.provice_code=provice_code;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGpsno() {
        return gpsno;
    }

    public void setGpsno(String gpsno) {
        this.gpsno = gpsno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getNavitime() {
        return navitime;
    }

    public void setNavitime(String navitime) {
        this.navitime = navitime;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getProvice_code() {
        return provice_code;
    }

    public void setProvice_code(String provice_code) {
        this.provice_code = provice_code;
    }


}
