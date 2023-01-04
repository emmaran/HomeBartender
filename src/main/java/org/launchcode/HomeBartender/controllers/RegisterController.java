package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @RequestMapping("register")
    @ResponseBody
    public String index() {
        return "form";
    }

    //    need to code to display form
    @GetMapping("register")
    public String renderRegister(Model model) {
//model.addAttribute("login", login);
        // Method code...

        return "register";
    }
}