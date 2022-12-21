package org.launchcode.HomeBartender.models;

import java.util.List;

public class Drinks {

    //this will set everything to null initially
    private List<Cocktails> cocktails = null;

    //this get for all the drinks
    public List<Cocktails> getCocktails() {
        return cocktails;
    }
    //set for all the drinks
    public void setDrinks(List<Cocktails> cocktails) {
        this.cocktails = cocktails;
    }
}
