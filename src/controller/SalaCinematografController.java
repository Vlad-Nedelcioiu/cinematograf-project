package controller;

import dao.SalaCinematografDao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class SalaCinematografController {

    private SalaCinematografDao salaCinematografDao;

    public SalaCinematografController() {
        salaCinematografDao = new SalaCinematografDao(ConnectionController.getInstance().getConnection());
    }

    public void addRezervare(String nume, Date dataRezervare, String film, int numarSala) {

        LocalDate dataCurenta = LocalDate.now();
        if (dataCurenta.isAfter(dataRezervare.toLocalDate())) {
            throw new RuntimeException("DataIncorecta");
        }

        if (numarSala >= 1 && numarSala <= 9) {
            if (verificareCapacitate(numarSala) < 21) {
                if (verificaRezervare(film, numarSala)) {
                    salaCinematografDao.addRezervare(nume, dataRezervare, film, numarSala);
                } else if(!salaCinematografDao.verificareSala(numarSala)){
                    salaCinematografDao.addRezervare(nume, dataRezervare, film, numarSala);
                } else {
                    throw new RuntimeException("InAceastaSalaSeDifuzeazaAltFilm");
                }
            } else {
                throw new RuntimeException("NuMaiSuntLocuriLibere");
            }
        } else {
            throw new RuntimeException("SalaNuExista");
        }

    }

    public List<String> afisareRezervari(String nume) {
        return salaCinematografDao.afisareRezervari(nume);
    }

    public int verificareCapacitate(int numarSala) {
        return salaCinematografDao.verificareCapacitate(numarSala);
    }

    public boolean verificaRezervare(String film, int numarSala) {
        return salaCinematografDao.verificareRezervare(film, numarSala);
    }

    public void salvareRezervariInFisier(){
        salaCinematografDao.salvareRezervariInFisier();
    }

    public void stergeRezervare(int id) {
        salaCinematografDao.stergeRezervare(id);
    }
}
