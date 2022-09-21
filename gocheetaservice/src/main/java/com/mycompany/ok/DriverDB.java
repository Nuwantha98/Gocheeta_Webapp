/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DriverDB {
    
  static final String URL = "jdbc:mysql://localhost:3306/go";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
     
    public Driver  getDriver (String id) {
        Driver  drivers  = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM go.driver WHERE id='" + id + "'");
            
            while(resultSet.next()) {
                drivers  = new Driver (resultSet.getString("id"), 
                        resultSet.getString("name"), 
                        resultSet.getString("contact"),
                        resultSet.getString("vehicle"),
                        resultSet.getString("username"),
                        resultSet.getString("password")  );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return drivers ;
    }
    
    public List<Driver > getDrivers() {
        List<Driver > drivers = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("select * from driver");
            
            while(resultSet.next()) {
                Driver driver = new Driver(resultSet.getString("id"), 
                            resultSet.getString("name"), 
                        resultSet.getString("contact"),
                        resultSet.getString("vehicle"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return drivers;
    }
    
    public boolean addDriver (Driver  driver ) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
        
            int rows = statement.executeUpdate("INSERT INTO driver(`id`, `name`, `contact`, `username`, `password`, `vehicle`) VALUES ('" 
                    + driver .getId() + "', '" + driver .getName() +  "', '" + driver .getContact() + "', "
                            + "'" + driver .getUsername() + "', '" + driver .getPassword() + "', '" + driver .getVehicle() + "')");
            
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean updateDriver (Driver  driver ) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `driver` SET `name` = '" + driver .getName() + "', `contact` = '" 
                    + driver .getContact() + "' WHERE (`id` = '"  + driver .getId() + "')");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean deleteDriver (String id) {
                try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM `driver` WHERE (`id` = '" + id + "');");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
}