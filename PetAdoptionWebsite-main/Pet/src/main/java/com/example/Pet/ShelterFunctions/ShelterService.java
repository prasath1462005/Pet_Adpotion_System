package com.example.Pet.ShelterFunctions;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShelterService {

    private ShelterRepository sr;

    public ShelterService(ShelterRepository sr) {
        this.sr = sr;
    }

    public Optional<Shelter> findById(int id){
        return sr.findByID(id);
    }

    public String insert(Shelter se){
        sr.insert(se);
        return "true";
    }
    public Optional<Shelter> findbyemail(String e){
        return sr.findbyemail(e);
    }
}
