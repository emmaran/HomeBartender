package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.LoginData;
import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("login")
    @ResponseBody
    public String index() {
        return "form";
    }
//    need to code to display form
@GetMapping("login")
public String renderFormMethodName(Model model) {

    return "login";

}

@PostMapping
public void addLogin(@ModelAttribute LoginData loginData) {
User user = userRepository.findByUserName(loginData.getUserName());
};
//    if statement to see if user isn't equal to null, you would get user passwrod. then check to see if password is equal to logindata.getpassword.
//    if passwords match, takes to landing page, if not, error popup.
public int getUserId(String username, String pwHash){
    return 0;
}

//localStorage.getItem('UserID');



//    @PostMapping

//    for saving username and password
//    public String processLogin(@RequestParam String parameter1) {
//  model.addAttribute("
//
//        return "redirect:login";
//    }
}

