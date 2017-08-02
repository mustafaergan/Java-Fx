package com.mustafaergan.personelkayit.view.DAO;

import com.mustafaergan.personelkayit.view.entity.KullaniciEntity;
import com.mustafaergan.personelkayit.view.entity.PersonelEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ADao {

    Connection connection;

    public ADao(){
        String URL = "jdbc:mysql://localhost:3306/personelkayit";
        try {
             this.connection = DriverManager.getConnection(URL, "root", "root");
        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }
}
