package org.launchcode.HomeBartender.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String review;

    @Column
    private String cocktailName;

    @Column
    private String userName;

    @Column
    private int cocktailId;


    @Column(name = "date")
    private LocalDate date;

    public int getId() {
        return id;
    }

    public LocalDate getCurrentDate() {
        return date;
    }

    public void setCurrentDate(LocalDate date) {
        this.date = date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }

}

