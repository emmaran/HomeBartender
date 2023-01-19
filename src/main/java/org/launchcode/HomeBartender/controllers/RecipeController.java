package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.UserIngredientRepository;
import org.launchcode.HomeBartender.data.UserInstructionRepository;
import org.launchcode.HomeBartender.data.UserRecipeRepository;
import org.launchcode.HomeBartender.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private UserRecipeRepository userRecipeRepository;


    @Autowired
    private UserIngredientRepository userIngredientRepository;

    @Autowired
    private UserInstructionRepository userInstructionRepository;


    @GetMapping("/new-recipe")
    public String createNewRecipe(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("h1", "Recipe Name");
        model.addAttribute("lead", "Woo! New recipe! Give it a name.");
        model.addAttribute("recipeForm", new CreateRecipeFormData());

        return "recipes/create/build-recipe";
    }

    @GetMapping("/add-ingredient-fragment")
    public String getAddIngredientFragment(Model model, @RequestParam("index") int index) {
        model.addAttribute("index", index);
        System.out.println(index);
        model.addAttribute("holdRecipeName", "holdRecipe");;
        model.addAttribute("holdRecipe", new CreateRecipeFormData());

        return "recipes/create/add-ingredient :: add-ingredient-form";

    }

    @GetMapping("/add-instruction-fragment")
    public String getAddInstructionFragment(Model model, @RequestParam("instructionIndex") int index) {
        model.addAttribute("instructionIndex", index);
        System.out.println(index);
        model.addAttribute("holdRecipeName2", "holdRecipe2");;
        model.addAttribute("holdRecipe2", new CreateRecipeFormData());

        return "recipes/create/add-instruction :: add-instruction-form";

    }

    @PostMapping("/new-recipe")
    public String processNewRecipe(@ModelAttribute("recipeForm") CreateRecipeFormData recipeFormData, Errors errors, Model model) {
        if (errors.hasErrors()) {
            System.out.println(errors);
            System.out.println("end errors");
            return "recipes/create/build-recipe";
        }

        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipeFormData.getName());

        ArrayList<IngredientFormData> ingredientForms = recipeFormData.getIngredientForms();
        
        for (int i=0; i < ingredientForms.size(); i++) {
            String newIngredientName = ingredientForms.get(i).getName();
            UserIngredient newIngredient = new UserIngredient();
            newIngredient.setName(newIngredientName);
            newIngredient.setRecipe(newRecipe);

            newRecipe.addIngredient(newIngredient);
        }

        ArrayList<InstructionFormData> instructionForms = recipeFormData.getInstructionForms();

        for (int j=0; j < instructionForms.size(); j++) {
            String newInstructionDescription = instructionForms.get(j).getDescription();
            UserInstruction newInstruction = new UserInstruction();
            newInstruction.setDescription(newInstructionDescription);
            newInstruction.setRecipe(newRecipe);

            newRecipe.addInstruction(newInstruction);
        }

        userRecipeRepository.save(newRecipe);
        
        for (int k=0; k < newRecipe.getIngredients().size(); k++) {
            userIngredientRepository.save(newRecipe.getIngredients().get(k));
        }

        for (int l=0; l < newRecipe.getInstructions().size(); l++) {
            userInstructionRepository.save(newRecipe.getInstructions().get(l));
        }


        return "redirect:/my_recipes";
    }

    @GetMapping("/view/{recipeId}")
    public String viewUserRecipe(Model model, @PathVariable int recipeId) {
        Recipe recipeToView = userRecipeRepository.findById(recipeId).get();
        model.addAttribute("recipe", recipeToView);

        String recipeName = recipeToView.getName();
        List<UserIngredient> ingredients = recipeToView.getIngredients();
        List<UserInstruction> instructions = recipeToView.getInstructions();

        model.addAttribute("title", recipeName);
        model.addAttribute("h1", recipeName);
        model.addAttribute("lead", "Recipe description.");
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("instructions", instructions);

        return "recipes/view/view-user-recipe";
    }
}
