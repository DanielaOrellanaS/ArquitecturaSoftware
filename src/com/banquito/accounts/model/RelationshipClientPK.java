package com.banquito.accounts.model;

public class RelationshipClientPK {
    private int codeRelationship;
    private int codeClient;
    private int codeClientRelationship;

    public RelationshipClientPK() {
    }

    public RelationshipClientPK(int codeRelationship, int codeClient, int codeClientRelationship) {
        this.codeRelationship = codeRelationship;
        this.codeClient = codeClient;
        this.codeClientRelationship = codeClientRelationship;
    }
    public int getCodeRelationship() {
        return codeRelationship;
    }
    public void setCodeRelationship(int codeRelationship) {
        this.codeRelationship = codeRelationship;
    }
    public int getCodeClient() {
        return codeClient;
    }
    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }
    public int getCodeClientRelationship() {
        return codeClientRelationship;
    }
    public void setCodeClientRelationship(int codeClientRelationship) {
        this.codeClientRelationship = codeClientRelationship;
    }
}