package org.launchcode.HomeBartender.Service;

import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONObject;
import org.launchcode.HomeBartender.Repositories.CocktailRepository;

import org.launchcode.HomeBartender.Repositories.IngredientsRepository;
import org.launchcode.HomeBartender.Repositories.RecipeRepository;
import org.launchcode.HomeBartender.models.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class apiService {
    private boolean initialized = false;

    private static final Logger log = LoggerFactory.getLogger(apiService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    //data for the api
    String [] apiArray = {
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=b",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=c",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=d",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=e",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=f",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=g",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=h",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=i",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=j",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=k",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=l",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=m",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=n",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=o",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=p",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=q",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=r",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=s",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=t",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=v",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=w",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=y",
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=z"
    };

    //post construct will run the below method right away when loading the program


//    @PostConstruct
//    @Transactional
    //@GetMapping(value = "/cocktailAPI")
    public List<Ingredients> addApiToDB() {

        List<Cocktails> cocktailList = new ArrayList<>();
        List<Recipes> recipesList = new ArrayList<>();
        List<Ingredients> ingredientsList = new ArrayList<>();
        List<JSONObject> list = new ArrayList<>();
        if (!initialized) {
//        RestTemplate restTemplate = new RestTemplate();



            //the try catch is for to ignore the error of not being able to reload the same data into the db after you have done it once
            try {
                for (int apiCount = 0; apiCount < apiArray.length; apiCount++) {
                    callDrinks response = restTemplate.getForObject(apiArray[apiCount], callDrinks.class);
                    List<Drinks> drinksList = response.getDrinks();

                    for (Drinks drink : drinksList) {
                        Cocktails cocktails = new Cocktails();
                        Recipes recipes = new Recipes();
                        cocktails.setStrDrink(drink.getStrDrink());
                        cocktailList.add(cocktails);
                        recipes.setStrAlcoholic(drink.getStrAlcoholic());
                        recipes.setStrInstructions(drink.getStrInstructions());
                        recipes.setStrDrinkThumb(drink.getStrDrinkThumb());
                        recipes.setStrTags(drink.getStrTags());
                        recipes.setCocktails(cocktails);
                        recipesList.add(recipes);

                        if (drink.getStrIngredient1() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient1());
                            obj.put("amount", drink.getStrMeasure1());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient2() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient2());
                            obj.put("amount", drink.getStrMeasure2());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient3() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient3());
                            obj.put("amount", drink.getStrMeasure3());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient4() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient4());
                            obj.put("amount", drink.getStrMeasure4());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient5() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient5());
                            obj.put("amount", drink.getStrMeasure5());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient6() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient6());
                            obj.put("amount", drink.getStrMeasure6());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient7() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient7());
                            obj.put("amount", drink.getStrMeasure7());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient8() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient8());
                            obj.put("amount", drink.getStrMeasure8());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient9() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient9());
                            obj.put("amount", drink.getStrMeasure9());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient10() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient10());
                            obj.put("amount", drink.getStrMeasure10());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient11() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient11());
                            obj.put("amount", drink.getStrMeasure11());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient12() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient12());
                            obj.put("amount", drink.getStrMeasure12());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient13() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient13());
                            obj.put("amount", drink.getStrMeasure13());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient14() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient14());
                            obj.put("amount", drink.getStrMeasure14());
                            list.add(obj);
                        }
                        if (drink.getStrIngredient15() != null) {
                            JSONObject obj = new JSONObject();
                            obj.put("ingredient", drink.getStrIngredient15());
                            obj.put("amount", drink.getStrMeasure15());
                            list.add(obj);
                        }


                        for (JSONObject ingredNAmount : list) {
                            Ingredients ingredients = new Ingredients();
                            ingredients.setIngredient(ingredNAmount.get("ingredient").toString());
                            //not all ingredients will have an amount check that it does if not continue
                            if (ingredNAmount.has("amount")) {
                                ingredients.setAmount(ingredNAmount.get("amount").toString());
                            }
                            ingredients.setRecipes(recipes);
                            ingredientsList.add(ingredients);
                        }
                        //clearing the list of ingredients and amounts to prevent same data being entered multiple times
                        list.clear();
                    }

                }
            } catch (ConstraintViolationException | DataIntegrityViolationException e) {
                log.warn("Duplicate key error while inserting entity", e);
            }
//            return ingredientsList;

            // save the cocktails to the database
            for (Cocktails cocktail : cocktailList) {
                cocktailRepository.save(cocktail);
            }

            // save the recipes to the database
            for (Recipes recipe : recipesList) {
                recipeRepository.save(recipe);
            }

            // save the ingredients to the database
            for (Ingredients ingredient : ingredientsList) {
                ingredientsRepository.save(ingredient);
            }


        }
        initialized = true;
        return ingredientsList;
    }
}