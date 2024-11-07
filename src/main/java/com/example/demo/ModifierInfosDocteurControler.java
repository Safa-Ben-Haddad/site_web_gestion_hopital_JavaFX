package com.example.demo;

import javafx.event.ActionEvent;
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


public class ModifierInfosDocteurControler {
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connection.ConnectionBD();

            String req = "UPDATE  docteur set Nom=? , Prenom=? , Specialite=?,NumeroTelephone=?,Email=? where idDocteur=?";
            stmt = conn.prepareStatement(req);
            stmt.setString(1, nomDoct.getText());
            stmt.setString(2, prenomDoct.getText());
            stmt.setString(3,specDoct.getText());
            stmt.setString(4, numTelDoct.getText());
            stmt.setString(5, mailDoct.getText());
            stmt.setString(6, idDoct.getText());
            int x= stmt.executeUpdate();
            if(x==1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("modification");
                alert.setHeaderText(null);
                alert.setContentText("Le docteur a été modifié avec succès.");
                alert.showAndWait();
            }
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
    }

    public void annuler() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gestiondocteur.fxml"));
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
