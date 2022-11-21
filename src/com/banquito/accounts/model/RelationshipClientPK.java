package com.banquito.accounts.model;

import javax.sql.rowset.serial.SerialArray;

public class RelationshipClientPK {
    private SerialArray codeRelationship;
    private int codeClient;
    private int codeClientRelationship;

    public RelationshipClientPK() {
    }

    public RelationshipClientPK(SerialArray codeRelationship, int codeClient, int codeClientRelationship) {
        this.codeRelationship = codeRelationship;
        this.codeClient = codeClient;
        this.codeClientRelationship = codeClientRelationship;
    }
    public SerialArray getCodeRelationship() {
        return codeRelationship;
    }
    public void setCodeRelationship(SerialArray codeRelationship) {
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
