package com.example.clothingapp;
import com.example.clothingapp.clothes.Clothes;
import com.example.clothingapp.clothes.ClothesList;
import com.example.clothingapp.orders.Orders;
import com.example.clothingapp.orders.OrdersList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CustomerController implements Initializable {

    private ObservableList<Orders> orders;

    public CustomerController() {
    }

    @FXML
    private TableColumn<Clothes, String> brandColumn;

    @FXML
    private TableColumn<Clothes, String> priceColumn;

    @FXML
    private TableView<Clothes> tableOfClothes;

    @FXML
    private TableColumn<Clothes, String> nameColumn;

    //@FXML
    //private TextField nameUser;

    @FXML
    private Button requestButton;

    //@FXML
    //private ChoiceBox<String> buyClothes;

    @FXML
    private TextField brandCustomer;

    @FXML
    private TextField priceCustomer;

    @FXML
    private TextField nameCustomer;

    @FXML
    private TableView<Orders> tableOfOrders;

    @FXML
    private TableColumn<Clothes, String> nameOrder;


    @FXML
    private TableColumn<Clothes, String> brandOrder;


    @FXML
    private TableColumn<Clothes, String> priceOrder;

    //private String[] options = {"name1", "name2"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Clothes, String>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Clothes, String>("brand"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Clothes, String>("price"));
        try {
            ClothesList.loadClothesFromFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        ObservableList<Clothes> observableList = FXCollections.observableArrayList(ClothesList.getClothesArrayList());
        tableOfClothes.setItems(observableList);

        nameOrder.setCellValueFactory(new PropertyValueFactory<Clothes, String>("name"));
        brandOrder.setCellValueFactory(new PropertyValueFactory<Clothes, String>("brand"));
        priceOrder.setCellValueFactory(new PropertyValueFactory<Clothes, String>("price"));

        ObservableList<Orders> observableList1 = FXCollections.observableArrayList(OrdersList.getOrdersArrayList());
        tableOfOrders.setItems(observableList1);

    }


    @FXML
    void sendOrder(ActionEvent event) throws IOException {
        Orders clothes = new Orders(nameCustomer.getText(), (brandCustomer.getText()), (priceCustomer.getText()));
        ObservableList<Orders> orders = tableOfOrders.getItems();
        orders.add(clothes);
        OrdersList.addOrder(clothes);
        tableOfOrders.setItems(orders);
        OrdersList.saveClothesToOrder();

    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("initial.fxml");
    }

}
