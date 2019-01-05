package com.example.Pop.controllers;

import com.example.Pop.models.Pet;
import com.example.Pop.models.data.PetDao;
import com.example.Pop.models.data.RescueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
@RequestMapping("/pop/pet")
public class AddAPetController {

    @Autowired
    private PetDao petDao;

    @Autowired
    private RescueDao rescueDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("pets", petDao.findAll());
        model.addAttribute("title", "Add a pet");

        return "Pet/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAPetForm(Model model) {
        model.addAttribute("title", "Add Pet");
        model.addAttribute(new Pet());
        return "Pet/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAPetForm(@ModelAttribute  @Valid Pet newPet,
                                       Errors errors, Model model) {


        System.out.println(newPet.getName());
         if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pet");
            model.addAttribute("message", "Please fill out all fields");
            model.addAttribute("newPet", newPet);
            return "Pet/add";
        }


        newPet = petDao.save(newPet);
        return "redirect:" + "/pop/pet/view";
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String displayViewPetForm(Model model) {
        model.addAttribute("pets", petDao.findAll());
        model.addAttribute("title", "Available Pet");
        return "Pet/view";
    }


    @RequestMapping(value = "viewOne/{petId}", method = RequestMethod.GET)
        public String displayViewOnePetForm(Model model, @PathVariable int petId) {
        model.addAttribute("Pet", petDao.findById(petId));
        //model.addAttribute("title", petDao.findById(petId).get(petId).getName());
        model.addAttribute("title", "I'm looking for a Home" );

        return "Pet/viewOne";

    }



}
