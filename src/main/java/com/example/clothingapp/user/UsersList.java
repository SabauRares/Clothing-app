package com.example.clothingapp.user;

import com.example.clothingapp.Main;
import com.example.clothingapp.user.Users;
import com.example.clothingapp.exceptions.UsernameAlreadyExistsException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class UsersList {

    private static ArrayList<Users> users = new ArrayList<>();

    public static void addUser(Users newUser) throws UsernameAlreadyExistsException {
        chechkUserDoesNotAlreadyExist(newUser.getUsername());
        users.add(newUser);
    }

    private static void chechkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (Users user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static boolean checkUserCredentials(Users user) {
        return users.contains(user);
    }

    @Override
    public String toString() {
        return users.toString();
    }

    public static void loadUsersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            users = objectMapper.readValue(Paths.get("users.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Users> getUsers() {
        return users;
    }

}