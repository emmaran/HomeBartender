package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping()
    @ResponseBody
    public String login() {
        return "LOGIN";
    }

    @GetMapping("Sign Up")
    @ResponseBody
    public String signUp() {
        return "Sign Up";
        }


    //Handles request of the form /login/LaunchCode
@GetMapping("Login")
@ResponseBody
public String loginWithPathParam(@PathVariable String name) {
        return "";

}

}