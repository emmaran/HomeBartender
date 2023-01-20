package org.launchcode.HomeBartender.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InstructionFormData extends AbstractEntity {

    //    @NotBlank
//    @Size(min = 2, max = 50, message = "UserIngredient Name must be between 2–50 characters.")
    private String description;


    public InstructionFormData(String description) {
        this.description = description;
    }

    public InstructionFormData() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
