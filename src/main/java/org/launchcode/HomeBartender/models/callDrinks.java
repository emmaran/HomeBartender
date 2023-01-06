package org.launchcode.HomeBartender.models;
import java.util.List;

public class callDrinks {
    //declares private field drinks that is a list of Drink default value is null
    private List<Drinks> drinks;

    //this will return a list of drinks
    public List<Drinks> getDrinks() {
        return drinks;
    }

    //set for all the drinks
    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }
}