package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewLoginController {
    @RequestMapping(value = "Login")
    @ResponseBody
    public String index() {
        return "New login test";
    }
//    need to code to display form
@GetMapping("form")
public String renderFormMethodName(Model model) {
//model.addAttribute("login", )
    // Method code...

    return "newlogin";
}
}

