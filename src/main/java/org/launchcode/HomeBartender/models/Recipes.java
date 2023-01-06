package org.launchcode.HomeBartender.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
//this allows you to ignore all values that are null
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Recipes  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int id;

    private String strTags;
    private String strAlcoholic;

    @Column(length = 5000)
    private String strInstructions;
    private String strDrinkThumb;

    @OneToOne
    @JoinColumn(name = "cocktails_id")
    private Cocktails cocktails;

    @OneToOne
    private Ingredients ingredients;

    public Recipes(String strTags, String strAlcoholic, String strInstructions, String strDrinkThumb) {
        this.strTags = strTags;
        this.strAlcoholic = strAlcoholic;
        this.strInstructions = strInstructions;
        this.strDrinkThumb = strDrinkThumb;
    }

    public Recipes() {
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public Cocktails getCocktails() {
        return cocktails;
    }

    public void setCocktails(Cocktails cocktails) {
        this.cocktails = cocktails;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }
}


