package com.banquito.accounts.model;

public class InterestRate {
    private String codeInterestRate;
    private String name;
    private String type;
    private String calcBase;

    public InterestRate() {
    }

    public InterestRate(String codeInterestRate, String name, String type, String calcBase) {
        this.codeInterestRate = codeInterestRate;
        this.name = name;
        this.type = type;
        this.calcBase = calcBase;
    }

    public String getCodeInterestRate() {
        return codeInterestRate;
    }

    public void setCodeInterestRate(String codeInterestRate) {
        this.codeInterestRate = codeInterestRate;
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

    public String getCalcBase() {
        return calcBase;
    }

    public void setCalcBase(String calcBase) {
        this.calcBase = calcBase;
    }

}
