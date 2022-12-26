package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.UserIngredientRepository;
import org.launchcode.HomeBartender.data.UserRecipeRepository;
import org.launchcode.HomeBartender.models.Recipe;
import org.launchcode.HomeBartender.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    private UserRecipeRepository userRecipeRepository;

    @Autowired
    private UserIngredientRepository userIngredientRepository;

    @GetMapping("newRecipe")
    public String createNewRecipe(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("h1", "Recipe Name");
        model.addAttribute("lead", "That's it, home bartender! Build your Recipe by giving it catchy name, a list of ingredients, and your instructions.");
        model.addAttribute(new Recipe());
        model.addAttribute(new Ingredient());

        return "recipes/create/newRecipe";
    }
    @GetMapping("create")
    public String renderCreateRecipeForm(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("h1", "Create A New Recipe");
        model.addAttribute("lead", "That's it, home bartender! Build your Recipe by giving it catchy name, a list of ingredients, and your instructions.");
        model.addAttribute(new Recipe());
        model.addAttribute(new Ingredient());

        return "recipes/createRecipe";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Oops!");
            model.addAttribute("h1", "Create A New Recipe");
            model.addAttribute("lead", "Oops. There was an error in creating your recipe. Check your form and try again.");
            return "events/createRecipe";
        }



        userRecipeRepository.save(newRecipe);
        return "redirect:";
    }


}
