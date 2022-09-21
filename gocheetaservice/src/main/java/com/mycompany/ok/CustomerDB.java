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
public class CustomerDB {
  static final String URL = "jdbc:mysql://localhost:3306/go";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
     
    public Customer getCustomer( String id) {
        Customer customer = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM go.customer WHERE id='" + id + "'");
            
            while(resultSet.next()) {
                customer = new Customer(resultSet.getString("id"), 
                        resultSet.getString("name"), 
                         resultSet.getString("contact"),
                         resultSet.getString("email"), 
                         resultSet.getString("username"),
                          resultSet.getString("password"), 
                        resultSet.getString("conpass"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return customer;
    }
    
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("select * from customer");
            
            while(resultSet.next()) {
                Customer customer = new Customer(resultSet.getString("id"), 
                         resultSet.getString("name"), 
                         resultSet.getString("contact"),
                         resultSet.getString("email"), 
                         resultSet.getString("username"),
                          resultSet.getString("password"), 
                        resultSet.getString("conpass"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return customers;
    }
    
    public boolean addCustomer(Customer customer) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
        
            int rows = statement.executeUpdate("INSERT INTO customer ( `name`, `contact`,`email`,`username`,`password`,`conpass`) VALUES ( '" + customer.getName() +  "', '" + customer.getContact() + "', '" 
                    + customer.getEmail() + "', '" + customer.getUsername() + "', '" + customer.getPassword() + "', '" + customer.getCpass() + "')");
            
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean updateCustomer(Customer customer) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `customer` SET `name` = '" + customer.getName() + "', `dob` = '" 
                    + customer.getContact() + "' WHERE (`id` = '"  + customer.getId() + "')");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean deleteCustomer(String id) {
                try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM `customer` WHERE (`id` = '" + id + "');");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
}