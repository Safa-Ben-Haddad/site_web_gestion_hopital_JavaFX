package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class UsersController {
    @FXML
    private ListView users;
    private ObservableList<String> l= FXCollections.observableArrayList();
    public void initialize(){
        l.add("Ali");
        l.add("ahmed");
        l.add("safa");
        users.setItems(l);
    }
    public void add(){
        l.add("abc afg");
    }
}
