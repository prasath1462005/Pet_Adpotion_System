package com.example.Pet.ShelterFunctions;

import com.example.Pet.Petfunctions.Pet;
import com.example.Pet.Petfunctions.PetController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ShelterController {

    private ShelterService ss;
    @Autowired
    private PetController pc;

    public ShelterController(ShelterService ss) {
        this.ss = ss;
    }

    @GetMapping("/api/login")
    public String login(Model model){

        return "login";
    }

    @GetMapping("/api/fetchOwner/{sid}/{pid}")
    public String findbyID(@PathVariable("sid") Integer id, Model model,@PathVariable("pid") Integer pid){

        Pet p= pc.findbypid(pid);
        System.out.println(p.getPName());
        Optional<Shelter> s =ss.findById(id);
        if(s.isPresent()) {
            Shelter sse=s.get();

           model.addAttribute("Shelter",sse);
           model.addAttribute("Pets",p);
        }
        return "ShelterDetails";
    }
   @GetMapping("/api/ShelterOptions")
    public String ShelterPage(Model model){
        Shelter Shel=new Shelter();

        model.addAttribute("Shel",Shel);

        return "Shelter";


   }
   @PostMapping("/Sinsert")

   public String insert(@ModelAttribute Shelter se){
       ss.insert(se);
       return "redirect:/api/login";

   }
    @PostMapping(value = "/api/fetchbyemail")
    public String fetchby(@RequestBody MultiValueMap<String,String> m,Model model){
       String email=m.getFirst("email");
       System.out.println(email);
       Optional <Shelter> s=ss.findbyemail(email);
       if(s.isPresent()){
           Shelter se=s.get();
           System.out.println(se.getSname());
           return pc.findbysid(se.getSid(),model);

       }
       else{
           return "redirect:/api/login";
       }

    }



}
