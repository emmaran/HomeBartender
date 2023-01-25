package org.launchcode.HomeBartender.data;


import org.launchcode.HomeBartender.models.Cocktails;
import org.launchcode.HomeBartender.models.Recipes;

import java.util.ArrayList;

public class CocktailData {

    public static ArrayList<Cocktails> findByName(String name, Iterable<Cocktails> cocktails){
        String lowerCaseName = name.toLowerCase();

        ArrayList<Cocktails> results = new ArrayList<>();

        for(Cocktails drink : cocktails){
            if(drink.getStrDrink().toLowerCase().contains(lowerCaseName)){
                results.add(drink);
            }

        }
        return results;
    }

    public static ArrayList<Cocktails> findById(int id, Iterable<Cocktails> cocktails){
        ArrayList<Cocktails> results = new ArrayList<>();

        for(Cocktails drink : cocktails){
            if(drink.getId()== id){
                results.add(drink);
            }
        }

        return results;
    }

    public static ArrayList<Recipes> findByRId(int id, Iterable<Recipes> recipes){
        ArrayList<Recipes> results = new ArrayList<>();

        for(Recipes recipe : recipes){
            if(recipe.getId()== id){
                results.add(recipe);
            }
        }

        return results;
    }

}

