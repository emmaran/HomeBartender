package org.launchcode.HomeBartender.controllers;


import org.launchcode.HomeBartender.models.Friends;
import org.launchcode.HomeBartender.models.data.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("friends")
public class FriendsController {

    @Autowired
    private FriendsRepository friendsRepository;

    @GetMapping("view")
    public String list(Model model){
        model.addAttribute("friends", friendsRepository.findAll());
        return "friends/view";
    }

    //This is to add a Friend to user's list & will return an updated list of Friends
    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("title", "Add Friend");
        model.addAttribute(new Friends());

        return "friends/view";
    }

    @PostMapping("add")
    public String processAddFriend(@ModelAttribute @Valid Friends newFriend, Errors errors, Model model){
        if(errors.hasErrors()){
            return "friends/add";
        }

        friendsRepository.save(newFriend);
        return "friends/view";
    }

}
