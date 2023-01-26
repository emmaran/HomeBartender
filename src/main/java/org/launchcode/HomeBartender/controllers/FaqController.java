package org.launchcode.HomeBartender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;



@Controller
public class FaqController {

    @PostMapping("/faq")
    public String viewFaq()
    {
        return "faq";
    }

    @RequestMapping("/faq")
    public String view()
    {
        System.out.println("Here in faq");
        return "questions";
    }
}
