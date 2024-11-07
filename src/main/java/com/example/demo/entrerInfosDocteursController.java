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

public class entrerInfosDocteursController {
    @FXML
    private TextField idDoct;
    @FXML
    private TextField nomDoct;
    @FXML
    private TextField prenomDoct;
    @FXML
    private TextField specDoct;
    @FXML
    private TextField numTelDoct;
    @FXML
    private TextField mailDoct;
    public void confirmer(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Establish a connection
            conn = connection.ConnectionBD();

            // Prepare a SQL statement to find the doctor by ID
            String req = "INSERT INTO  docteur (Nom,Prenom,Specialite,NumeroTelephone,Email) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(req);
            stmt.setString(1, nomDoct.getText());
            stmt.setString(2, prenomDoct.getText());
            stmt.setString(3,specDoct.getText());
            stmt.setString(4, numTelDoct.getText());
            stmt.setString(5, mailDoct.getText());

            stmt.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout");
            alert.setHeaderText(null);
            alert.setContentText("Le docteur a été ajouté avec succès.");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }public void annuler(){
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
