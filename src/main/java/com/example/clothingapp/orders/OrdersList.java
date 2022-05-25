package com.example.clothingapp.orders;

import com.example.clothingapp.orders.Orders;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OrdersList {

    private static ArrayList<Orders> ordersArrayList = new ArrayList<>();

    public static void addOrder(Orders newOrder){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        ordersArrayList.add(newOrder);
    }

    public static void removeOrder(int OrderId){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        ordersArrayList.remove(OrderId);
    }
    @Override
    public String toString() {
        return ordersArrayList.toString();
    }

    public static void loadOrdersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ordersArrayList = objectMapper.readValue(Paths.get("clothesOrder.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static void saveClothesToOrder() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("clothesOrder.json"), ordersArrayList);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static String getOrders() {
        return String.valueOf(ordersArrayList);
    }
    public static ArrayList<Orders> getOrdersArrayList() {
        return ordersArrayList;
    }
}
