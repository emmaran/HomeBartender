package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class MyDrinksController {

    @GetMapping("")
    public String index(){
        //return "This will be the landing page where you can go to the different categories of recipes";
        return "/index";
    }

    @RequestMapping("my_recipes")
    //@ResponseBody
    public String myRecipes(){

        //return "This is where the list of 'My Concoctions' will be displayed";
        return "my_recipes";
    }

    @RequestMapping("friends_recipes")
    //@ResponseBody
    public String friendsRecipes(){
        //return "This will be where you can see the recipes that your friends have shared with you";
        return "friends_recipes";
    }

    @RequestMapping("my_favorites")
    //@ResponseBody
    public String faveRecipes(){

        //return "This will be where the list of favorited drink recipes will appear";
        return "my_favorites";
    }
}
