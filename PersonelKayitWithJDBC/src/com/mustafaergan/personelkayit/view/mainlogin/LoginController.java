package com.mustafaergan.personelkayit.view.mainlogin;

import com.mustafaergan.personelkayit.view.DAO.PersonelDAO;
import com.mustafaergan.personelkayit.view.entity.KullaniciEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    public TextField tfKulAdi;

    @FXML
    public TextField tfSifre;

    public Label lblError;


    public void giris(ActionEvent actionEvent) {
        PersonelDAO dao = new PersonelDAO();
        KullaniciEntity kullaniciEntity = dao.getKullanici(tfKulAdi.getText(),tfSifre.getText());
        if(kullaniciEntity.getId() != null){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../sucess/Sucess.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Başarlı");
            stage.setScene(new Scene(root));
            stage.show();
        }else{
            lblError.setText("Şifre Yanlış");
        }

    }
}
