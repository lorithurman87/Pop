package com.example.Pop.controllers;


//import com.example.Pop.models.Category;
//import org.launchcode.models.Cheese;
//import org.launchcode.models.data.CategoryDao;
//import org.launchcode.models.data.CheeseDao;
import com.example.Pop.models.Pet;
import com.example.Pop.models.Rescue;
import com.example.Pop.models.data.PetDao;
import com.example.Pop.models.data.RescueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Locale;


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
        //model.addAttribute("rescues", RescueDao.findAll());

        return "Pet/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAPetForm(Model model) {
        model.addAttribute("title", "Add Pet");
        model.addAttribute(new Pet());
        model.addAttribute("rescue", rescueDao.findAll());
        return "Pet/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAPetForm(@ModelAttribute  @Valid Pet newPet,
                                       Errors errors, @RequestParam int RescueId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pet");
            //model.addAttribute("rescues", RescueDao.findAll());
            return "Pet/add";
        }
        //Rescue pet = RescueDao.findOne(rescueId);
        //newPet.setRescue(pet);

        petDao.save(newPet);
        return "redirect:";
    }

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
