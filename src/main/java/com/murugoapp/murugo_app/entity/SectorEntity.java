package com.murugoapp.murugo_app.entity;

public class SectorEntity {

    int id;
    int districtID;
    String sectorName;

    public SectorEntity(int id, int districtID, String sectorName) {
        this.id = id;
        this.districtID = districtID;
        this.sectorName = sectorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
