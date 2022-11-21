package com.banquito.accounts.model;

public class Phone {
    private PhonePK phonePK;
    private String type;

    public Phone() {
    }

    // complete constructor
    public Phone(PhonePK phonePK, String type) {
        this.phonePK = phonePK;
        this.type = type;
    }

    public PhonePK getPhonePK() {
        return phonePK;
    }

    public void setPhonePK(PhonePK phonePK) {
        this.phonePK = phonePK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    
}
