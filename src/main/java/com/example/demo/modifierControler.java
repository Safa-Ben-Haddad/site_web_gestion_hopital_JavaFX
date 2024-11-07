package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class modifierControler {
    @FXML
    private TextField idModif;
    public void idModif(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Establish a connection
            conn = connection.ConnectionBD();

            // Prepare a SQL statement to find the doctor by ID
            String req = "SELECT * FROM docteur WHERE idDocteur = ?";
            stmt = conn.prepareStatement(req);
            stmt.setString(1, idModif.getText()); // Set the ID from TextField

            // Execute the query
            rs = stmt.executeQuery();


            if (rs.next()) {
                modifier();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verification");
                alert.setHeaderText(null);
                alert.setContentText("Le docteur  n'existe pas.");
                alert.showAndWait();
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
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }public void modifier(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifiernfosDocteurs.fxml"));
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
