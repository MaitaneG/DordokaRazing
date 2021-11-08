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
    private String name;
    private String bezeroaIzena;
    private String state; //Select-a egitean ez du balio, baina bai insert-a egiterakoan

    private Date data;

    /**
     * Bezeroa klasearen konstruktorea
     *
     * @param id
     * @param izena
     * @param bezeroaIzena
     * @param state
     * @param data
     */
    public Aurrekontua(int id, String izena, String bezeroaIzena, String state, Date data) {
        this.id = id;
        this.name = izena;
        this.bezeroaIzena = bezeroaIzena;
        this.state = state;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Izena: " + name + '\n' +
                "Bezeroa: " + bezeroaIzena + '\n' +
                "Data: " + data;
    }
}
