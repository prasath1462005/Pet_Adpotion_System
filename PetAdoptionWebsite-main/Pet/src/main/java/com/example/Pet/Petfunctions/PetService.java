package com.example.Pet.Petfunctions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService

{

    private PetRepository pr;

    public PetService(PetRepository pr) {
        this.pr = pr;
    }

    public String save(Pet p){
        this.pr.save(p);
        return "true";
    }

    public List<Pet> findAll(){
     return pr.findAll();
    }

    public List<Pet> findbysid(int sid){
        return pr.findbysid(sid);

    }

    public Optional<Pet> findbypid(int pid){
        return pr.findbypid(pid);

    }

}
