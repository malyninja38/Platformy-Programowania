package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.PropertyValue;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TableView<Coffee> table;
    @FXML
    TableColumn<String,String> name;
    @FXML
    TableColumn<String,String> supp;
    @FXML
    TableColumn<String,String> price;
    @FXML
    TableColumn<String,String> sales;
    @FXML
    TableColumn<String,String> total;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        supp.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        sales.setCellValueFactory(new PropertyValueFactory<>("sales"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        CoffeeDao coffees = new CoffeeDao();

        table.getItems().addAll(coffees.getAll());
    }



}
