package com.banquito.accounts.model;

import java.math.BigDecimal;

public class GeoLocation{
    private int codeLocation;
    private int geoCodeLocationParent;
    private String codeCountry;
    private BigDecimal geoLevel;
    private String name;
    private String phoneCodeArea;
    private String zipCode;

    public GeoLocation() {
    }

    // complete constructor
    public GeoLocation(int codeLocation, int geoCodeLocationParent, String codeCountry, BigDecimal geoLevel, String name, String phoneCodeArea, String zipCode) {
        this.codeLocation = codeLocation;
        this.geoCodeLocationParent = geoCodeLocationParent;
        this.codeCountry = codeCountry;
        this.geoLevel = geoLevel;
        this.name = name;
        this.phoneCodeArea = phoneCodeArea;
        this.zipCode = zipCode;
    }

    public int getCodeLocation() {
        return codeLocation;
    }

    public void setCodeLocation(int codeLocation) {
        this.codeLocation = codeLocation;
    }

    public int getGeoCodeLocationParent() {
        return geoCodeLocationParent;
    }

    public void setGeoCodeLocationParent(int geoCodeLocationParent) {
        this.geoCodeLocationParent = geoCodeLocationParent;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public BigDecimal getGeoLevel() {
        return geoLevel;
    }

    public void setGeoLevel(BigDecimal geoLevel) {
        this.geoLevel = geoLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCodeArea() {
        return phoneCodeArea;
    }

    public void setPhoneCodeArea(String phoneCodeArea) {
        this.phoneCodeArea = phoneCodeArea;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}