package com.mustafaergan.personelkayit.view.sucess;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SucessController {
    
    public void personelGoruntule(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../PersonelGoruntule/PersonelGoruntule.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Personel Goruntule");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void personelEkle(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../PersonelEkle/PersonelEkle.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Personel Ekle");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
