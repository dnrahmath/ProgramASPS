/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programasps.backend;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;

import static programasps.backend.koneksi.DB_URL;
import static programasps.backend.koneksi.JDBC_DRIVER;
import static programasps.backend.koneksi.PASS;
import static programasps.backend.koneksi.USER;
import static programasps.backend.koneksi.conn;
import static programasps.backend.koneksi.rs;
import static programasps.backend.koneksi.stmt;

/**
 *
 * @author dnrahmath
 */
public class koneksi {
    
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    final static String USER = "root";
    final static String PASS = "";
    final static String DB_NAME = "perpustakaan";
    final static String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    public static Connection conn;
    //static PreparedStatement pstmt;
    public static Statement stmt;
    public static ResultSet rs;
    
    //jumlah array diCustom dari backend
    final int TotalArrayClass = 10000;
    
    
    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
            
            /*--------------------------------------------------------------------------------*/
            System.out.print("Koneksi Database: "+DB_URL+" ,User: "+USER+" ,Password: "+PASS+" -> Berhasil");
            /*--------------------------------------------------------------------------------*/
                        
            //stmt.close();
            //conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}


