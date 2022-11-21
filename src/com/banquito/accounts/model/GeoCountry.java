
package com.banquito.accounts.model;

public class GeoCountry {
    private String codeCountry;
    private String codePhone;
    private String name;

    public GeoCountry() {
    }

    public GeoCountry(String codeCountry, String codePhone, String name) {
        this.codeCountry = codeCountry;
        this.codePhone = codePhone;
        this.name = name;

    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getCodePhone() {
        return codePhone;
    }

    public void setCodePhone(String codePhone) {
        this.codePhone = codePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}