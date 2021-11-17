package com.example.newtelapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Aurrekontua klasea
 */
public class Aurrekontua implements Serializable {
    /**
     * Atributoak
     */
    private int id;
    private String izena;
    private int bezeroaId;
    private String bezeroaIzena;
    private String egoera;
    private float total;
    private Date data;

    /**
     * Aurrekontua klasearen konstruktorea
     *
     * @param id
     * @param izena
     * @param bezeroaId
     * @param egoera
     * @param data
     */
    public Aurrekontua(int id, String izena, int bezeroaId, String bezeroaIzena, String egoera, float total, Date data) {
        this.id = id;
        this.izena = izena;
        this.bezeroaId = bezeroaId;
        this.bezeroaIzena = bezeroaIzena;
        this.egoera = egoera;
        this.total = total;
        this.data = data;
    }

    /**
     * @return Aurrekontuaren id-a
     */
    public int getId() {
        return id;
    }

    /**
     * Aurrekontuaren id-a aldatzen du
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Aurrekontuaren izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Aurrekontuaren izena aldatzen du
     *
     * @param izena
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * @return Bezeroaren id-a
     */
    public int getBezeroaId() {
        return bezeroaId;
    }

    /**
     * Bezeroaren id-a aldatzen du
     *
     * @param bezeroaId
     */
    public void setBezeroaId(int bezeroaId) {
        this.bezeroaId = bezeroaId;
    }

    /**
     * @return Bezeroaren izena
     */
    public String getBezeroaIzena() {
        return bezeroaIzena;
    }

    /**
     * Bezeroaren izena-a aldatzen du
     *
     * @param bezeroaIzena
     */
    public void setBezeroaIzena(String bezeroaIzena) {
        this.bezeroaIzena = bezeroaIzena;
    }

    /**
     * @return Aurrekontuaren egoera
     */
    public String getEgoera() {
        return egoera;
    }

    /**
     * Aurrekontuaren egoera aldatzen du
     *
     * @param egoera
     */
    public void setEgoera(String egoera) {
        this.egoera = egoera;
    }

    /**
     * @return Aurrekontuaren totala
     */
    public float getTotal() {
        return total;
    }

    /**
     * Aurrekontuaren totala aldatzen du
     *
     * @param total
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return Aurrekontuaren data
     */
    public Date getData() {
        return data;
    }

    /**
     * Aurrekontuaren totala aldatzen du
     *
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return Aurrekontuaren informazioa
     */
    @Override
    public String toString() {
        return "Izena: " + izena + '\n' +
                "Bezeroa: " + bezeroaIzena + '\n' +
                "Data: " + data;
    }
}
