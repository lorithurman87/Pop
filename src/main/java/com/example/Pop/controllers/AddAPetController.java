package com.example.Pop.controllers;

import com.example.Pop.models.Pet;
import com.example.Pop.models.data.PetDao;
import com.example.Pop.models.data.RescueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


@Controller
@RequestMapping("/pop/pet")
public class AddAPetController {

    @Autowired
    private PetDao petDao;

    @Autowired
    private RescueDao rescueDao;

    //Request path: /pets
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("pets", petDao.findAll());
        model.addAttribute("title", "Add a pet");
        //model.addAttribute("rescues", rescueDao.findAll());

        return "Pet/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAPetForm(Model model) {
        model.addAttribute("title", "Add Pet");
        model.addAttribute(new Pet());
        //model.addAttribute("rescue", rescueDao.findAll());
        return "Pet/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAPetForm(@ModelAttribute  @Valid Pet newPet,
                                       Errors errors, Model model) {

        //List<Pet> newPet = petDao.findById(Pet.getId());

        System.out.println(newPet.getName());
         if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pet");
            model.addAttribute("message", "Please fill out all fields");
            model.addAttribute("newPet", newPet);
            //model.addAttribute("rescues", rescueDao.findAll());
            return "Pet/add";
        }

        //newPet = petDao.findById(Pet.getId());

        //petDao.save(newPet);
        newPet = petDao.save(newPet);
        //return "redirect:";
        //return "redirect:" + "/pop/rescue/Home";
        return "redirect:" + "/pop/Pet/indexview";
    }


//    RequestMapping(value = "indexview", method = RequestMethod.GET) {
//    public String displayViewPetForm(Model model){
//            model.addAttribute("title", "Available Pets");
//            model.addAttribute("pets", petDao.findAll());
//
//            return "Pet/indexview";
//        }



    /*@RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemovePetForm(Model model) {
        model.addAttribute("pets", petDao.findAll());
        model.addAttribute("title", "Remove Pet");
        return "Pet/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemovePetForm(@RequestParam int[] petIds) {

        for (int petId : petIds) {
            petDao.delete(petId);
        }

        return "redirect:";
    }*/

}
