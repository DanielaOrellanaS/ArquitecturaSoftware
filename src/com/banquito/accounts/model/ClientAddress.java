package com.banquito.accounts.model;

public class ClientAddress {
    private ClientAddressPK pk;
    private String address_line_one;
    private String address_line_two;
    private String latitude;
    private String longitude;

    public ClientAddress() {
    }
    
    public ClientAddress(ClientAddressPK pk, String address_line_one, String address_line_two, String latitude,
            String longitude) {
        this.pk = pk;
        this.address_line_one = address_line_one;
        this.address_line_two = address_line_two;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public ClientAddressPK getPk() {
        return pk;
    }
    public void setPk(ClientAddressPK pk) {
        this.pk = pk;
    }
    public String getAddress_line_one() {
        return address_line_one;
    }
    public void setAddress_line_one(String address_line_one) {
        this.address_line_one = address_line_one;
    }
    public String getAddress_line_two() {
        return address_line_two;
    }
    public void setAddress_line_two(String address_line_two) {
        this.address_line_two = address_line_two;
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
