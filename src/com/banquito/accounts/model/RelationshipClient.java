package com.banquito.accounts.model;
import java.sql.Date;

public class RelationshipClient {
    private RelationshipClientPK pk;
    private String relationType;
    private Date startDate;
    private Date endDate;

    public RelationshipClient() {
    }

    public RelationshipClient(RelationshipClientPK pk) {
        this.pk = pk;
    }

    public RelationshipClientPK getPk() {
        return pk;
    }

    public void setPk(RelationshipClientPK pk) {
        this.pk = pk;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}