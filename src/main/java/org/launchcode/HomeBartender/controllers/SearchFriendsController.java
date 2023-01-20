package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.Friends;
import org.launchcode.HomeBartender.models.FriendsData;
import org.launchcode.HomeBartender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("friends/search")
public class SearchFriendsController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("")
    public String search(Model model){
        model.addAttribute("name", userRepository.findAll());
        return "friends/search";
    }

//    @PostMapping("results")
//    public String displaySearchFriendsResults(Model model, @RequestParam String searchTerm){
//        Iterable<User> user;
//        if(searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
//            user = userRepository.findAll();
//        }
//        else{
//            user = User.findByValue(searchTerm, userRepository.findAll());
//        }
//
//        model.addAttribute("friends", friends);
//
//        return "friends/view";
//    }
}
