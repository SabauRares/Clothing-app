package com.example.clothingapp.clothes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ClothesList {

    private static ArrayList<Clothes> clothesArrayList = new ArrayList<>();

    public static void addClothes(Clothes newItem){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        clothesArrayList.add(newItem);
    }

    public static void removeClothes(int itemId){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        clothesArrayList.remove(itemId);
    }
/*
    private static void checkBookDoesNotAlreadyExist(String username) throws BookAlreadyExistsException {
        for (Books user : users) {
            if (Objects.equals(username, book.getUsername()))
                throw new BookAlreadyExistsException(username);
        }
    }

    public static boolean checkUserCredentials(Books newBook) {
        return book.contains(book1);
    }*/


    @Override
    public String toString() {
        return clothesArrayList.toString();
    }

    public static void loadClothesFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            clothesArrayList = objectMapper.readValue(Paths.get("clothes.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static void saveClothesToFile() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("clothes.json"), clothesArrayList);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static String getClothes() {
        return String.valueOf(clothesArrayList);
    }
    public static ArrayList<Clothes> getClothesArrayList() {
        return clothesArrayList;
    }

}
