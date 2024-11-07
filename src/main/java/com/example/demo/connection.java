package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    public static Connection ConnectionBD() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds_java", "root", "");;
            return connect;
        } catch (Exception e) {
            System.out.println("erreur de connexion");
        }
        return null;
    }
}
