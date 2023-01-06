package org.launchcode.HomeBartender.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
//this allows you to ignore all values that are null
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ingredient_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipes recipes;

    private String ingredient;
    private String amount;

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
