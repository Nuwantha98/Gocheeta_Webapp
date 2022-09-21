/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ok;

/**
 *
 * @author user
 */
public class Driver {

    private String id;
    private String name;
    private String contact;
    private String vehicle;
    private String username;
    private String password;

    public Driver(String id, String name, String contact, String vehicle, String username, String password) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.vehicle = vehicle;
        this.username = username;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
