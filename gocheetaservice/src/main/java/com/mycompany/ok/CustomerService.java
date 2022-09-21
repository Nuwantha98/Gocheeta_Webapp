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
@Path("customer")
public class CustomerService {

 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomers() {
        CustomerDB utils = new CustomerDB();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getCustomers());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@PathParam("id") String id) {
        CustomerDB utils = new CustomerDB();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getCustomer(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(String json) {
        CustomerDB utils = new CustomerDB();
        Gson gson = new GsonBuilder().create();
        Customer customer = gson.fromJson(json, Customer.class);
        boolean result = utils.addCustomer(customer);
        
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(String json) {
        CustomerDB utils = new CustomerDB();
        Gson gson = new GsonBuilder().create();
        Customer customer = gson.fromJson(json, Customer.class);
        boolean result = utils.updateCustomer(customer);
        
        if (result) {
            return Response.status(200).entity("Successfully updated").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") String id) {
        CustomerDB utils = new CustomerDB();
        boolean result = utils.deleteCustomer(id);
        if (result) {
            return Response.status(200).entity("Successfully deleted").build();
        } else {
            return Response.status(501).entity("Error occurred").build();
        }
    }
}

