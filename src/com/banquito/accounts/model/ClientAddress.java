package com.banquito.accounts.model;

public class ClientAddress {
    private ClientAddressPK pk;
    private String addressLineOne;
    private String addressLineTwo;
    private String latitude;
    private String longitude;

    public ClientAddress() {
    }

    public ClientAddress(ClientAddressPK pk, String addressLineOne, String addressLineTwo, String latitude,
            String longitude) {
        this.pk = pk;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ClientAddressPK getPk() {
        return pk;
    }

    public void setPk(ClientAddressPK pk) {
        this.pk = pk;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}