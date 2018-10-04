package com.murugoapp.murugo_app.entity;

public class popularLocationEntity {

    int cellID;
    String entityName;

    public popularLocationEntity(int cellID, String entityName) {
        this.cellID = cellID;
        this.entityName = entityName;
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
