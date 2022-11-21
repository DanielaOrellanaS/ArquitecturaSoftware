package com.banquito.accounts.model;


public class AccountClientePK {
    private int codeAccount;
    private int codeCuent;

    public AccountClientePK() {
    }

    public AccountClientePK(int codeAccount, int codeCuent) {
        this.codeAccount = codeAccount;
        this.codeCuent = codeCuent;
    }

    public int getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        this.codeAccount = codeAccount;
    }

    public int getCodeCuent() {
        return codeCuent;
    }

    public void setCodeCuent(int codeCuent) {
        this.codeCuent = codeCuent;
    }
    
    
    
    
}
