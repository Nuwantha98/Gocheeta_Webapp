/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ok;

/**
 *
 * @author user
 */
public class Customer {
     private String id; 
     private String name; 
     private String email;
      private String contact;
       private String username; 
       private String password;
        private String cpass;

    public Customer(String id, String name, String email, String contact, String username, String password, String cpass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.cpass = cpass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCpass() {
        return cpass;
    }

}