package com.banquito.accounts.model;

import java.sql.Timestamp;

public class AccountSignature {
    private AccountSignaturePK pk;
    private String role;
    private String status;
    private Timestamp createDate;
    private Timestamp startDate;
    private Timestamp endDate;
    
    public AccountSignature() {
    }

    public AccountSignature(AccountSignaturePK pk, String role, String status, Timestamp createDate,
            Timestamp startDate, Timestamp endDate) {
        this.pk = pk;
        this.role = role;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AccountSignaturePK getPk() {
        return pk;
    }

    public void setPk(AccountSignaturePK pk) {
        this.pk = pk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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
