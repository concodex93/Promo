package com.example.conor.promo;

/**
 * Created by conor on 04/11/2016.
 */
public class Drink {

    private String name;
    private String type;

    public Drink (String name, String type){
        this.name = name;
        this.type = type;
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
