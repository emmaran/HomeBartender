package org.launchcode.HomeBartender.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class UserInstruction extends AbstractEntity {

    @NotBlank
//    @Size(min = 2, max = 50, message = "Description must be between 2–50 characters.")
    private String description;

    @ManyToOne
    private UserRecipe recipe;


    public UserInstruction(String description, UserRecipe recipe) {
        this.description = description;
        this.recipe = recipe;
    }

    public UserInstruction(String description) {
        this.description = description;
    }

    public UserInstruction() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(UserRecipe userRecipe) {
        this.recipe = userRecipe;
    }

    @Override
    public String toString() {
        return description;
    }
}
