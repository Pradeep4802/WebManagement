/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pradeep
 */
public class DBConnect {
    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/usermanagement";
            con = DriverManager.getConnection(url,"root","");
        } catch(SQLException e) {
            e.printStackTrace();
        } 
        catch(ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return con;
    }
}
