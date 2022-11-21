
package com.banquito.accounts.model;

import java.util.Date;

public class Holiday {

    private Date date;
    private int codeLocation;
    private String name;
    private String type;

    public Holiday() {
    }

    public Holiday(Date date, int codeLocation, String name, String type) {
        this.date = date;
        this.codeLocation = codeLocation;
        this.name = name;
        this.name = type;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCodeLocation() {
        return codeLocation;
    }

    public void setCodeLocation(int codeLocation) {
        this.codeLocation = codeLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}