package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @RequestMapping("login")
    @ResponseBody
    public String index() {
        return "form";
    }
//    need to code to display form
@GetMapping("login")
public String renderFormMethodName(Model model) {
//model.addAttribute("login", login);
    // Method code...

    return "login";

}

@PostMapping
public void addLogin(String username, String password) {
//     send username/password from the client
};

public int getUserId(String username, String password){
    return 0;
}

//localStorage.getItem('UserID');


//1 post method called addLogin


//    @PostMapping

//    for saving username and password
//    public String processLogin(@RequestParam String parameter1) {
//  model.addAttribute("
//
//        return "redirect:login";
//    }
}

