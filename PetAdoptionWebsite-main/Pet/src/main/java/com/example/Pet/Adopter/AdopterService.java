package com.example.Pet.Adopter;

import org.springframework.stereotype.Service;

@Service
public class AdopterService {


    private AdopterRepository ad;

    public AdopterService(AdopterRepository ad) {
        this.ad = ad;
    }


}
