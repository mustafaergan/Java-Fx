package com.mustafaergan.personelkayit.view.PersonelEkle;

import com.mustafaergan.personelkayit.view.DAO.PersonelDAO;
import com.mustafaergan.personelkayit.view.entity.KullaniciEntity;
import com.mustafaergan.personelkayit.view.entity.PersonelEntity;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.util.UUID;

public class PersonelEkleController {
    public TextField tfTC;
    public TextField tfIsim;
    public TextField tfSoyad;
    public TextField tfYas;
    public TextField tfTelefon;
    public TextField tfKul;
    public TextField tfSifre;

    public void kayit(ActionEvent actionEvent) {
        PersonelEntity personelEntity = new PersonelEntity();
        personelEntity.setTC(tfTC.getText());
        personelEntity.setIsim(tfIsim.getText());
        personelEntity.setTelefon(tfTelefon.getText());
        personelEntity.setYas(tfYas.getText());

        KullaniciEntity kullaniciEntity = new KullaniciEntity();
        kullaniciEntity.setPersonelTc(personelEntity.getTC());
        kullaniciEntity.setId(UUID.randomUUID().toString());
        kullaniciEntity.setKullaniciAdi(tfKul.getText());
        kullaniciEntity.setSifre(tfSifre.getText());

        PersonelDAO dao = new PersonelDAO();

        dao.savePersonel(personelEntity, kullaniciEntity);
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
