package com.banquito.accounts.model;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class Transaction {

    private int codeTransaction;
    private int codeAccount;
    private String codeUniqueTransaction;
    private String type;
    private String reference;
    private BigDecimal value;
    private Timestamp createDate;
    private Timestamp executeDate;
    private String status;

    public Transaction() {
    }

    public Transaction(int codeTransaction, int codeAccount) {
        this.codeTransaction = codeTransaction;
        this.codeAccount = codeAccount;
    }

    public int getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(int codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public int getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getCodeUniqueTransaction() {
        return codeUniqueTransaction;
    }

    public void setCodeUniqueTransaction(String codeUniqueTransaction) {
        this.codeUniqueTransaction = codeUniqueTransaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Timestamp executeDate) {
        this.executeDate = executeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
