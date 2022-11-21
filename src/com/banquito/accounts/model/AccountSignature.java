package com.banquito.accounts.model;

import java.sql.Timestamp;

public class AccountSignature {
    private AccountSignaturePK pk;
    private String role;
    private String status;
    private Timestamp CreateDate;
    private Timestamp StartDate;
    private Timestamp EndDate;
    
    public AccountSignature() {
    }
    public AccountSignature(AccountSignaturePK pk, String role, String status, Timestamp createDate,
            Timestamp startDate, Timestamp endDate) {
        this.pk = pk;
        this.role = role;
        this.status = status;
        CreateDate = createDate;
        StartDate = startDate;
        EndDate = endDate;
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
        return CreateDate;
    }
    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }
    public Timestamp getStartDate() {
        return StartDate;
    }
    public void setStartDate(Timestamp startDate) {
        StartDate = startDate;
    }
    public Timestamp getEndDate() {
        return EndDate;
    }
    public void setEndDate(Timestamp endDate) {
        EndDate = endDate;
    }

    
}
