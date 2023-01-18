//package org.launchcode.HomeBartender.controllers;
//
//import org.launchcode.HomeBartender.data.UserData;
//import org.launchcode.HomeBartender.data.UserRepository;
//import org.launchcode.HomeBartender.models.User;
//import org.launchcode.HomeBartender.models.dto.RegisterFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import static org.launchcode.HomeBartender.controllers.AuthenticationController.setUserInSession;
//
//@Controller
//@RequestMapping
//public class RegisterController {
//
//    @Autowired
//    private UserRepository userRepository;
//
////    public String register() {
////        return "form";
////    }
//
//    @GetMapping("/register")
//    public String renderRegister(Model model) {
//        model.addAttribute(new RegisterFormDTO());
//        return "register";
//    }
////    @PostMapping("register")
////
////    public String renderSignIn(@ModelAttribute UserData userData, Model model) {
////    User user = new User ();
////        user.setUserName(userData.getUserName());
////        user.setEmail(userData.getEmail());
////        user.setPwHash(userData.getPsw());
////        userRepository.save(user);
////        return "register";
////    }
//    @PostMapping("/register")
//    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
//                                          Errors errors, HttpServletRequest request,
//                                          Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Register");
//            return "register";
//        }
//
//        User existingUser = userRepository.findByUserName(registerFormDTO.getUsername());
//
//        if (existingUser != null) {
//            errors.rejectValue("username", "username.already-exists", "A user with that username already exists");
//            model.addAttribute("title", "Register");
//            return "register";
//        }
//
//        String password = registerFormDTO.getPassword();
//        String verifyPassword = registerFormDTO.getVerifyPassword();
//        if (!password.equals(verifyPassword)) {
//            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
//            model.addAttribute("title", "Register");
//            return "register";
//        }
//
//        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
//        userRepository.save(newUser);
//        setUserInSession(request.getSession(), newUser);
//
//        return "redirect:";
//    }
//}

