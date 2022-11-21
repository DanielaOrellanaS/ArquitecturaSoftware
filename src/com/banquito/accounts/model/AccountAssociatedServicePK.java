package com.banquito.accounts.model;

public class AccountAssociatedServicePK {
    private int codeAccount;
    private String codeAssociatedService;
    private String codeProduct;

    public AccountAssociatedServicePK() {
    }

    public AccountAssociatedServicePK(int codeAccount, String codeAssociatedService, String codeProduct) {
        this.codeAccount = codeAccount;
        this.codeAssociatedService = codeAssociatedService;
        this.codeProduct = codeProduct;
    }

    public int getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getCodeAssociatedService() {
        return codeAssociatedService;
    }

    public void setCodeAssociatedService(String codeAssociatedService) {
        this.codeAssociatedService = codeAssociatedService;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

}
