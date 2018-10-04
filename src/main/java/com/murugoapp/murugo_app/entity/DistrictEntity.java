package com.murugoapp.murugo_app.entity;

public class DistrictEntity {

    int provinceID;
    String districtName;

    public DistrictEntity(int provinceID, String districtName) {
        this.provinceID = provinceID;
        this.districtName = districtName;
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
