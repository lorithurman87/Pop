package com.example.Pop.controllers;

import com.example.Pop.models.Rescue;
import com.example.Pop.models.data.RescueDao;
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
@RequestMapping("/pop/rescue")
public class RescueController {
    @Autowired

    private RescueDao rescuedao;


    @RequestMapping(value = "register")

    public String add(Model model) {
        model.addAttribute("title", "Rescue Sign up");
        Rescue rescue = new Rescue();
        model.addAttribute("Rescue", rescue);
        return "Rescue/register";
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Rescue rescue, Errors errors, String verify) {

        List<Rescue> sameName = rescuedao.findByUsername(rescue.getUsername());

        if(!errors.hasErrors() && rescue.getPassword().equals(verify) && sameName.isEmpty()) {
            model.addAttribute("Rescue", rescue);
            rescuedao.save(rescue);
            return "redirect:" + "/pop/rescue/rescueHome";

        } else {
            model.addAttribute("Rescue", rescue);
            model.addAttribute("title", "Rescue Signup");

            if(!rescue.getPassword().equals(verify)) {
                model.addAttribute("message", "Passwords must match");
                rescue.setPassword("");
            }


            if(!sameName.isEmpty()) {
                model.addAttribute("message", "Username is taken, please select another one");
            }
            return "Rescue/register";
        }
    }


    @RequestMapping(value = "signIn")
    public String signinForm(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute(new Rescue());
        return "Rescue/signIn";
    }


    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute Rescue rescue, HttpServletResponse response) {
        List<Rescue> r = rescuedao.findByUsername(rescue.getUsername());

        if(r.isEmpty()) {
            model.addAttribute("message", "Invalid Username");
            model.addAttribute("title", "Login");
            return "Rescue/signIn";
        }

        Rescue loggedIn = r.get(0);
        if(loggedIn.getPassword().equals(rescue.getPassword())) {
            Cookie c = new Cookie("Rescue", rescue.getUsername());
            c.setPath("/");
            response.addCookie(c);
            return "redirect:" + "/pop/rescue/rescueHome";
            //return "redirect:/home";
        } else {
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");
            return "Rescue/signIn";
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
        return "Rescue/register";
    }
}
