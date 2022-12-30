package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.models.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipe")
public class RecipeController {

    @GetMapping("create")
    public String renderCreateRecipeForm(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("h1", "Create A New Recipe");
        model.addAttribute("lead", "That's it, home bartender! Build your Recipe by giving it catchy name, a list of ingredients, and your instructions.");
        model.addAttribute("recipe", new Recipe());


        return "recipes/createRecipe";
    }

}
