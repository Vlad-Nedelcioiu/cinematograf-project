package view;

import java.util.Scanner;

public class UserOperations {

    private UserOperations(){}
    static Scanner scanner = new Scanner(System.in);
    public static void userOperation(){

        System.out.println("Logare");

        System.out.println("User: ");
        String user = scanner.nextLine();
        System.out.println("Parola: ");
        String password = scanner.nextLine();

        if(user.equals("personalCinematograf") & password.equals("Cinem@123")){
            SalaCinematografOperations.salaCinematografOperations();
        } else {
            System.out.println("User sau parola incorecta" + "\n");
            userOperation();
        }

    }
}
