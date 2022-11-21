package com.banquito.accounts.model;

import java.sql.Date;

public class RelationshipClient {
    private RelationshipClientPK pk;
    private String relation_type;
    private Date start_date;
    private Date end_date;

    public RelationshipClient() {
    }

    public RelationshipClient(RelationshipClientPK pk) {
        this.pk = pk;
    }

    //preguntar

    public RelationshipClientPK getPk() {
        return pk;
    }

    public void setPk(RelationshipClientPK pk) {
        this.pk = pk;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}


