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
import java.sql.SQLException;

public class supprimerController {
    @FXML
    private TextField supprimerId;
    public void supprimer() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connection.ConnectionBD();

            String req = "delete from docteur where idDocteur=?";
            stmt = conn.prepareStatement(req);
            stmt.setString(1, supprimerId.getText());
            int nb = stmt.executeUpdate();
            if (nb == 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verification");
                alert.setHeaderText(null);
                alert.setContentText("Le docteur a ete supprime avec succées");
                alert.showAndWait();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("gestion.fxml"));
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
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verification");
                alert.setHeaderText(null);
                alert.setContentText("Le docteur n'existe pas.");
                alert.showAndWait();
            }

            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }}
