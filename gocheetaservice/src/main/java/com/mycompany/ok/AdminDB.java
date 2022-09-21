package com.mycompany.ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class AdminDB {
 static final String URL = "jdbc:mysql://localhost:3306/go";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
     
    public Admin getAdmin(String id) {
        Admin admin = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM go.admin WHERE id='" + id + "'");
            
            while(resultSet.next()) {
                admin = new Admin(resultSet.getString("id"), 
                        resultSet.getString("name"), 
                        resultSet.getString("email"), 
                        resultSet.getString("username"),
                       resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return admin;
    }
    
    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("select * from admin");
            
            while(resultSet.next()) {
                Admin admin = new Admin(resultSet.getString("id"), 
                         resultSet.getString("name"), 
                        resultSet.getString("email"), 
                        resultSet.getString("username"),
                       resultSet.getString("password"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return admins;
    }
    
    public boolean addAdmin(Admin admin) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
        
            int rows = statement.executeUpdate("INSERT INTO admin (`id`, `name`, `email`,`username`,`password`) VALUES ('" 
                    + admin.getId() + "', '" + admin.getName() +  "', '" + admin.getEmail() + "', '" + admin.getUsername() +  "', '" + admin.getPassword() +  "')");
            
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean updateAdmin(Admin admin) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `admin` SET `name` = '" + admin.getName() + "', `Email` = '" 
                    + admin.getEmail() + "' WHERE (`id` = '"  + admin.getId() + "')");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean deleteAdmin(String id) {
                try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM `admin` WHERE (`id` = '" + id + "');");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
}