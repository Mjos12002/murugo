package com.murugoapp.murugo_app.entity;

public class CellEntity {

    int sectorID;
    String sectorName;

    public CellEntity(int sectorID, String sectorName) {
        this.sectorID = sectorID;
        this.sectorName = sectorName;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
