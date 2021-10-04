package com.example.newtelapp;

public class Produktua {
    private int id;
    private String izena;
    private String category;
    private float prezio;
    private float kantitatea;

    public Produktua(int id, String izena, String category, float prezio, float kant) {
        this.id = id;
        this.izena = izena;
        this.category = category;
        this.prezio = prezio;
        this.kantitatea=kant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrezio() {
        return prezio;
    }

    public void setPrezio(float prezio) {
        this.prezio = prezio;
    }

    public float getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    @Override
    public String toString() {
        return "Produktua{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", category='" + category + '\'' +
                ", prezio=" + prezio +
                ", kantitatea=" + kantitatea +
                '}';
    }
}

