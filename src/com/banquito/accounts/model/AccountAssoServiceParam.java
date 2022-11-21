package com.banquito.accounts.model;

import java.sql.Timestamp;

public class AccountAssoServiceParam {
    private AccountAssoServiceParamPK pk;
    private String status;
    private String textValue;
    private Timestamp dateValuel;
    private double numberValue;
    private Timestamp createDate;
    private Timestamp endDate;

    public AccountAssoServiceParam() {
    }

    public AccountAssoServiceParam(AccountAssoServiceParamPK pk, String status, String textValue, Timestamp dateValuel,
            double numberValue, Timestamp createDate, Timestamp endDate) {
        this.pk = pk;
        this.status = status;
        this.textValue = textValue;
        this.dateValuel = dateValuel;
        this.numberValue = numberValue;
        this.createDate = createDate;
        this.endDate = endDate;
    }

    public AccountAssoServiceParamPK getPk() {
        return pk;
    }

    public void setPk(AccountAssoServiceParamPK pk) {
        this.pk = pk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Timestamp getDateValuel() {
        return dateValuel;
    }

    public void setDateValuel(Timestamp dateValuel) {
        this.dateValuel = dateValuel;
    }

    public double getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(double numberValue) {
        this.numberValue = numberValue;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

}
