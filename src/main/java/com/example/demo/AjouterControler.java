package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjouterControler {
    @FXML
    private TextField idDoct;
    @FXML
    private ListView ListDocteurs;
    @FXML
    private ObservableList<String> l= FXCollections.observableArrayList();
    public void initialize() throws Exception {
        l.add("1320");
        ListDocteurs.setItems(l);
        entrerId();
    }
    public void entrerId() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connection.ConnectionBD();
            String req = "SELECT * FROM docteur WHERE idDocteur = ?";
            pstmt = conn.prepareStatement(req);
            pstmt.setString(1, idDoct.getText());

            // Execute the query
            rs = pstmt.executeQuery();


            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verification");
                alert.setHeaderText(null);
                alert.setContentText("Le docteur existe déjà.");
                alert.showAndWait();
                l.add(idDoct.getText());

            } else {

                ajout();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème de connexion");
            alert.setContentText("Erreur lors de la tentative de connexion à la base de données.");
            alert.showAndWait();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void ajout() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("entrerInfosDocteurs.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Gestion des Docteurs");
            stage.setScene(scene);
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}