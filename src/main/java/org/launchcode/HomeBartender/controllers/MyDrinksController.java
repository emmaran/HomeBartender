package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.Repositories.CocktailRepository;
import org.launchcode.HomeBartender.Repositories.IngredientsRepository;
import org.launchcode.HomeBartender.Repositories.RecipeRepository;
import org.launchcode.HomeBartender.data.UserIngredientRepository;
import org.launchcode.HomeBartender.data.UserRecipeRepository;
import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.Recipe;
import org.launchcode.HomeBartender.models.User;
import org.launchcode.HomeBartender.models.dto.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.List;


@Controller
@RequestMapping("")
public class MyDrinksController {

    //Connects to database of recipes the user created
    @Autowired
    UserRecipeRepository userRecipeRepository;

    @Autowired
    CocktailRepository cocktailRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    private User user;

    private LoginFormDTO loggedUser;


    //the landing page once logged in
    @GetMapping("")
    public String index(Model model, HttpSession session){
//        String username = (String) session.getAttribute("username");
//        model.addAttribute("username", username);

        model.addAttribute("recipes", userRecipeRepository.findAll());

        return "/index";
    }

    //shows all the recipes the user created
    @RequestMapping("my_recipes")
    public String myRecipes(Model model){
        model.addAttribute("recipe", userRecipeRepository.findAll());
        return "my_recipes";
    }


    //shows all api drinks
    @RequestMapping("view_all")
    public String viewAllRecipes(Model model){
        model.addAttribute("allRecipes", recipeRepository.findAll());
        model.addAttribute("allCocktails", cocktailRepository.findAll());
        model.addAttribute("ingredients", ingredientsRepository.findAll());
        return "view_all";
    }

    //will show all the recipes the user's friends shared with them
//    @RequestMapping("friends_recipes")
//    public String friendsRecipes(){
//
//        return "friends_recipes";
//    }

    //will show all the recipes the user has favorited from api
//    @RequestMapping("my_favorites")
//    public String faveRecipes(){
//
//        return "my_favorites";
//    }



}
