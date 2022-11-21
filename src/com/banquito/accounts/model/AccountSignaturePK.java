package com.banquito.accounts.model;

public class AccountSignaturePK {
    private int CodeAccount;
    private int CodeClient;

    public AccountSignaturePK() {
    }

    public AccountSignaturePK(int codeAccount, int codeClient) {
        CodeAccount = codeAccount;
        CodeClient = codeClient;
    }

    public int getCodeAccount() {
        return CodeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        CodeAccount = codeAccount;
    }

    public int getCodeClient() {
        return CodeClient;
    }

    public void setCodeClient(int codeClient) {
        CodeClient = codeClient;
    }
    
    

    
}
