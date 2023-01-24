package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.LoginData;
import org.launchcode.HomeBartender.data.UserRecipeRepository;
import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.User;
import org.launchcode.HomeBartender.models.dto.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
                                   Model model) {
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

        setUserInSession(request.getSession(), theUser);


        model.addAttribute("username", theUser.getUserName());

        model.addAttribute("recipes", userRecipeRepository.findAll());
        return "index";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

//    this is what I had before chapter 19.
}
//    @Autowired
//    UserRepository userRepository;
//    @RequestMapping("login")
//    @ResponseBody
//    public String index() {
//        return "form";
//    }
////    need to code to display form
//@GetMapping("login")
//public String renderFormMethodName(Model model) {
//
//    return "login";
//
//}
//
//@PostMapping
//public void addLogin(@ModelAttribute LoginData loginData) {
//User user = userRepository.findByUserName(loginData.getUserName());
//};

////Aaron suggested using this.
////localStorage.getItem('UserID');
//
//}

