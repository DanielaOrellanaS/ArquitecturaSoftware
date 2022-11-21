package com.banquito.accounts.model;
import java.sql.Timestamp;

public class AccountClient{
    private AccountClientePK pk;
    private Timestamp CreateDate;

    public AccountClient() {
    }

    public AccountClient(AccountClientePK pk, Timestamp createDate) {
        this.pk = pk;
        CreateDate = createDate;
    }

    public AccountClientePK getPk() {
        return pk;
    }

    public void setPk(AccountClientePK pk) {
        this.pk = pk;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }
    
    
    
}