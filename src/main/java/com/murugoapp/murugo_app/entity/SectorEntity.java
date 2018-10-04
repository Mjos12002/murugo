package com.murugoapp.murugo_app.entity;

public class SectorEntity {

    int districtID;
    String sectorName;

    public SectorEntity(int districtID, String sectorName) {
        this.districtID = districtID;
        this.sectorName = sectorName;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
