/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javadb;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

import java.util.Scanner;


/**
 *
 * @author Irzi Rhmtllh
 */
public class JavaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan username: ");
        String uname = input.nextLine();
        System.out.print("Masukkan password: ");
        String passwd = input.next();
        try {
            Connection connection = Koneksi.konek();
            System.out.println("Koneksi berhasil!");

            Statement statement = connection.createStatement();

            // Contoh query SELECT
            String query = "SELECT * FROM users WHERE username = '" + uname + "' AND password = '" + passwd+"'";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);

            
            if(resultSet.next()){
                System.out.println("Login berhasil");
            }else{
                System.out.println("Username atau password salah");
            }
            
            resultSet.close();
            statement.close();
            connection.close();  

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
