package com.mustafaergan.personelkayit.view.DAO;

import com.mustafaergan.personelkayit.view.entity.KullaniciEntity;
import com.mustafaergan.personelkayit.view.entity.PersonelEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonelDAO extends  ADao {

    public KullaniciEntity getKullanici(String kul, String sifre){
        KullaniciEntity kullaniciEntity = new KullaniciEntity();
        PersonelEntity personelEntity = new PersonelEntity();
        String SQL = "SELECT * FROM kullanici k where k.kullanici_adi = '%s' and k.sifre = '%s'";

        SQL = String.format(SQL,kul,sifre);

        try {
            Statement statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            if(rs.next()){
                kullaniciEntity.setId(rs.getString("id"));
                kullaniciEntity.setKullaniciAdi(rs.getString("kullanici_adi"));
                kullaniciEntity.setSifre(rs.getString("sifre"));
                kullaniciEntity.setPersonelTc(rs.getString("personel_tc"));
            }
            if(kullaniciEntity.getPersonelTc() != null){
                SQL = "SELECT * FROM personel k where k.tc = '%s'";
                SQL = String.format(SQL,kullaniciEntity.getPersonelTc());
                rs = statement.executeQuery(SQL);
                if(rs.next()){
                    personelEntity.setTC(rs.getString("tc"));
                    personelEntity.setIsim(rs.getString("isim"));
                    personelEntity.setTelefon(rs.getString("telefon"));
                    personelEntity.setYas(rs.getString("yas"));
                    kullaniciEntity.setPersonelEntity(personelEntity);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kullaniciEntity;
    }


    public ObservableList<PersonelEntity> getKullaniciList(){
        ObservableList<PersonelEntity> list = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM PERSONEL";
        try {
            Statement statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            PersonelEntity personelEntity;
            while(rs.next()){
                personelEntity = new PersonelEntity();
                personelEntity.setTC(rs.getString("tc"));
                personelEntity.setIsim(rs.getString("isim"));
                personelEntity.setTelefon(rs.getString("telefon"));
                personelEntity.setYas(rs.getString("yas"));
                list.add(personelEntity);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    public void savePersonel(PersonelEntity personelEntity, KullaniciEntity kullaniciEntity){
        String SQLPersonel = "INSERT INTO PERSONEL (TC,ISIM) VALUES ('%s','%s')";
        SQLPersonel = String.format(SQLPersonel, personelEntity.getTC(),personelEntity.getIsim());

        String SQLKUL = "INSERT INTO KULLANICI (id,kullanici_adi,sifre,personel_tc) values ('%s','%s','%s','%s')";

        SQLKUL = String.format(SQLKUL,kullaniciEntity.getId(),kullaniciEntity.getKullaniciAdi(),
                kullaniciEntity.getSifre(),kullaniciEntity.getPersonelTc());
        try {
            Statement statement = super.connection.createStatement();
            statement.execute(SQLPersonel);
            statement.execute(SQLKUL);
        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }

}
