package org.launchcode.HomeBartender.models;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Entity
public class Recipe extends AbstractEntity {

//    @NotEmpty
    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String name;

//    @Size(min=1)
    @OneToMany(mappedBy = "recipe")
    private List<UserIngredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<UserInstruction> instructions = new ArrayList<>();

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, List<UserIngredient> ingredients, List<UserInstruction> instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<UserIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<UserInstruction> getInstructions() { return instructions; }

    public void setInstructions(List<UserInstruction> instructions) {
        this.instructions = instructions;
    }


    //~~~~~~~~~     CUSTOM METHODS     ~~~~~~~~~
    public void addIngredient(UserIngredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addInstruction(UserInstruction instruction) {
        instructions.add(instruction);
    }


}
