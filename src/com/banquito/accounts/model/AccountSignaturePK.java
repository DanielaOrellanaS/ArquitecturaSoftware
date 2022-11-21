package com.banquito.accounts.model;

public class AccountSignaturePK {
    private int codeAccount;
    private int codeClient;

    public AccountSignaturePK() {
    }

    public AccountSignaturePK(int codeAccount, int codeClient) {
        this.codeAccount = codeAccount;
        this.codeClient = codeClient;
    }

    public int getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        this.codeAccount = codeAccount;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }
    

    

    
}
