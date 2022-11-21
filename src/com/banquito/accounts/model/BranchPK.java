package com.banquito.accounts.model;

public class BranchPK {
    private String codeBranch;
    private String codeBankEntity;
    private int codeLocation;

    public BranchPK() {
    }

    public BranchPK(String codeBranch, String codeBankEntity, int codeLocation) {
        this.codeBranch = codeBranch;
        this.codeBankEntity = codeBankEntity;
        this.codeLocation = codeLocation;
    }

    public String getCodeBranch() {
        return codeBranch;
    }

    public void setCodeBranch(String codeBranch) {
        this.codeBranch = codeBranch;
    }

    public String getCodeBankEntity() {
        return codeBankEntity;
    }

    public void setCodeBankEntity(String codeBankEntity) {
        this.codeBankEntity = codeBankEntity;
    }

    public int getCodeLocation() {
        return codeLocation;
    }

    public void setCodeLocation(int codeLocation) {
        this.codeLocation = codeLocation;
    }

    
    
}
