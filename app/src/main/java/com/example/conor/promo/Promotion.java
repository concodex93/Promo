package com.example.conor.promo;

/**
 * Created by conor on 24/10/2016.
 */
public class Promotion {

    //We will define proper attributes later :)
    private String promoName;
    private String description;
    private Drink drink;
    private String price;
    private Venue venue;

    public Promotion(String promoName, String desc, Drink drink, String price, Venue venue) {

        this.promoName = promoName;
        this.description = desc;
        this.price = price;
        this.drink = drink;
        this.venue = venue;
    }


    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
