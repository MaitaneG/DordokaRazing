package com.example.newtelapp;

/**
 *
 * Produktua klasea
 */
public class Produktua {

    /**
     *
     * Atributoak
     */
    private int id;
    private String izena;
    private String category;
    private float prezio;
    private float kantitatea;

    /**
     *
     * Produktua klasearen kontruktorea
     * @param id
     * @param izena
     * @param category
     * @param prezio
     * @param kant
     */
    public Produktua(int id, String izena, String category, float prezio, float kant) {
        this.id = id;
        this.izena = izena;
        this.category = category;
        this.prezio = prezio;
        this.kantitatea=kant;
    }

    /**
     *
     * @return Produktuaren id-a
     */
    public int getId() {
        return id;
    }

    /**
     *
     * Aldatzen du Produktuaren id-a
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return Produktuaren izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     *
     * Aldatzen du Produktuaren izena
     * @param izena
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     *
     * @return Produktuaren kategoria
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * Aldatzen du Produktuaren kategoria
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return Produktuaren prezioa
     */
    public float getPrezio() {
        return prezio;
    }

    /**
     *
     * Aldatzen du Produktuaren prezioa
     * @param prezio
     */
    public void setPrezio(float prezio) {
        this.prezio = prezio;
    }

    /**
     *
     * @return Produktuaren kantitatea
     */
    public float getKantitatea() {
        return kantitatea;
    }

    /**
     *
     * Aldatzen du Produktuaren kantitatea
     * @param kantitatea
     */
    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    /**
     *
     * @return Produktuaren informazioaren String-a
     */
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

