package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.Repositories.CocktailRepository;
import org.launchcode.HomeBartender.Repositories.IngredientsRepository;
import org.launchcode.HomeBartender.models.Cocktails;
import org.launchcode.HomeBartender.models.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired IngredientsRepository ingredientsRepository;
    @Autowired CocktailRepository cocktailRepository;

    private String searchTerm;
    private boolean byKeyword;
    private boolean byIngredient;
    private boolean isAlcoholic;


    //use the ArrayLists from the apiService class
    private ArrayList<Cocktails> keywordSearch = new ArrayList<>();
    private ArrayList<Ingredients> ingredientSearch = new ArrayList<>();

    @GetMapping("")
    public String search(Model model){
        //renders search_homepage text search box with drop down menu to select
        // keyword, ingredient, or all mocktials
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("byKeyword", byKeyword);
        model.addAttribute("byIngredient", byIngredient);
        model.addAttribute("isAlcoholic", isAlcoholic);
        return "search/search_homepage";
    }

    @PostMapping("/results")
    public String searchResults(Model model,
                                @RequestParam String searchTerm,
                                @RequestParam boolean byKeyword,
                                @RequestParam boolean byIngredient,
                                @RequestParam boolean isAlcoholic){
        //returns the results of the if and for each statements
        Iterable<Cocktails> cocktailResults;
            if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
                cocktailResults = cocktailRepository.findAll();
            } else {

            }
        return "search/search_homepage";
    }

}


