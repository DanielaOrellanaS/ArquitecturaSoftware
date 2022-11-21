package com.banquito.accounts.model;

public class BankEntity {
    private String CodeBankEntity;
    private String CodeBankInternational;
    private String name;

    public BankEntity() {
    }
    public BankEntity(String codeBankEntity, String codeBankInternational, String name) {
        CodeBankEntity = codeBankEntity;
        CodeBankInternational = codeBankInternational;
        this.name = name;
    }
    public String getCodeBankEntity() {
        return CodeBankEntity;
    }
    public void setCodeBankEntity(String codeBankEntity) {
        CodeBankEntity = codeBankEntity;
    }
    public String getCodeBankInternational() {
        return CodeBankInternational;
    }
    public void setCodeBankInternational(String codeBankInternational) {
        CodeBankInternational = codeBankInternational;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
