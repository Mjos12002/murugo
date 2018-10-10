package com.murugoapp.murugo_app.entity;

public class ListingTypeEntity {
    public int id;
    public String listingTypeName;

    public ListingTypeEntity(int id, String listingTypeName) {
        this.id = id;
        this.listingTypeName = listingTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListingTypeName() {
        return listingTypeName;
    }

    public void setListingTypeName(String listingTypeName) {
        this.listingTypeName = listingTypeName;
    }
}
