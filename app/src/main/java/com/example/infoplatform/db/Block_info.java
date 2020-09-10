package com.example.infoplatform.db;



public class Block_info {
    private String id;
    private String location;
    private String area;
    private String circle;
    private String address;
    private String createdat;
    private String createdby;
    private String provice;
    private String  provice_code;


    public Block_info(String id, String location, String area, String circle, String address, String createdat, String createdby, String provice, String provice_code) {

        this.id = id;
        this.location = location;
        this.area = area;
        this.circle = circle;
        this.address = address;
        this.createdat=createdat;
        this.createdby= createdby;
        this.provice=provice;
        this.provice_code=provice_code;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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
