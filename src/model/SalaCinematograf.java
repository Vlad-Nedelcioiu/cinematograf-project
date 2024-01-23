package model;

import java.util.Date;

public class SalaCinematograf {

    private int id;
    private String nume;
    private Date dataRezervare;
    private String film;
    private static final int capacitateMaxima = 20;

    public SalaCinematograf(int id, String nume, Date dataRezervare, String film) {
        this.id = id;
        this.nume = nume;
        this.dataRezervare = dataRezervare;
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataRezervare() {
        return dataRezervare;
    }

    public void setDataRezervare(Date dataRezervare) {
        this.dataRezervare = dataRezervare;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public static int getCapacitateMaxima() {
        return capacitateMaxima;
    }

    @Override
    public String toString() {
        return "SalaCinematograf{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", dataRezervare=" + dataRezervare +
                ", film='" + film + '\'' +
                ", capacitateMaxima=" + capacitateMaxima +
                '}';
    }
}
