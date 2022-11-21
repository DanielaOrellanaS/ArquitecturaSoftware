package com.banquito.accounts.model;

public class PhonePK {

    private String phoneNumber;
    private int codeClient;

    public PhonePK() {
    }

    // complete constructor
    public PhonePK(String phoneNumber, int codeClient) {
        this.phoneNumber = phoneNumber;
        this.codeClient = codeClient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

}
