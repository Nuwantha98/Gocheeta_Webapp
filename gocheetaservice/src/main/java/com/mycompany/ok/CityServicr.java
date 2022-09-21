/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ok;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author user
 */
   @Path("city")
public class CityServicr {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCitys() {
       CityDB utils = new CityDB();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getCitys());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCity(@PathParam("id") String id) {
       CityDB utils = new CityDB();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getCity(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCity(String json) {
       CityDB utils = new CityDB();
        Gson gson = new GsonBuilder().create();
        City city = gson.fromJson(json, City.class);
        boolean result = utils.addCity(city);
        
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCity(String json) {
       CityDB utils = new CityDB();
        Gson gson = new GsonBuilder().create();
        City city = gson.fromJson(json, City.class);
        boolean result = utils.updateCity(city);
        
        if (result) {
            return Response.status(200).entity("Successfully updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteCity(@PathParam("id") String id) {
       CityDB utils = new CityDB();
        boolean result = utils.deleteCity(id);
        if (result) {
            return Response.status(200).entity("Successfully deleted").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
}


