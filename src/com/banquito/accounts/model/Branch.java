package com.banquito.accounts.model;

public class Branch {
    private BranchPK pk;
    private String codeInternationalBranch;
    private String name;

    public Branch() {
    }

    public Branch(BranchPK pk, String codeInternationalBranch, String name) {
        this.pk = pk;
        this.codeInternationalBranch = codeInternationalBranch;
        this.name = name;
    }

    public BranchPK getPk() {
        return pk;
    }

    public void setPk(BranchPK pk) {
        this.pk = pk;
    }

    public String getCodeInternationalBranch() {
        return codeInternationalBranch;
    }

    public void setCodeInternationalBranch(String codeInternationalBranch) {
        this.codeInternationalBranch = codeInternationalBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
