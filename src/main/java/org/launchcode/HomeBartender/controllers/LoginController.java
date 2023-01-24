package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.Repositories.UserRecipeRepository;
import org.launchcode.HomeBartender.Repositories.UserRepository;
import org.launchcode.HomeBartender.models.User;
import org.launchcode.HomeBartender.data.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.launchcode.HomeBartender.controllers.AuthenticationController.setUserInSession;

@Controller
public class LoginController {

//    I added lines 22-23 to connect it with users on 1/17
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRecipeRepository userRecipeRepository;

    @GetMapping("login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model, HttpSession session) {
        if (errors.hasErrors()) {
            errors.rejectValue("username", "user.invalid", "ERROR ONE");
            model.addAttribute("title", "Log In");
            return "login";
        }

        User theUser = userRepository.findByUserName(loginFormDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();
        System.out.println(password);
        System.out.println(theUser.getPwHash());
//if password from database doesn't equal password
        if (!theUser.getPwHash().equals(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

//        setUserInSession(request.getSession(), theUser);
        session.setAttribute("username",loginFormDTO.getUsername() );


        model.addAttribute("username", theUser.getUserName());

        model.addAttribute("recipes", userRecipeRepository.findAll());
        return "index";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

}