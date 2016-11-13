package com.example.conor.promo;


public class Venue {

    private String name;
    private String address;
    private String openingTime;
    private String closingTime;

    public Venue (String name, String address, String openingTime, String closingTime) {
        this.name = name;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }
}
