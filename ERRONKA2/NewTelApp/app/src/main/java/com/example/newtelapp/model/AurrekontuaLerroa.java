package com.example.newtelapp.model;

import java.io.Serializable;

/**
 * AurrekontuaLerroa klasea
 */
public class AurrekontuaLerroa implements Serializable {
    /**
     * Atributoak
     */
    private int idLine;
    private int idAurrekontua;
    private int idProduktua;
    private String izenaProduktua;
    private float prezioaProduktua;
    private float kantitatea;
    private float totala;

    /**
     * AurrekontuaLerroa klasearen konstruktorea
     *
     * @param idLine
     * @param idAurrekontua
     * @param idProduktua
     * @param izenaProduktua
     * @param prezioaProduktua
     * @param kantitatea
     * @param totala
     */
    public AurrekontuaLerroa(int idLine, int idAurrekontua, int idProduktua, String izenaProduktua, float prezioaProduktua, float kantitatea, float totala) {
        this.idLine = idLine;
        this.idAurrekontua = idAurrekontua;
        this.idProduktua = idProduktua;
        this.izenaProduktua = izenaProduktua;
        this.prezioaProduktua = prezioaProduktua;
        this.kantitatea = kantitatea;
        this.totala = totala;
    }

    /**
     * @return AurrekontuaLerroaren id-a
     */
    public int getIdLine() {
        return idLine;
    }

    /**
     * AurrekontuaLerroaren id-a aldatzen du
     *
     * @param idLine
     */
    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    /**
     * @return Aurrekontuaren id-a
     */
    public int getIdAurrekontua() {
        return idAurrekontua;
    }

    /**
     * Aurrekontuaren id-a aldatzen du
     *
     * @param idAurrekontua
     */
    public void setIdAurrekontua(int idAurrekontua) {
        this.idAurrekontua = idAurrekontua;
    }

    /**
     * @return Produktuaren id-a
     */
    public int getIdProduktua() {
        return idProduktua;
    }

    /**
     * Produktuaren id-a aldatzen du
     *
     * @param idProduktua
     */
    public void setIdProduktua(int idProduktua) {
        this.idProduktua = idProduktua;
    }

    /**
     * @return Produktuaren izena
     */
    public String getIzenaProduktua() {
        return izenaProduktua;
    }

    /**
     * Produktuaren izena aldatzen du
     *
     * @param izenaProduktua
     */
    public void setIzenaProduktua(String izenaProduktua) {
        this.izenaProduktua = izenaProduktua;
    }

    /**
     * @return Produktuaren prezioa
     */
    public float getPrezioaProduktua() {
        return prezioaProduktua;
    }

    /**
     * Produktuaren prezioa aldatzen du
     *
     * @param prezioaProduktua
     */
    public void setPrezioaProduktua(float prezioaProduktua) {
        this.prezioaProduktua = prezioaProduktua;
    }

    /**
     * Produktuaren kantitatea aldatzen du
     *
     * @param kantitatea
     */
    public void setKantitatea(float kantitatea) {
        this.kantitatea = kantitatea;
    }

    /**
     * @return Produktuaren kantitatea
     */
    public float getKantitatea() {
        return kantitatea;
    }

    /**
     * @return Aurrekontuaren totala
     */
    public float getTotala() {
        return totala;
    }

    /**
     * Aurrekontuaren totala aldatzen du
     *
     * @param totala
     */
    public void setTotala(float totala) {
        this.totala = totala;
    }

    /**
     * @return AurrekontuaLerroen informazioa
     */
    @Override
    public String toString() {
        return "Produktu lerroa: " + idLine +
                "Aurrekontu id-a: " + idAurrekontua +
                "Izena: " + izenaProduktua +
                "Kantatitatea " + kantitatea;
    }
}
