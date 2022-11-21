package com.banquito.accounts.model;
import java.sql.Timestamp;

public class AccountClient{
    private AccountClientePK pk;
    private Timestamp createDate;

    public AccountClient() {
    }

    public AccountClient(AccountClientePK pk, Timestamp createDate) {
        this.pk = pk;
        this.createDate = createDate;
    }

    public AccountClientePK getPk() {
        return pk;
    }

    public void setPk(AccountClientePK pk) {
        this.pk = pk;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    

   
    
    
    
}