package com.example.newtelapp.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * Aurrekontua klasea
 */
public class Aurrekontua {
    /**
     *
     * Atributoak
     */
    private int id;
    private String name;
    private String bezeroaIzena;
    private String produktuaIzena;
    private int kantitatea;
    // private String status; Select-a egitean ez du balio, baina bai insert-a egiterakoan
    private Date data;

    public Aurrekontua(int id, String izena, String bezeroaIzena, String produktuaIzena, int kantitatea, Date data) {
        this.id = id;
        this.name=izena;
        this.bezeroaIzena = bezeroaIzena;
        this.produktuaIzena = produktuaIzena;
        this.kantitatea = kantitatea;
        this.data = data;
    }
}
