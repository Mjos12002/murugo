package com.murugoapp.murugo_app.entity;

public class DistrictEntity {

    int id;
    int provinceID;
    String districtName;

    public DistrictEntity(int id, int provinceID, String districtName) {
        this.id = id;
        this.provinceID = provinceID;
        this.districtName = districtName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
