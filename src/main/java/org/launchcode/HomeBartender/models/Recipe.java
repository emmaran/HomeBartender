package org.launchcode.HomeBartender.models;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@ManagedBean
@Entity
public class Recipe extends AbstractEntity {

    @NotEmpty
    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String name;

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    private ArrayList<Instruction> instructions = new ArrayList<>();

    public Recipe(String name, ArrayList<Ingredient> ingredients, ArrayList<Instruction> instructions) {
        this.name = name;
//        this.ingredients = ingredients;
//        this.instructions = instructions;
    }

    public Recipe(String name) {
        this.name = name;
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
