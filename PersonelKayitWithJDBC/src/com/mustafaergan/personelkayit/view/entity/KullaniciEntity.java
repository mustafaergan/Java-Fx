package com.mustafaergan.personelkayit.view.entity;

public class KullaniciEntity {
    String id;

    String kullaniciAdi;

    String sifre;

    String personelTc;

    PersonelEntity personelEntity;

    public void setId(String id) {
        this.id = id;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setPersonelEntity(PersonelEntity personelEntity) {
        this.personelEntity = personelEntity;
    }

    public void setPersonelTc(String personelTc) {
        this.personelTc = personelTc;
    }

    public PersonelEntity getPersonelEntity() {
        return personelEntity;
    }

    public String getId() {
        return id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getPersonelTc() {
        return personelTc;
    }

    public String getSifre() {
        return sifre;
    }
}
