package com.murugoapp.murugo_app.entity;

public class PopularLocationEntity {

    int id;
    int cellID;
    String entityName;

    public PopularLocationEntity(int id, int cellID, String entityName) {
        this.id = id;
        this.cellID = cellID;
        this.entityName = entityName;
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

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
