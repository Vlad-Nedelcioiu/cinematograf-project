package controller;

import dao.SalaCinematografDao;
import model.SalaCinematograf;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class SalaCinematografController {

    private SalaCinematografDao salaCinematografDao;

    public SalaCinematografController() {
        salaCinematografDao = new SalaCinematografDao(ConnectionController.getInstance().getConnection());
    }

    public void addRezervare(String nume, Date dataRezervare, String film, int numarSala) {
        //Optional<SalaCinematograf> optional = salaCinematografDao.verificarecapacitate

        salaCinematografDao.addRezervare(nume, dataRezervare, film, numarSala);
        System.out.println("Rezervarea a fost efectuata");
    }

    public List<String> afisareRezervari(String nume) {
        return salaCinematografDao.afisareRezervari(nume);
    }

    public int verificareCapacitate(int numarSala) {
        return salaCinematografDao.verificareCapacitate(numarSala);
    }

    public void stergeRezervare(int id) {
        salaCinematografDao.stergeRezervare(id);
    }

    public boolean verificaRezervare(String film, int numarSala) {
        return salaCinematografDao.verificareFilm(film, numarSala);
    }
}
