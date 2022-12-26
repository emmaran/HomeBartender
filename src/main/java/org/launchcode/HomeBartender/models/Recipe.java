package org.launchcode.HomeBartender.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank(message = "Recipe Name is required.")
    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String name;

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    private ArrayList<Instruction> instructions = new ArrayList<>();

    public Recipe(String name, ArrayList<Ingredient> ingredients, ArrayList<Instruction> instructions) {
        this.name = name;
        this.ingredients = ingredients;
//        this.instructions = instructions;
    }

    public Recipe() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



    //~~~~~~~~~     CUSTOM METHODS     ~~~~~~~~~
    public void addIngredient(String ingredientName) {
        Ingredient newIngredient = new Ingredient(ingredientName);
        ingredients.add(newIngredient);
    }


}
