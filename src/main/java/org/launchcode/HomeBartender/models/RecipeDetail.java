package org.launchcode.HomeBartender.models;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class RecipeDetail extends AbstractEntity {

    private Recipe recipe;

    @NotEmpty
    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String name;

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    private ArrayList<Instruction> instructions = new ArrayList<>();

    public RecipeDetail(String name, ArrayList<Ingredient> ingredients, ArrayList<Instruction> instructions) {
        this.name = name;
//        this.ingredients = ingredients;
//        this.instructions = instructions;
    }

    public RecipeDetail(String name) {
        this.name = "";
    }

    public RecipeDetail() {}


    public Recipe getRecipe() {
        return recipe;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return recipe.getIngredients();
    }

    public ArrayList<Instruction> getInstructions() {
        return recipe.getInstructions();
    }

    public Recipe addInstruction(Ingredient ingredient) {
        recipe.getIngredients().add(ingredient);

        return recipe;
    }


    public void setName(String name) {
        this.name = name;
    }



}
