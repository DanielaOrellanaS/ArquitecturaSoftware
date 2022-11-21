package com.banquito.accounts.model;

public class BankEntity {
    private String codeBankEntity;
    private String codeBankInternational;
    private String name;

    public BankEntity() {
    }

    public BankEntity(String codeBankEntity, String codeBankInternational, String name) {
        this.codeBankEntity = codeBankEntity;
        this.codeBankInternational = codeBankInternational;
        this.name = name;
    }

    public String getCodeBankEntity() {
        return codeBankEntity;
    }

    public void setCodeBankEntity(String codeBankEntity) {
        this.codeBankEntity = codeBankEntity;
    }

    public String getCodeBankInternational() {
        return codeBankInternational;
    }

    public void setCodeBankInternational(String codeBankInternational) {
        this.codeBankInternational = codeBankInternational;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
