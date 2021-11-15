package com.example.newtelapp.model;

import java.io.Serializable;

/**
 * Bezeroa klasea
 */
public class Bezeroa implements Serializable {
    /**
     * Atributoak
     */
    private int id;
    private String izenaAbizena;
    private boolean enpresa;
    private String mugikorra;
    private String korreoa;
    private String kalea;
    private String hiria;
    private int kodigoPostala;

    /**
     * Bezeroa klasearen konstruktorea
     *
     * @param izenaAbizena  //@param enpresa
     * @param mugikorra
     * @param korreoa
     * @param kalea
     * @param hiria
     * @param kodigoPostala
     */
    public Bezeroa(int id, String izenaAbizena, boolean enpresa, String mugikorra, String korreoa, String kalea, String hiria, int kodigoPostala) {
        this.id = id;
        this.izenaAbizena = izenaAbizena;
        this.enpresa = enpresa;
        this.mugikorra = mugikorra;
        this.korreoa = korreoa;
        this.kalea = kalea;
        this.hiria = hiria;
        this.kodigoPostala = kodigoPostala;
    }

    /**
     * @return Bezeroaren id-a
     */
    public int getId() {
        return id;
    }

    /**
     * Aldatzen du Bezeroaren id-a
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Bezeroaren izen-abizenak
     */
    public String getIzenaAbizena() {
        return izenaAbizena;
    }

    /**
     * Aldatzen du Bezeroaren izen-abizenak
     *
     * @param izenaAbizena
     */
    public void setIzenaAbizena(String izenaAbizena) {
        this.izenaAbizena = izenaAbizena;
    }

    /**
     * @return Bezeroa enpresa bat edo pertsona bat den
     */
    public boolean isEnpresa() {
        return enpresa;
    }

    /**
     * Aldatzen du Bezeroa enpresa bat edo pertsona bat den
     *
     * @param enpresa
     */
    public void setEnpresa(boolean enpresa) {
        this.enpresa = enpresa;
    }

    /**
     * @return Bezeroaren mugikor zenbakia
     */
    public String getMugikorra() {
        return mugikorra;
    }

    /**
     * Aldatzen du Bezeroaren mugikor zenbakia
     *
     * @param mugikorra
     */
    public void setMugikorra(String mugikorra) {
        this.mugikorra = mugikorra;
    }

    /**
     * @return Bezeroaren korreo elektronikoa
     */
    public String getKorreoa() {
        return korreoa;
    }

    /**
     * Aldatzen du Bezeroaren korreo elektronikoa
     *
     * @param korreoa
     */
    public void setKorreoa(String korreoa) {
        this.korreoa = korreoa;
    }

    /**
     * @return Bezeroaren kalea
     */
    public String getKalea() {
        return kalea;
    }

    /**
     * Aldatzen du Bezeroaren kalea
     *
     * @param kalea
     */
    public void setKalea(String kalea) {
        this.kalea = kalea;
    }

    /**
     * @return Bezeroaren hiria
     */
    public String getHiria() {
        return hiria;
    }

    /**
     * Aldatzen du Bezeroaren hiria
     *
     * @param hiria
     */
    public void setHiria(String hiria) {
        this.hiria = hiria;
    }

    /**
     * @return Bezeroaren kodigo postala
     */
    public int getKodigoPostala() {
        return kodigoPostala;
    }

    /**
     * Aldatzen du Bezeroaren kodigo postala
     *
     * @param kodigoPostala
     */
    public void setKodigoPostala(int kodigoPostala) {
        this.kodigoPostala = kodigoPostala;
    }

    /**
     * @return Bezeroaren informazioaren String-a
     */
    @Override
    public String toString() {
        return izenaAbizena;
    }
}