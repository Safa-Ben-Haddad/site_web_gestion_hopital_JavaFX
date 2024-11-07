package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.*;

import static javafx.application.Application.launch;

public class AfficherControler  {
    @FXML
    private final ObservableList<docteur> docteurList = FXCollections.observableArrayList();
    public void afficher() throws SQLException {
        Connection conn=connection.ConnectionBD();
        String req="SELECT *FROM docteur";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(req);
        while(rs.next()) {
            int n = rs.getInt(1);
            String nom =rs.getString(2);
            String prenom = rs.getString(3);
            String spec=rs.getString(4);
            String numTel=rs.getString(5);
            String mail=rs.getString(6);
            docteurList.add(new docteur(n,nom,prenom,spec,numTel,mail));
        }
        rs.close();
        stmt.close();
    }

}
