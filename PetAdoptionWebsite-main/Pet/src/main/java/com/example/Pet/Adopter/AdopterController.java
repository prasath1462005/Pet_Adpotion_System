package com.example.Pet.Adopter;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdopterController {



    private AdopterService as;
    public AdopterController(AdopterService as){
        this.as=as;
    }


}
