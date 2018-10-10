package com.murugoapp.murugo_app.entity;

public class PopularLocationEntity {

    int id;
    int cellID;
    String locationName;

    public PopularLocationEntity(int id, int cellID, String locationName) {
        this.id = id;
        this.cellID = cellID;
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCellID() {
        return cellID;
    }

    public void setCellID(int cellID) {
        this.cellID = cellID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void getLocationName(String locationName) {
        this.locationName = locationName;
    }
}
