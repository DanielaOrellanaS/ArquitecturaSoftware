package com.banquito.accounts.model;

public class Segment {
    private String codeSegment;
    private int codeClient;
    private String name;
    private String status;

    public Segment() {
    }

    public Segment(String codeSegment, int codeClient) {
        this.codeSegment = codeSegment;
        this.codeClient = codeClient;
    }

    public String getCodeSegment() {
        return codeSegment;
    }

    public void setCodeSegment(String codeSegment) {
        this.codeSegment = codeSegment;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
