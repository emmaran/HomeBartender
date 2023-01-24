package org.launchcode.HomeBartender.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class UserIngredient extends AbstractEntity {

    @NotBlank
    @Size(min = 2, max = 50, message = "Ingredient Name must be between 2–50 characters.")
    private String name;

    @ManyToOne
    private UserRecipe recipe;


    public UserIngredient(String name, UserRecipe recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public UserIngredient(String name) {
        this.name = name;
    }

    public UserIngredient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(UserRecipe userRecipe) {
        this.recipe = userRecipe;
    }

    @Override
    public String toString() {
        return name;
    }
}
