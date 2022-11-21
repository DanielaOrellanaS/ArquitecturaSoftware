package com.banquito.accounts.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Product {
    private String codeProduct;
    private String codeProductType;
    private String codeSegment;
    private String codeInterestRate;
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private String temporalityAccountState;
    private String useCheckbook;
    private String allowTransferences;
    private String typeCuent;
    private BigDecimal minOpeningBalance;

    public Product() {
    }

    public Product(String codeProduct, String codeProductType, String codeSegment, String codeInterestRate, String name,
            String status, Date startDate, Date endDate, String temporalityAccountState, String useCheckbook,
            String allowTransferences, String typeCuent, BigDecimal minOpeningBalance) {
        this.codeProduct = codeProduct;
        this.codeProductType = codeProductType;
        this.codeSegment = codeSegment;
        this.codeInterestRate = codeInterestRate;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.temporalityAccountState = temporalityAccountState;
        this.useCheckbook = useCheckbook;
        this.allowTransferences = allowTransferences;
        this.typeCuent = typeCuent;
        this.minOpeningBalance = minOpeningBalance;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getCodeProductType() {
        return codeProductType;
    }

    public void setCodeProductType(String codeProductType) {
        this.codeProductType = codeProductType;
    }

    public String getCodeSegment() {
        return codeSegment;
    }

    public void setCodeSegment(String codeSegment) {
        this.codeSegment = codeSegment;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTemporalityAccountState() {
        return temporalityAccountState;
    }

    public void setTemporalityAccountState(String temporalityAccountState) {
        this.temporalityAccountState = temporalityAccountState;
    }

    public String getUseCheckbook() {
        return useCheckbook;
    }

    public void setUseCheckbook(String useCheckbook) {
        this.useCheckbook = useCheckbook;
    }

    public String getAllowTransferences() {
        return allowTransferences;
    }

    public void setAllowTransferences(String allowTransferences) {
        this.allowTransferences = allowTransferences;
    }

    public String getTypeCuent() {
        return typeCuent;
    }

    public void setTypeCuent(String typeCuent) {
        this.typeCuent = typeCuent;
    }

    public BigDecimal getMinOpeningBalance() {
        return minOpeningBalance;
    }

    public void setMinOpeningBalance(BigDecimal minOpeningBalance) {
        this.minOpeningBalance = minOpeningBalance;
    }

}
