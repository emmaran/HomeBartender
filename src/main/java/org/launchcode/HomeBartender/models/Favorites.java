package org.launchcode.HomeBartender.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Favorites {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private int cocktailId;

    public Favorites() {
    }


    public Favorites(String username, int cocktailId) {
        this.username = username;
        this.cocktailId = cocktailId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }
}
