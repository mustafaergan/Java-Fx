package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    int sayac = 0;

    public Label lblMerhaba;


    public void merhabaDe(ActionEvent actionEvent){
        System.out.println("Merhaba");
        lblMerhaba.setText("Merhaba De Btn çalıştı "+sayac);
        sayac++;
    }
}
