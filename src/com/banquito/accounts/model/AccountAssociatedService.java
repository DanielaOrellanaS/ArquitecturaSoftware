package com.banquito.accounts.model;

import java.sql.Timestamp;

public class AccountAssociatedService {
    private AccountAssociatedServicePK pk;
    private String status;
    private Timestamp startDate;
    private Timestamp endDate;

    public AccountAssociatedService() {
    }

    public AccountAssociatedService(AccountAssociatedServicePK pk, String status, Timestamp startDate,
            Timestamp endDate) {
        this.pk = pk;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AccountAssociatedServicePK getPk() {
        return pk;
    }

    public void setPk(AccountAssociatedServicePK pk) {
        this.pk = pk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

}
