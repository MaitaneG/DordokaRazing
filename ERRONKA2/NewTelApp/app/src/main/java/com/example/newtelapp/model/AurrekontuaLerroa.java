package com.example.newtelapp.model;

import java.io.Serializable;

public class AurrekontuaLerroa implements Serializable {
    private int idLine;
    private int idAurrekontua;
    private String nameProduct;
    private float kantitatea;


    public AurrekontuaLerroa(int idLine, int idAurrekontua, String name, float kantitatea) {
        this.idLine = idLine;
        this.idAurrekontua = idAurrekontua;
        this.nameProduct = name;
        this.kantitatea = kantitatea;

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

    public String getName() {
        return nameProduct;
    }

    public void setName(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    @Override
    public String toString() {
        return "Produktu lerroa: " + idLine +
                "Aurrekontu id-a: " + idAurrekontua +
                "Izena: " + nameProduct +
                "Kantitatea " + kantitatea;
    }
}
