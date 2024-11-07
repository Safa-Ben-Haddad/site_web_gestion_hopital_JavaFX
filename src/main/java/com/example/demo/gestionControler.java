package com.example.demo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gestionControler {


    public void onButton() {
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
    public void gestionPatients(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gestionPatients.fxml"));
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
