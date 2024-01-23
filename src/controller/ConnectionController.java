package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    private Connection connection;
    private static ConnectionController instance;

    private ConnectionController(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemadb","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final synchronized ConnectionController getInstance(){
        if(instance == null){
            instance = new ConnectionController();
        }
        return instance;
    }

    public Connection getConnection(){
        return this.connection;
    }
}


