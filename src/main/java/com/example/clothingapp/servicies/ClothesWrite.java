package com.example.clothingapp.servicies;

import com.example.clothingapp.clothes.Clothes;

import java.io.File;
import java.io.IOException;

import com.example.clothingapp.clothes.ClothesList;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ClothesWrite {

    public static void addClothes(String name, String brand, String price) {
        //throws UsernameAlreadyExistsException
        ClothesList.addClothes(new Clothes(name, brand, price));
        persistClothes();
    }

    private static void persistClothes() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("users.json"), ClothesList.getClothes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}