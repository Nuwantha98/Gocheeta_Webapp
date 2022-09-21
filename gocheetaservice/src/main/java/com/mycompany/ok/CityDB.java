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
public class CityDB {

    static final String URL = "jdbc:mysql://localhost:3306/go";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public City getCity(String id) {
        City city = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM go.city WHERE id='" + id + "'");

            while (resultSet.next()) {
                city = new City(resultSet.getString("id"),
                        resultSet.getString("name")); 
                       
                        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return city;
    }

    public List<City> getCitys() {
        List<City> citys = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from city");

            while (resultSet.next()) {
                City city = new City(resultSet.getString("id"),
                        resultSet.getString("name"));

                citys.add(city);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return citys;
    }

    public boolean addCity(City city) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            int rows = statement.executeUpdate("INSERT INTO city (`id`, `name`) VALUES ('"
                    + city.getId() + "', '" + city.getName() + "')");

            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateCity(City city) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `city` SET `name` = '" + city.getName() + "' WHERE (`id` = '" + city.getId() + "')");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteCity(String id) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM `city` WHERE (`id` = '" + id + "');");
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
