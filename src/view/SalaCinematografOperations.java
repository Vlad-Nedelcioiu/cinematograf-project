package view;

import controller.SalaCinematografController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class SalaCinematografOperations {

    private static SalaCinematografController salaCinematografController = new SalaCinematografController();
    private static Scanner scanner = new Scanner(System.in);

    private SalaCinematografOperations() {
    }

    public static void salaCinematografOperations() {
        System.out.println("Ce doresti sa faci?");
        String cmd = scanner.nextLine();

        switch (cmd) {
            case "rezervare":
                System.out.println("Care este numele dumneavoastra?");
                String nume = scanner.nextLine();

                System.out.println("Data rezervarii YYYY-MM-DD");
                Date dataRezervare = Date.valueOf(scanner.nextLine());

                System.out.println("Ce film doriti sa vizionati?");
                String film = scanner.nextLine();

                System.out.println("Ce sala doriti?");
                int numarSala = Integer.parseInt(scanner.nextLine());
                salaCinematografController.addRezervare(nume, dataRezervare, film, numarSala);
                System.out.println("Rezervarea a fost efectuata");
                break;


            case "afisareRezervari":
                System.out.println("Cum va numiti?");
                String nume1 = scanner.nextLine();
                salaCinematografController.afisareRezervari(nume1);
                break;

            case "verificareCapacitate":
                System.out.println("In ce sala doriti sa verificati capacitatea?");
                int numarSala1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Locuri libere: " + salaCinematografController.verificareCapacitate(numarSala1));
                break;

            case "stergeRezervare":
                System.out.println("Ce id are rezervarea pe care vreti sa o stergeti?");
                salaCinematografController.stergeRezervare(Integer.parseInt(scanner.nextLine()));
                System.out.println("Rezervarea a fost stearsa!");
                break;

            case "salvare":
                salaCinematografController.salvareRezervariInFisier();
                break;

            default:
                System.out.println("Ceva nu a functionat");
        }
    }
}