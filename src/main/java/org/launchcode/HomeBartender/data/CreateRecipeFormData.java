package org.launchcode.HomeBartender.data;

import org.launchcode.HomeBartender.models.AbstractEntity;
import org.launchcode.HomeBartender.models.UserIngredient;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class CreateRecipeFormData extends AbstractEntity {

    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    private String description;

    private MultipartFile image;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
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

    //custom methods

//    public ArrayList<UserIngredient> getIngredientsAsArrayList(UserRecipe recipe) {
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
