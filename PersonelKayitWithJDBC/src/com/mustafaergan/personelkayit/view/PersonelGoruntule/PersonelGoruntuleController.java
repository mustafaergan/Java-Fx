package com.mustafaergan.personelkayit.view.PersonelGoruntule;

import com.mustafaergan.personelkayit.view.DAO.PersonelDAO;
import com.mustafaergan.personelkayit.view.entity.PersonelEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonelGoruntuleController {

    public TableColumn tvTC;
    public TableColumn tvIsim;
    public TableColumn tvTelefon;
    public TableView table;

    ObservableList<PersonelEntity> list = FXCollections.observableArrayList();

    public PersonelGoruntuleController(){
        PersonelDAO dao = new PersonelDAO();
        list = dao.getKullaniciList();
        for (int i = 0 ; i< list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @FXML
    private void initialize(){
        tvTC.setCellValueFactory(new PropertyValueFactory<>("TC"));
        tvIsim.setCellValueFactory(new PropertyValueFactory<>("isim"));
        tvTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        table.setItems(list);
    }

}
