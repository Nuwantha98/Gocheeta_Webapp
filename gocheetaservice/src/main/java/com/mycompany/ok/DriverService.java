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
    
@Path("driver")
public class DriverService {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDrivers() {
        DriverDB  utils = new DriverDB ();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getDrivers());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDriver (@PathParam("id") String id) {
        DriverDB  utils = new DriverDB ();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getDriver(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDriver (String json) {
        DriverDB  utils = new DriverDB ();
        Gson gson = new GsonBuilder().create();
        Driver  driver  = gson.fromJson(json,Driver .class);
        boolean result = utils.addDriver (driver );
        
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDriver (String json) {
        DriverDB  utils = new DriverDB ();
        Gson gson = new GsonBuilder().create();
        Driver  driver  = gson.fromJson(json, Driver .class);
        boolean result = utils.updateDriver (driver );
        
        if (result) {
            return Response.status(200).entity("Successfully updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteDriver (@PathParam("id") String id) {
        DriverDB  utils = new DriverDB ();
        boolean result = utils.deleteDriver (id);
        if (result) {
            return Response.status(200).entity("Successfully deleted").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
}
