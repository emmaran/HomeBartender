package org.launchcode.HomeBartender.controllers;



import org.launchcode.HomeBartender.Repositories.FriendsRepository;
import org.launchcode.HomeBartender.Repositories.UserRepository;
import org.launchcode.HomeBartender.models.Friends;
import org.launchcode.HomeBartender.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("friends")
public class FriendsController {

    @Autowired
    FriendsRepository friendsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping("view")
    public String list(Model model, HttpServletRequest request){


        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        int id = user.getId();
        Iterable<Friends> allFriends = friendsRepository.findAll();
        ArrayList<Friends> friends = new ArrayList<>();

        for(Friends friend : allFriends ){
            if(friend.getUser().getId() == id ){
                friends.add(friend);
            }
        }

        model.addAttribute("friends", friends);
        return "friends/view";
    }

    //This is to add a Friend to user's list & will return an updated list of Friends
    @GetMapping("add")
    public String addFriend(Model model, HttpServletRequest request){
        model.addAttribute("userFriends", userRepository.findAll());
        model.addAttribute("newFriend", new Friends());
        model.addAttribute("username","Create Friend");

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("id", user.getId());

        return "friends/add";
    }

    @PostMapping("add")
    public String processAddFriend(@ModelAttribute @Valid Friends newFriend, Errors errors, Model model, HttpServletRequest request){
        if(errors.hasErrors()){
            model.addAttribute("username", "Create Friend");
            return "friends/search";
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        newFriend.setUser(user);

        friendsRepository.save(newFriend);
        return "redirect:/friends/view";
    }


}
