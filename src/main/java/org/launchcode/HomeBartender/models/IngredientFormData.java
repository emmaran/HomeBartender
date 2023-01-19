package org.launchcode.HomeBartender.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IngredientFormData extends AbstractEntity {

//    @NotBlank
//    @Size(min = 2, max = 50, message = "UserIngredient Name must be between 2–50 characters.")
    private String name;


    public IngredientFormData(String name) {
        this.name = name;
    }

    public IngredientFormData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
