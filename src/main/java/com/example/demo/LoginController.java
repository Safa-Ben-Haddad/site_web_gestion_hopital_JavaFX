package com.example.demo;
import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField login;
    @FXML
    private PasswordField pass;
    private static Connection con;
    public void onButton()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver" );
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds_java", "root", "");
        String l= login.getText();
        String req="select *  from patient where nomPatient = ?  ";
        PreparedStatement st=con.prepareStatement(req);
        st.setString(1,l);
        ResultSet rs = st.executeQuery();
        if(rs.next())
            System.out.println("Bienvenue");
        else
            System.out.println("login ou mdp incorrect");



    }

}
