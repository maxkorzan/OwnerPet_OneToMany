package com.example.ownerpets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String index(Model model){
        //create owner
        Owner owner = new Owner();
        owner.setName("Eric");

        //create pet
        Pet pet = new Pet();
        pet.setName("Sparky");
        pet.setAnimal("Dog");

        //create empty pet-list and add pet
        Set<Pet> pets = new HashSet<>();
        pets.add(pet);

        //add pet-list to owner
        owner.setPets(pets);

        //save owner to repository
        ownerRepository.save(owner);
        petRepository.save(pet);

        //pull all owners from repo --> template
        model.addAttribute("ownersModelContainer", ownerRepository.findAll());
        return "index";

    }
}
