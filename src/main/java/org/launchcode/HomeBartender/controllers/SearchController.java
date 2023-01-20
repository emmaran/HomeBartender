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
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired IngredientsRepository ingredientsRepository;
    @Autowired CocktailRepository cocktailRepository;

    private String searchTerm;
    private String searchType;
    private boolean byKeyword;
    private boolean byIngredient;
    private boolean isAlcoholic;


    //use the ArrayLists from the apiService class
    private ArrayList<Cocktails> keywordSearch = new ArrayList<>();
    private ArrayList<Ingredients> ingredientSearch = new ArrayList<>();
    private ArrayList<Cocktails> cocktails = new ArrayList<>();

    //this will hold multiple searchTerms for more than one input text
    //private static List<String> searchTerms = new ArrayList<>();

    @GetMapping
    public String search(Model model){
        //renders search_homepage text search box with drop down menu to select
        // keyword, ingredient, or mocktials
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchType", searchType);
        model.addAttribute("byKeyword", byKeyword);
        model.addAttribute("byIngredient", byIngredient);
        model.addAttribute("isAlcoholic", isAlcoholic);
        return "/search/search_homepage";
    }

    @PostMapping("/results")
    public String searchResults(Model model,
                                @RequestParam String searchTerm,
                                //@RequestParam boolean byKeyword,
                               //@RequestParam boolean byIngredient,
                               //@RequestParam boolean isAlcoholic
                                @RequestParam String searchType) {

        //searchTerms.add(searchTerm); <-will store multiple search terms

        //returns the results of the if and for each statements
        Iterable<Cocktails> keywordResults;
        Iterable<Ingredients> ingredientResults;
        keywordResults = cocktailRepository.findAll();
        ingredientResults = ingredientsRepository.findAll();
            if (searchType.toLowerCase().equals("keyword")) {
                for (Cocktails cocktails: keywordResults) {
                    if (cocktails.getStrDrink().toLowerCase().contains(searchTerm)) {
                        keywordSearch.add(cocktails);
                    }
                }
                model.addAttribute("results", keywordSearch);
                return "/search/search_homepage";

          /*  } else if (searchType.toLowerCase().equals("ingredient")) {
                for (Ingredients ingredient: ingredientResults) {
                    if (ingredient.getIngredient().contains(searchTerm)) {
                        ingredientSearch.add(ingredient);
                    }
                    for (Ingredients ingred : ingredientSearch) {
                        Cocktails cocktails = ingred.getRecipes().getCocktails();
                        keywordSearch.add(cocktails);
                    }
                    for (Cocktails cocktail : keywordSearch) {
                        if (!cocktails.contains(cocktail)) {
                            cocktails.add(cocktail);
                        }
                    }
                }
                model.addAttribute("results", cocktails);
*/
        }
        return "/search/search_homepage";
    }

}


