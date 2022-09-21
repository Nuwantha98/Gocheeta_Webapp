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
public class BookingDB {
    
     static final String URL = "jdbc:mysql://localhost:3306/go";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
     
    public Booking getBooking(String id) {
        Booking booking = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM go.bookings WHERE id='" + id + "'");
            
            while(resultSet.next()) {
                booking = new Booking(resultSet.getString("id"), 
                        resultSet.getString("cusname"),
                           resultSet.getString("email"), 
                           resultSet.getString("contact"), 
                           resultSet.getString("date"), 
                           resultSet.getString("time"), 
                           resultSet.getString("picup"), 
                        resultSet.getString("drop"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return booking;
    }
    
    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("select * from bookings");
            
            while(resultSet.next()) {
                Booking booking = new Booking(resultSet.getString("id"), 
                        resultSet.getString("cusname"), 
                        resultSet.getString("email"), 
                          resultSet.getString("contact"), 
                          resultSet.getString("date"), 
                          resultSet.getString("time"), 
                          resultSet.getString("picup"), 
                        resultSet.getString("dropS"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return bookings;
    }
    
    public boolean addBooking(Booking booking) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
        
            int rows = statement.executeUpdate("INSERT INTO bookings (`id`, `cusname`, `email`, `contact`, `time`, `date`,`picup`,`drop`) VALUES ('" 
                    + booking.getId() + "', '" + booking.getName() +  "', '" + booking.getEmail() + "',"
                            + " '" + booking.getContact() + "', '" + booking.getDate() + "', '" + booking.getTime() + "',"
                                    + " '" + booking.getPicup() + "', '" + booking.getDrop() + "')");
            
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean updateBooking(Booking booking) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `bookings` SET `name` = '" + booking.getName() + "', `dob` = '" 
                    + booking.getEmail() + "' WHERE (`id` = '"  + booking.getId() + "')");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean deleteBooking(String id) {
                try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM `bookings` WHERE (`id` = '" + id + "');");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }   
}
