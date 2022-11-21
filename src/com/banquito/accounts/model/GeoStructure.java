package com.banquito.accounts.model;

public class GeoStructure {
    private GeoStructurePK geoStructurePK;
    private String name;

    public GeoStructure() {
    }

    // complete constructor
    public GeoStructure(GeoStructurePK geoStructurePK, String name) {
        this.geoStructurePK = geoStructurePK;
        this.name = name;
    }

    public GeoStructurePK getGeoStructurePK() {
        return geoStructurePK;
    }

    public void setGeoStructurePK(GeoStructurePK geoStructurePK) {
        this.geoStructurePK = geoStructurePK;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
