package com.banquito.accounts.model;


public class AccountClientePK {
    private int CodeAccount;
    private int CodeCuent;

    public AccountClientePK() {
    }
    
    public AccountClientePK(int codeAccount, int codeCuent) {
        CodeAccount = codeAccount;
        CodeCuent = codeCuent;
    }

    public int getCodeAccount() {
        return CodeAccount;
    }

    public void setCodeAccount(int codeAccount) {
        CodeAccount = codeAccount;
    }

    public int getCodeCuent() {
        return CodeCuent;
    }

    public void setCodeCuent(int codeCuent) {
        CodeCuent = codeCuent;
    }
    
}
