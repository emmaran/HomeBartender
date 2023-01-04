package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @ResponseBody
    @RequestMapping("LoginOld")
//    @PostMapping("Sign Up")
//    public String signUp() {
//        return "Sign Up";
//        }
//@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value= "login")
//public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//}

    //Handles request of the form /login/LaunchCode
//@GetMapping("Login/{name}")
//public String loginWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//
//}
@GetMapping("form")
    public String helloForm(){
        return "<html>"+
                "<body>"+
                "<form action='login' method='post'>"+
                "<input type='text' name='name'>"+
                "<input type='submit' value='Login Greeting'"+
                "</form>"+
                "</body>"+
                "</html>";
}

}