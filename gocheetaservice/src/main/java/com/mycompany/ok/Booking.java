/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ok;

/**
 *
 * @author user
 */
public class Booking {

    private String id;
    private String name;
    private String email;
    private String contact;
    private String date;
    private String time;
    private String picup;
    private String drop;

    public Booking(String id, String name, String email, String contact, String date, String time, String picup, String drop) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.date = date;
        this.time = time;
        this.picup = picup;
        this.drop = drop;
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPicup(String picup) {
        this.picup = picup;
    }

    public void setDrop(String drop) {
        this.drop = drop;
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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPicup() {
        return picup;
    }

    public String getDrop() {
        return drop;
    }

}
