package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class docteurControler {
    @FXML

    public void initialize(){

    }
    @FXML
    private void ajouter(){
        try {
            // Charge le fichier FXML pour la gestion des docteurs
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouter.fxml"));
            Parent root = loader.load();

            // Crée une nouvelle scène avec ce layout
            Scene scene = new Scene(root);

            // Crée une nouvelle fenêtre ou réutilise la principale
            Stage stage = new Stage(); // Utilisez new Stage() si vous voulez une nouvelle fenêtre
            stage.setTitle("Gestion des Docteurs");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifier(){
        try {
            // Charge le fichier FXML pour la gestion des docteurs
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifier.fxml"));
            Parent root = loader.load();

            // Crée une nouvelle scène avec ce layout
            Scene scene = new Scene(root);

            // Crée une nouvelle fenêtre ou réutilise la principale
            Stage stage = new Stage(); // Utilisez new Stage() si vous voulez une nouvelle fenêtre
            stage.setTitle("Gestion des Docteurs");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void supprimer() {
        try {
            // Charge le fichier FXML pour la gestion des docteurs
            FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimer.fxml"));
            Parent root = loader.load();

            // Crée une nouvelle scène avec ce layout
            Scene scene = new Scene(root);

            // Crée une nouvelle fenêtre ou réutilise la principale
            Stage stage = new Stage(); // Utilisez new Stage() si vous voulez une nouvelle fenêtre
            stage.setTitle("Gestion des Docteurs");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void afficher(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher.fxml"));
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
