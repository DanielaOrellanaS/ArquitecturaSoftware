package com.banquito.accounts.model;

public class BranchPK {
    private String CodeBranch;
    private String CodeBankEntity;
    private int CodeLocation;

    public BranchPK() {
    }
    public BranchPK(String codeBranch, String codeBankEntity, int codeLocation) {
        CodeBranch = codeBranch;
        CodeBankEntity = codeBankEntity;
        CodeLocation = codeLocation;
    }
    public String getCodeBranch() {
        return CodeBranch;
    }
    public void setCodeBranch(String codeBranch) {
        CodeBranch = codeBranch;
    }
    public String getCodeBankEntity() {
        return CodeBankEntity;
    }
    public void setCodeBankEntity(String codeBankEntity) {
        CodeBankEntity = codeBankEntity;
    }
    public int getCodeLocation() {
        return CodeLocation;
    }
    public void setCodeLocation(int codeLocation) {
        CodeLocation = codeLocation;
    }

    
    
}
