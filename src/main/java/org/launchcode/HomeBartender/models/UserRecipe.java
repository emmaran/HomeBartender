package org.launchcode.HomeBartender.models;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Entity
public class UserRecipe extends AbstractEntity {

    @NotEmpty
    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String name;

    private String description;

    private String image;

    private String imagePath;

    @OneToMany(mappedBy = "recipe")
    private List<UserIngredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<UserInstruction> instructions = new ArrayList<>();


    public UserRecipe(String name) {
        this.name = name;
    }

    public UserRecipe(String name, String description, List<UserIngredient> ingredients, List<UserInstruction> instructions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public UserRecipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

