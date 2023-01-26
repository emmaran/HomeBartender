package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.Repositories.*;
import org.launchcode.HomeBartender.data.CocktailData;
import org.launchcode.HomeBartender.data.ReviewData;
import org.launchcode.HomeBartender.models.Cocktails;
import org.launchcode.HomeBartender.models.Favorites;
import org.launchcode.HomeBartender.models.Recipes;
import org.launchcode.HomeBartender.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class ViewRecipeController {

    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private IngredientsRepository ingredientsRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;


    @RequestMapping("/viewRecipes/{id}")
    public String viewRecipeById(@PathVariable int id, Model model, HttpSession session)
    {
        String username = (String) session.getAttribute("username");

        model.addAttribute("username", username);
        Iterable<Cocktails> cocktails;
        Iterable<Recipes> recipes;
        Iterable<Favorites> favorites = new ArrayList<>();

        favorites = favoriteRepository.findAll();

        cocktails = CocktailData.findById(id,cocktailRepository.findAll());
        recipes = CocktailData.findByRId(id,recipeRepository.findAll());
        model.addAttribute("reviewData", new ReviewData());
        model.addAttribute("cocktails" , cocktails);
        model.addAttribute("recipes" , recipes);
        model.addAttribute("ingredients",ingredientsRepository.findAll());
        model.addAttribute("reviews" , reviewRepository.findAll());

        for(Favorites favs : favorites)
        {
            if(favs.getUsername().equals(username))
            {
                if(favs.getCocktailId() == id)
                {
                    System.out.println("saved");
                    model.addAttribute("favorite" , "true");

                }
            }
        }

        return "viewRecipes";
    }

    @RequestMapping("/review")
    public String review(Model model, HttpSession session)
    {
        String username = (String) session.getAttribute("username");

        model.addAttribute("username", username);
        Iterable<Review> reviews;

        model.addAttribute("reviews" , reviewRepository.findAll());
        return "viewRecipes";
    }

    @PostMapping("/review/{id}")
    public String enterReview(@PathVariable int id, @Valid @ModelAttribute("reviewData") ReviewData reviewData, BindingResult bindingResult, Model model, HttpSession session) {
        LocalDate currentDate =  LocalDate.now();
        String username = (String) session.getAttribute("username");
        Review review = new Review();
        System.out.println("CocktailName from the form " + reviewData.getCocktailName());
        System.out.println("username  from the form " + username);
        review.setCocktailName(reviewData.getCocktailName());
        review.setUserName(username);
        review.setCocktailId(reviewData.getCocktailId());
        review.setReview(reviewData.getReview());
        review.setCurrentDate(currentDate);
        reviewRepository.save(review);

        model.addAttribute("user", username);
        model.addAttribute("reviewData", new ReviewData());


        return "redirect:/viewRecipes/"+id;
    }

    @RequestMapping("/deleteReview/{id}/{cocktailId}")
    public String deleteReview(@PathVariable int id,@PathVariable int cocktailId,  Model model, HttpSession session) {

        System.out.println("Are you getting here");


        reviewRepository.deleteById(id);
        String username = (String) session.getAttribute("username");

        model.addAttribute("user", username);
        model.addAttribute("reviewData", new ReviewData());

        return "redirect:/viewRecipes/"+cocktailId;
    }

    @RequestMapping("/favorite/{id}")
    public String favoriteRecipe(@PathVariable int id, Model model, HttpSession session)
    {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);

        Favorites myFavs = new Favorites();
        Iterable<Favorites> favorites = new ArrayList<>();
        favorites = favoriteRepository.findAll();


        for(Favorites favs : favorites)
        {
            if(favs.getUsername().equals(username))
            {
                if(favs.getCocktailId() == id)
                {
                    model.addAttribute("favorite" , "false");
                    System.out.println("deleting");
                    favoriteRepository.deleteById(favs.getId());
                }
            }
        }

        model.addAttribute("favorite" , "true");

        myFavs.setUsername(username);
        myFavs.setCocktailId(id);

        favoriteRepository.save(myFavs);

        return "redirect:/viewRecipes/"+id;
    }

}
