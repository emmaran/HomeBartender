package org.launchcode.HomeBartender.controllers;


import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.Friends;
import org.launchcode.HomeBartender.models.User;
import org.launchcode.HomeBartender.models.data.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("friends")
public class FriendsController {

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping("view")
    public String list(Model model){
        model.addAttribute("friends", friendsRepository.findAll());
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
    public String processAddFriend(@ModelAttribute @Valid Friends newFriend, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("username", "Create Friend");
            return "friends/results";
        }




        friendsRepository.save(newFriend);
        return "redirect: friends/view";
    }

//    @PutMapping("/{friendId}/users/{userId}")
//    Friends assignUserAsFriend(@PathVariable int friendId, @PathVariable int userId){
//        Friends friends = friendsRepository.findById(friendId).get();
//        User user = userRepository.findById(userId).get();
//        friends.addFriend(user);
//        return friendsRepository.save(friends);
//    }

}
