package com.example.newtelapp.model;

import android.os.Parcel;

import java.io.Serializable;

/**
 *
 * Produktua klasea
 */
public class Produktua implements Serializable {

    /**
     *
     * Atributoak
     */
    private int id;
    private String izena;
    private String kategoria;
    private float prezioa;
    private float kantitatea; 

    /**
     *
     * Produktua klasearen kontruktorea
     * @param id
     * @param izena
     * @param kategoria
     * @param prezioa
     * @param kantitatea
     */
    public Produktua(int id, String izena, String kategoria, float prezioa, float kantitatea) {
        this.id = id;
        this.izena = izena;
        this.kategoria = kategoria;
        this.prezioa = prezioa;
        this.kantitatea=kantitatea;
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
    public String getKategoria() {
        return kategoria;
    }

    /**
     *
     * Aldatzen du Produktuaren kategoria
     * @param kategoria
     */
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    /**
     *
     * @return Produktuaren prezioa
     */
    public float getPrezioa() {
        return prezioa;
    }

    /**
     *
     * Aldatzen du Produktuaren prezioa
     * @param prezioa
     */
    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
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
        return izena;
    }

}

