package com.example.clothingapp;


import com.example.clothingapp.clothes.Clothes;
import com.example.clothingapp.clothes.ClothesList;
import com.example.clothingapp.orders.Orders;
import com.example.clothingapp.orders.OrdersList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProducerController implements Initializable {

    public ProducerController() {
    }

    @FXML
    private TableView<Clothes> tableOfClothes;

    @FXML
    private TableColumn<Clothes, String> nameColumn;

    @FXML
    private TableColumn<Clothes, String> brandColumn;

    @FXML
    private TableColumn<Clothes, String> priceColumn;

    @FXML
    private TextField priceText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField brandText;

    @FXML
    private Button removeButton;

    @FXML
    private Button submitButton;

    @FXML
    private Button finalizeRequest;

    @FXML
    private TableView<Orders> tableOfOrdersStaff;

    @FXML
    private TableColumn<Orders, String> nameColumnStaffOrder;

    @FXML
    private TableColumn<Orders, String> brandColumnStaffOrder;

    @FXML
    private TableColumn<Orders, String> priceColumnStaffOrder;

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
        try {
            OrdersList.loadOrdersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        ObservableList<Clothes> observableList = FXCollections.observableArrayList(ClothesList.getClothesArrayList());
        tableOfClothes.setItems(observableList);

        nameColumnStaffOrder.setCellValueFactory(new PropertyValueFactory<Orders, String>("name"));
        brandColumnStaffOrder.setCellValueFactory(new PropertyValueFactory<Orders, String>("brad"));
        priceColumnStaffOrder.setCellValueFactory(new PropertyValueFactory<Orders, String>("price"));

        ObservableList<Orders> observableList1 = FXCollections.observableArrayList(OrdersList.getOrdersArrayList());
        tableOfOrdersStaff.setItems(observableList1);

    }
    //Submit button
    @FXML
    void Submit(ActionEvent event) throws IOException {
        Clothes clothes = new Clothes(nameText.getText(), (brandText.getText()), (priceText.getText()));
        ObservableList<Clothes> clothes2 = tableOfClothes.getItems();
        clothes2.add(clothes);
        ClothesList.addClothes(clothes);
        tableOfClothes.setItems(clothes2);
        ClothesList.saveClothesToFile();
    }

    @FXML
    void RemoveItem(ActionEvent event) throws IOException {
        int selectedID = tableOfClothes.getSelectionModel().getSelectedIndex();
        tableOfClothes.getItems().remove(selectedID);
        ClothesList.removeClothes(selectedID);
        ClothesList.saveClothesToFile();
    }

    @FXML
    void RemoveFromOrder(ActionEvent event) throws IOException {
        int selectedID = tableOfOrdersStaff.getSelectionModel().getSelectedIndex();
        tableOfOrdersStaff.getItems().remove(selectedID);
        OrdersList.removeOrder(selectedID);
        OrdersList.saveClothesToOrder();
    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("initial.fxml");
    }

}
