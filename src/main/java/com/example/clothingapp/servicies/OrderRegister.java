package com.example.clothingapp.servicies;

import com.example.clothingapp.clothes.Clothes;
import com.example.clothingapp.clothes.ClothesList;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.io.IOException;

public class OrderRegister {

    public static void addOrder(String name, String brand, String price)  {
        ClothesList.addClothes(new Clothes(name,brand,price));
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