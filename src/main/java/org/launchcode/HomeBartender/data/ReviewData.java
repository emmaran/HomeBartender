package org.launchcode.HomeBartender.data;


import org.launchcode.HomeBartender.models.Cocktails;
import org.launchcode.HomeBartender.models.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ReviewData {

    private String review;

    private String cocktailName;

    private String userName;

    private int cocktailId;

    private LocalDate date;

    public ReviewData() {
    }

    public ReviewData(String review) {
        this.review = review;
    }

    public LocalDate getCurrentDate() {
        return date;
    }

    public void setCurrentDate(LocalDate date) {
        this.date = date;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public static ArrayList<Review> findByName(int id, Iterable<Cocktails> cocktails, Iterable<Review> reviews){

        ArrayList<Review> results = new ArrayList<>();
        ArrayList<Cocktails> cocktailResults = new ArrayList<>();

        for(Cocktails drink : cocktails)
        {
            if(drink.getId()== id)
            {
                cocktailResults.add(drink);
            }
        }

        for(Review review : reviews)
        {
            for(Cocktails cocktail : cocktailResults)
            {
                if (review.getCocktailName().toLowerCase().equals(cocktail.getStrDrink()))
                {
                    results.add(review);
                }
            }
        }

        return results;
    }
}

