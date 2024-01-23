package dao;

import model.SalaCinematograf;
import view.SalaCinematografOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaCinematografDao {
    private Connection connection;

    private PreparedStatement rezervare;
    private PreparedStatement afisareRezervari;
    private PreparedStatement verificareCapacitate;
    private PreparedStatement stergeRezervare;

    public SalaCinematografDao(Connection connection){
        this.connection = connection;

        try {
            rezervare = connection.prepareStatement("INSERT INTO rezervari VALUES(null, ?, ?, ?, ?)");
            afisareRezervari = connection.prepareStatement("SELECT * FROM rezervari WHERE nume = ?");
            verificareCapacitate = connection.prepareStatement("SELECT * FROM rezervari WHERE numarSala = ?");
            stergeRezervare = connection.prepareStatement("DELETE FROM rezervari WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRezervare(String nume, Date dataRezervare, String film, int numarSala){
        try {
            rezervare.setString(1, nume);
            rezervare.setDate(2, dataRezervare);
            rezervare.setString(3,film);
            rezervare.setInt(4,numarSala);

            rezervare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> afisareRezervari(String nume){
        List<String> rezervariPersoana = new ArrayList<>();
        try {
            afisareRezervari.setString(1,nume);
            ResultSet resultSet = afisareRezervari.executeQuery();
            while(resultSet.next()){
                rezervariPersoana.add(resultSet.getString("film"));
                rezervariPersoana.add(String.valueOf(resultSet.getDate("dataRezervare")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rezervariPersoana);
        return rezervariPersoana;
    }

    public int verificareCapacitate(int numarSala){
        try {
            verificareCapacitate.setInt(1,numarSala);
            ResultSet resultSet = verificareCapacitate.executeQuery();
            int locuriLibere = SalaCinematograf.getCapacitateMaxima();
            while(resultSet.next()){
                if(resultSet.getInt("numarSala") == numarSala){
                    locuriLibere--;
                }
            }
            return locuriLibere;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void stergeRezervare(int id){
        try {
            stergeRezervare.setInt(1,id);
            stergeRezervare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
