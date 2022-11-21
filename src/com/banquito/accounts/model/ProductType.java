package com.banquito.accounts.model;

public class ProductType {

    private String codeProductType;
    private String name;
    private String type;
    private String allowEarnInterest;
    private String allowGenAccState;
    private String temporalityInterst;

    public ProductType() {
    }

    public ProductType(String codeProductType, String name, String type, String allowEarnInterest,
            String allowGenAccState, String temporalityInterst) {
        this.codeProductType = codeProductType;
        this.name = name;
        this.type = type;
        this.allowEarnInterest = allowEarnInterest;
        this.allowGenAccState = allowGenAccState;
        this.temporalityInterst = temporalityInterst;
    }

    public String getCodeProductType() {
        return codeProductType;
    }

    public void setCodeProductType(String codeProductType) {
        this.codeProductType = codeProductType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAllowEarnInterest() {
        return allowEarnInterest;
    }

    public void setAllowEarnInterest(String allowEarnInterest) {
        this.allowEarnInterest = allowEarnInterest;
    }

    public String getAllowGenAccState() {
        return allowGenAccState;
    }

    public void setAllowGenAccState(String allowGenAccState) {
        this.allowGenAccState = allowGenAccState;
    }

    public String getTemporalityInterst() {
        return temporalityInterst;
    }

    public void setTemporalityInterst(String temporalityInterst) {
        this.temporalityInterst = temporalityInterst;
    }

}
