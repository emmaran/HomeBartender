package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.models.Drinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class apiController {

    //TODO: add string array to be able to add variety of drinks to db
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

    //TODO:figure out how to get json info from api

    @GetMapping(value = "/cocktailAPI")
    public Drinks getCocktails(){
        Drinks jsonCocktail = null;
        for( int i = 0; i<apiArray.length; i++) {
            String url = apiArray[i];
            RestTemplate restTemplate = new RestTemplate();

            jsonCocktail = restTemplate.getForObject(url, Drinks.class);
        }
        return jsonCocktail;
    }
}
