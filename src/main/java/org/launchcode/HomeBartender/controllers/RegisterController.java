package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.UserData;
import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("register")
    @ResponseBody
    public String index() {
        return "form";
    }

    //    need to code to display form
    @GetMapping("register")
    public String renderRegister(Model model) {

        return "register";
    }
    @PostMapping("register")

    public String renderSignIn(@ModelAttribute UserData userData, Model model) {
    User user = new User();
        user.setUserName(userData.getUserName());

        return "register";
    }
}

