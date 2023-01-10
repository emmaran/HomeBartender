package org.launchcode.HomeBartender.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class Recipe {

    private int id;
    private static int nextId = 1;

    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String recipeName;

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    private ArrayList<Instruction> instructions = new ArrayList<>();

    public Recipe(String recipeName, ArrayList<Ingredient> ingredients, ArrayList<Instruction> instructions) {
        this();
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe() {
        this.id = nextId;
        nextId++;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
}
