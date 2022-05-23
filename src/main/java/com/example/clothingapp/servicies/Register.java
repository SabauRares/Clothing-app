package com.example.clothingapp.servicies;

import com.example.clothingapp.exceptions.UsernameAlreadyExistsException;
import com.example.clothingapp.user.Users;

import java.io.File;
import java.io.IOException;

import com.example.clothingapp.user.UsersList;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Register {

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        UsersList.addUser(new Users(username, password, role));
        persistUsers();
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("users.json"), UsersList.getUsers());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
