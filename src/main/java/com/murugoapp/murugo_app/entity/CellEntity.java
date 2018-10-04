package com.murugoapp.murugo_app.entity;

public class CellEntity {

    int id;
    int sectorID;
    String cellName;

    public CellEntity(int id, int sectorID, String cellName) {
        this.id = id;
        this.sectorID = sectorID;
        this.cellName = cellName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }
}
