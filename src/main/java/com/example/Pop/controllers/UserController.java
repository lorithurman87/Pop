/*package com.example.Pop.controllers;

import com.example.Pop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/pop/user")
public class UserController {
    @Autowired

    private UserDoa userdao;


        @RequestMapping(value = "add")

        public String add(Model model) {
            model.addAttribute("title", "User Signup");
            User User = new User();
            model.addAttribute("User", User);
            return "User/add";
        }


        @RequestMapping(value = "add", method = RequestMethod.POST)
        public String add(Model model, @ModelAttribute @Valid User User, Errors errors, String verify) {

            List<User> sameName = userdao.findByUsername(User.getUsername());

            if(!errors.hasErrors() && User.getPassword().equals(verify) && sameName.isEmpty()) {
                model.addAttribute("User", User);
                userdao.save(User);
                return "User/index";

            } else {
                model.addAttribute("User", User);
                model.addAttribute("title", "User Signup");

                if(!User.getPassword().equals(verify)) {
                    model.addAttribute("message", "Passwords must match");
                    User.setPassword("");
                }


                if(!sameName.isEmpty()) {
                    model.addAttribute("message", "Username is taken, please select another one");
                }
                return "User/add";
            }
        }


        @RequestMapping(value = "login")
        public String loginForm(Model model) {
            model.addAttribute("title", "Login");
            model.addAttribute(new User());
            return "User/login";
        }


        @RequestMapping(value = "login", method = RequestMethod.POST)
        public String add(Model model, @ModelAttribute User User, HttpServletResponse response) {
            List<User> u = userdao.findByUsername(User.getUsername());

            if(u.isEmpty()) {
                model.addAttribute("message", "Invalid Username");
                model.addAttribute("title", "Login");
                return "User/login";
            }

            User loggedIn = u.get(0);
            if(loggedIn.getPassword().equals(User.getPassword())) {
                Cookie c = new Cookie("User", User.getUsername());
                c.setPath("/");
                response.addCookie(c);
                return "redirect:/cheese";
            } else {
                model.addAttribute("message", "Invalid Password");
                model.addAttribute("title", "Login");
                return "User/login";
            }
        }



        @RequestMapping(value = "logout")
        public String logout(HttpServletRequest request, HttpServletResponse response) {
            Cookie[] cookies = request.getCookies();

            if(cookies != null) {
                for (Cookie c : cookies) {
                    c.setMaxAge(0);
                    c.setPath("/");
                    response.addCookie(c);
                }
            }
            return "User/login";
        }
    }
} */
