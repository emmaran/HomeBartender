package org.launchcode.HomeBartender.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class CreateRecipeFormData extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 50, message = "Recipe Name must be between 3 and 50 characters.")
    private String name;

//    @NotNull
//    @Size(min=1)
//    @Valid
    private ArrayList<IngredientFormData> ingredientForms;

    private ArrayList<InstructionFormData> instructionForms;

    private ArrayList<UserIngredient> ingredients;

    private ArrayList<String> instructions;


    public CreateRecipeFormData() {
        this.ingredientForms = new ArrayList<>() {
            {
                new IngredientFormData();
            }
        };
        this.instructionForms = new ArrayList<>() {
            {
                new InstructionFormData();
            }
        };
    }


    //getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IngredientFormData> getIngredientForms() {
        return ingredientForms;
    }

    public void setIngredientForms(ArrayList<IngredientFormData> ingredientForms) {
        this.ingredientForms = ingredientForms;
    }

    public ArrayList<InstructionFormData> getInstructionForms() {
        return instructionForms;
    }

    public void setInstructionForms(ArrayList<InstructionFormData> instructionForms) {
        this.instructionForms = instructionForms;
    }

    public ArrayList<UserIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<UserIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }
//
//    public ArrayList<UserIngredient> getIngredientsAsArrayList(Recipe recipe) {
//
//        for (int i=0; i < ingredientForms.size(); i++) {
//            String newIngredientName = ingredientForms.get(i).getName();
//            UserIngredient newIngredient = new UserIngredient();
//            newIngredient.setName(newIngredientName);
//            newIngredient.setRecipe(recipe);
//
//            ingredients.add(newIngredient);
//        }
//
//        System.out.println("~~" + ingredients);
//
//        return ingredients;
//    }
//
//    public void addIngredientFormData(IngredientFormData ingredientFormData) {
//        ingredientForms.add(ingredientFormData);
//    }

}
