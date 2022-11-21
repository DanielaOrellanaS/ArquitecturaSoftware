package com.banquito.accounts.model;

import java.math.BigDecimal;

public class GeoStructurePK {
    private BigDecimal geoLevel;
    private String codeCountry;

    public GeoStructurePK() {
    }

    // complete constructor
    public GeoStructurePK(BigDecimal geoLevel, String codeCountry) {
        this.geoLevel = geoLevel;
        this.codeCountry = codeCountry;
    }

    public BigDecimal getGeoLevel() {
        return geoLevel;
    }

    public void setGeoLevel(BigDecimal geoLevel) {
        this.geoLevel = geoLevel;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }
}
