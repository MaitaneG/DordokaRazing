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
    private String state; //Select-a egitean ez du balio, baina bai insert-a egiterakoan
    private float total;
    private Date data;

    /**
     * Bezeroa klasearen konstruktorea
     *
     * @param id
     * @param izena
     * @param bezeroaId
     * @param state
     * @param data
     */
    public Aurrekontua(int id, String izena, int bezeroaId, String bezeroaIzena, String state, float total, Date data) {
        this.id = id;
        this.izena = izena;
        this.bezeroaId = bezeroaId;
        this.bezeroaIzena = bezeroaIzena;
        this.state = state;
        this.total = total;
        this.data = data;
    }

    /**
     * @return Aurrekontuaren id-a
     */
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

    public int getBezeroaId() {
        return bezeroaId;
    }

    public void setBezeroaId(int bezeroaId) {
        this.bezeroaId = bezeroaId;
    }

    public String getBezeroaIzena() {
        return bezeroaIzena;
    }

    public void setBezeroaIzena(String bezeroaIzena) {
        this.bezeroaIzena = bezeroaIzena;
    }

    public String getState() {
        return state;
    }

    public String getStatus() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Izena: " + izena + '\n' +
                "Bezeroa: " + bezeroaIzena + '\n' +
                "Data: " + data;
    }
}
