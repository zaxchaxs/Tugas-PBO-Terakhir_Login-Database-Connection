package javadb;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Irzi Rhmtllh
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection konek;
    
    public static Connection konek() throws SQLException, ClassNotFoundException {
        try {
            if(konek == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadatabase", "root", "");
                System.out.println("Connected!");
            };
            return konek;
        } catch (Exception e) {
            System.err.println("Not Connected!");
            throw e;
        }
    }
}
