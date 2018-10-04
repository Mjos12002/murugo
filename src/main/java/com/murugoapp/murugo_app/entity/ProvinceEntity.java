package com.murugoapp.murugo_app.entity;

public class ProvinceEntity {

    int id;
    String provinceName;

    public ProvinceEntity(int id, String provinceName) {
        this.id = id;
        this.provinceName = provinceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
