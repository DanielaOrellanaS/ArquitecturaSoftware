
package com.banquito.accounts.model;

import javax.sql.rowset.serial.SerialArray;

public class Reference {

    private SerialArray codeReference;
    private int codeClient;
    private String name;
    private String phone;
    private String related;

    public Reference() {
    }

    public Reference(SerialArray codeReference, int codeClient, String name, String phone, String related) {
        this.codeReference = codeReference;
        this.codeClient = codeClient;
        this.name = name;
        this.name = phone;
        this.name = related;
    }

    public SerialArray getCodeReference() {
        return codeReference;
    }

    public void setCodeReference(SerialArray codeReference) {
        this.codeReference = codeReference;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

}
