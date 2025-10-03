package com.example.Pet.Petfunctions;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PetController {
    private PetService ps;


    public PetController(PetService ps) {
        this.ps = ps;
    }


    @GetMapping("/api/home")
    public String home(){
        return "Home";
    }

    @GetMapping("/api/fetch")

    public String findAll(Model model) {
        List<Pet> l=ps.findAll();
        model.addAttribute("Petsa", l);
        return "Pet";
    }
    @GetMapping("/api/show")

    public String show(){
        return "ShelterPet";
    }


    public Pet findbypid(int pid){
        System.out.println(pid);
        Optional<Pet> p=ps.findbypid(pid);

        if(p.isPresent()){
             Pet pe=p.get();
             return pe;
        }
        else{
            return new Pet();
        }


    }
    public String findbysid(int sid,Model model){
        System.out.println(sid);
        List<Pet> p=ps.findbysid(sid);
        System.out.println("I have fetched the details");
        model.addAttribute("pets",p);
        return"PostedPet";
    }



    @GetMapping("/api/showafter")
    public String show(Model model) {

        model.addAttribute("message","inserted successfully");
        return "ShelterPet";
    }

    @PostMapping("/petinsert")
    public String insertDetails(@RequestBody MultiValueMap<String, String> p, Model model) {
        String name = p.getFirst("Pname");
        int id = Integer.parseInt(p.getFirst("Pid"));
        String desc = p.getFirst("PDesc");
        String photo = p.getFirst("PPhoto");
        int age = Integer.parseInt(p.getFirst("PAge"));
        String breed = p.getFirst("PBreed");
        String health = p.getFirst("PHealth");
        int sid = Integer.parseInt(p.getFirst("Sid"));
        Pet pe = new Pet(desc, id, photo, name, age, breed, health, sid);
        ps.save(pe);

        return "redirect:/api/showafter";
    }



}

