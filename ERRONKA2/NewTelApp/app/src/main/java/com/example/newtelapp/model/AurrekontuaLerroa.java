package com.example.newtelapp.model;

import java.io.Serializable;

public class AurrekontuaLerroa implements Serializable {
    private int idLine;
    private int idAurrekontua;
    private int idProduktua;
    private String izenaProduktua;
    private float prezioaProduktua;
    private float kantitatea;
    private float totala;

    public AurrekontuaLerroa(int idLine, int idAurrekontua, int idProduktua, String izenaProduktua, float prezioaProduktua, float kantitatea, float totala) {
        this.idLine = idLine;
        this.idAurrekontua = idAurrekontua;
        this.idProduktua = idProduktua;
        this.izenaProduktua = izenaProduktua;
        this.prezioaProduktua = prezioaProduktua;
        this.kantitatea = kantitatea;
        this.totala = totala;
    }

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public int getIdAurrekontua() {
        return idAurrekontua;
    }

    public void setIdAurrekontua(int idAurrekontua) {
        this.idAurrekontua = idAurrekontua;
    }

    public int getIdProduktua() {
        return idProduktua;
    }

    public void setIdProduktua(int idProduktua) {
        this.idProduktua = idProduktua;
    }

    public String getIzenaProduktua() {
        return izenaProduktua;
    }

    public void setIzenaProduktua(String izenaProduktua) {
        this.izenaProduktua = izenaProduktua;
    }

    public float getPrezioaProduktua() {
        return prezioaProduktua;
    }

    public void setPrezioaProduktua(float prezioaProduktua) {
        this.prezioaProduktua = prezioaProduktua;
    }

    public void setKantitatea(float kantitatea) {
        this.kantitatea = kantitatea;
    }

    public float getKantitatea() {
        return kantitatea;
    }

    public float getTotala() {
        return totala;
    }

    public void setTotala(float totala) {
        this.totala = totala;
    }

    @Override
    public String toString() {
        return "Produktu lerroa: " + idLine +
                "Aurrekontu id-a: " + idAurrekontua +
                "Izena: " + izenaProduktua +
                "Kantatitatea " + kantitatea;
    }
}
