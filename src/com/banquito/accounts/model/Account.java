package com.banquito.accounts.model;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class Account {

    private int codeAccount;
    private String codeProduct;
    private String codeBranch;
    private String internalAccount;
    private String internationalAccount;
    private String status;
    private Timestamp createDate;
    private Timestamp lastUpdateDate;
    private Timestamp cancelDate;
    private BigDecimal presentBalance;
    private BigDecimal availableBalance;

    public Account() {
    }

    public Account(int codeAccount, String codeProduct, String codeBranch) {
        this.codeAccount = codeAccount;
        this.codeProduct = codeProduct;
        this.codeBranch = codeBranch;
    }

    public int getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getCodeBranch() {
        return codeBranch;
    }

    public void setCodeBranch(String codeBranch) {
        this.codeBranch = codeBranch;
    }

    public String getInternalAccount() {
        return internalAccount;
    }

    public void setInternalAccount(String internalAccount) {
        this.internalAccount = internalAccount;
    }

    public String getInternationalAccount() {
        return internationalAccount;
    }

    public void setInternationalAccount(String internationalAccount) {
        this.internationalAccount = internationalAccount;
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

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Timestamp getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Timestamp cancelDate) {
        this.cancelDate = cancelDate;
    }

    public BigDecimal getPresentBalance() {
        return presentBalance;
    }

    public void setPresentBalance(BigDecimal presentBalance) {
        this.presentBalance = presentBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

}
