package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.Repositories.FriendsRepository;
import org.launchcode.HomeBartender.Repositories.UserRepository;
import org.launchcode.HomeBartender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
@RequestMapping("searchFriends")
public class SearchFriendsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendsRepository friendsRepository;


    private String friendName;

    private ArrayList<User> userFriends = new ArrayList<>();



    @GetMapping("")
    public String search(Model model){
        model.addAttribute("name", userRepository.findAll());
        model.addAttribute("friendName", friendName);
        return "friends/search";
    }

    @PostMapping("results")
    public String displaySearchFriendsResults(Model model, @RequestParam String friendName){
        Iterable<User> usersList;
        usersList = userRepository.findAll();

        for(User userFriend: usersList) {
            if (friendName.toLowerCase().equals(userFriend.getUserName().toLowerCase())) {
                userFriends.add(userFriend);
            }

            if (friendName.isBlank() || friendName.equals("")) {
//                errors.hasErrors();
                return "redirect:";
            }

//            else{
//                return "friends/search";
//            }


//        }


//        else{
//            user = User.findByValue(searchTerm, userRepository.findAll());
//        }
            model.addAttribute("userFriends", userFriends);

        }

        return "friends/search";

    }

}
