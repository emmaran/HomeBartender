package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    return "newLogin";
}
//    @PostMapping("form")
//    public String processFormMethodName(@RequestParam Type parameter1, Type parameter2, ...) {
//
//        // Method code...
//
//        return "redirect:form";
//    }
}

