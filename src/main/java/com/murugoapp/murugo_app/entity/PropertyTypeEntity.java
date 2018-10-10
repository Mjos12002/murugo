package com.murugoapp.murugo_app.entity;

public class PropertyTypeEntity {
    public int id;
    public String propertyTypeName;

    public PropertyTypeEntity(int id, String propertyTypeName) {
        this.id = id;
        this.propertyTypeName = propertyTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }
}
