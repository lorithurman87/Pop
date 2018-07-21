package com.example.Pop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/pop", method = RequestMethod.GET)
public class PopController {

    public static void main(String[] args) {
        System.out.println ("Hello and welcome to Pop");
    }
    //return "home";
}
