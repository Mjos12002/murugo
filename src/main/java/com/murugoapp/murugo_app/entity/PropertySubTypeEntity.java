package com.murugoapp.murugo_app.entity;


public class PropertySubTypeEntity {

    public int id;
    public String propertySubTypeName;
    public int propertyTypeID;
    public String propertyClass;

    public PropertySubTypeEntity(int id, String propertySubTypeName, int propertyTypeID, String propertyClass) {
        this.id = id;
        this.propertySubTypeName = propertySubTypeName;
        this.propertyTypeID = propertyTypeID;
        this.propertyClass = propertyClass;
    }

    public String getPropertyClass() {
        return propertyClass;
    }

    public void setPropertyClass(String propertyClass) {
        this.propertyClass = propertyClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertySubTypeName() {
        return propertySubTypeName;
    }

    public void setPropertySubTypeName(String propertySubTypeName) {
        this.propertySubTypeName = propertySubTypeName;
    }

    public int getPropetyTypeID() {
        return propertyTypeID;
    }

    public void setPropetyTypeID(int propetyTypeID) {
        this.propertyTypeID = propetyTypeID;
    }
}
