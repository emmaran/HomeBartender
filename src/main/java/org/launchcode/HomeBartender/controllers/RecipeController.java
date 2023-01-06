package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.UserIngredientRepository;
import org.launchcode.HomeBartender.data.UserRecipeRepository;
import org.launchcode.HomeBartender.models.Ingredient;
import org.launchcode.HomeBartender.models.Recipe;
import org.launchcode.HomeBartender.models.RecipeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    private UserRecipeRepository userRecipeRepository;

    @Autowired
    private UserIngredientRepository userIngredientRepository;

    private ArrayList<Ingredient> recipeIngredients;
//
//    private int newRecipeId;
//    private Optional<Recipe> recipeToBuild = userRecipeRepository.findById(newRecipeId);
//    private int recipeToBuildId = recipeToBuild.get().getId()
//

//    private RecipeDetail recipe;

    @GetMapping("new-recipe")
    public String createNewRecipe(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("h1", "Recipe Name");
        model.addAttribute("lead", "Woo! New recipe! Give it a name.");
        model.addAttribute(new Recipe());


        return "recipes/create/buildRecipe";
    }

//    @PostMapping("new-ingredient")
//    public String processNewIngredient(@ModelAttribute Ingredient newIngredient, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Oops!");
//            model.addAttribute("h1", "Oops!");
//            model.addAttribute("lead", "There was an error in creating your recipe. Go back and try again.");
//            return "redirect:";
//        }
//
//        recipeIngredients.add(newIngredient);
//
//        return "redirect:new-recipe";
//    }

    @PostMapping("new-recipe")
    public String processNewRecipe(@ModelAttribute Recipe newRecipe, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Oops!");
            model.addAttribute("h1", "Oops!");
            model.addAttribute("lead", "There was an error in creating your recipe. Go back and try again.");
            return "redirect:";
        }


        userRecipeRepository.save(newRecipe);

        return "redirect:/recipe/new-recipe";
    }


//
//    @GetMapping("build-recipe")
//    public String renderBuildRecipeForm(Model model, @RequestAttribute("newRecipeDetail") RecipeDetail recipeDetail) {
//        model.addAttribute("title", "Create Recipe");
//        model.addAttribute("h1", "Create A New Recipe");
//        model.addAttribute("lead", "That's it, home bartender! Build your Recipe by giving it catchy name, a list of ingredients, and your instructions.");
//
//        model.addAttribute("recipeName", recipeDetail.getName());
//        model.addAttribute("recipeId", recipeDetail.getId());
//
//        recipe.setName(recipeDetail.getName());
//
//        return "recipes/create/buildRecipe";
//    }
//
//    @PostMapping("/build-recipe")
//    public String processBuildRecipeForm(@ModelAttribute Recipe newRecipe, Errors errors, Model model, @RequestAttribute("newRecipeDetail") RecipeDetail recipeDetail) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Oops!");
//            model.addAttribute("h1", "Create A New Recipe");
//            model.addAttribute("lead", "Oops. There was an error in creating your recipe. Check your form and try again.");
//            return "recipes/create/buildRecipe";
//        }
//
//
//        newRecipe.setName(recipeDetail.getName());
//        userRecipeRepository.save(newRecipe);
//
//        return "redirect:/recipe";
//    }
//

}
