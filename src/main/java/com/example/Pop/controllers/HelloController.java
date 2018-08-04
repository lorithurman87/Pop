package com.example.Pop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pop")
public class HelloController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        String aBitAbout = "Pop (Plenty of pets) is an awesome new website with the goal to help you find your new best friend. Pop lets you know the details both\n" +
                "    good and bad, about animals that are or will be seeking new homes to try to make better and ever lasting matches that will help both the adopter\n" +
                "    and the animal. You can search for animals and add them to your favorites and then contact the rescue to get more information about setting up a\n" +
                "    meet and greet. So what are you waiting for?.";

        model.addAttribute("title", "Welcome to Pop!!");
        model.addAttribute("aBitAbout",aBitAbout);
        return "index";
    }

    @RequestMapping(value = "user/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Welcome to Pop");
        return "User/home";
    }

    @RequestMapping(value = "rescue/Home", method = RequestMethod.GET)
    public String rescueHome(Model model) {
        model.addAttribute("title", "Welcome to Pop");
        return "rescue/rescueHome";
    }



    /*@RequestMapping(value = "add", method = RequestMethod.GET)
    public String displaySignUpForm(Model model) {

        model.addAttribute("title", "Welcome to Pop!!");
        model.addAttribute("userName", "Username: ");
        model.addAttribute("passWord", "Password: ");
        model.addAttribute("eMail", "E-mail: ");
        model.addAttribute("location", "Location: ");
        return "User/add";
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLogInForm(Model model) {

        model.addAttribute("title", "Welcome to Pop!!");
        model.addAttribute("userName", "Username: ");
        model.addAttribute("passWord", "Password: ");
        return "User/logIn";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogInForm(Model model) {

        //model.addAttribute("title", "Welcome to Pop!!");

        return "";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processSignUpForm(Model model) {

        //model.addAttribute("title", "Welcome to Pop!!");

        return "";
    }*/

}
