package org.launchcode.HomeBartender.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Ingredient {

    private int id;

    private static int nextId = 1;

    @NotBlank
    @Size(min = 2, max = 50, message = "Ingredient Name must be between 2–50 characters.")
    private String ingredientName;

    public Ingredient(String ingredientName) {
        this();
        this.ingredientName = ingredientName;
    }

    public Ingredient() {
        this.id = nextId;
        nextId++;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName() {
        this.ingredientName = ingredientName;
    }

}
