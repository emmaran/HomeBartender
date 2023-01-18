package org.launchcode.HomeBartender.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank
    @Size(min = 2, max = 50, message = "Ingredient Name must be between 2–50 characters.")
    private String name;


    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {}

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

}
