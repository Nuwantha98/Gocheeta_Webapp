package com.mycompany.ok;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CustomerDBTest {

    public CustomerDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomer method, of class CustomerDB.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String id = "1";
        CustomerDB instance = new CustomerDB();
        Customer expResult = new Customer("1", "nuwan", "0552288177", "dmnpbandara98@gmail.com", "nuwan", "1234", "1234");
        Customer result = instance.getCustomer(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getContact(), result.getContact());
        assertEquals(expResult.getUsername(), result.getUsername());
     
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getCpass(), result.getCpass());

    }

    @Test

    public void testAddCustomer() {
        System.out.println("addCustomer");
        CustomerDB instance = new CustomerDB();
        Customer customer = new Customer("", "tom","nuwantha98@gmail.com", "0552288177", "nuwantha", "12345", "12345");
        boolean expectedResult = true;
        boolean result = instance.addCustomer(customer);

        assertEquals(expectedResult, result);

        Customer resultCustomer = instance.getCustomer(customer.getId());
        assertEquals(customer.getId(), resultCustomer.getId());
        assertEquals(customer.getName(), resultCustomer.getName());
        assertEquals(customer.getEmail(), resultCustomer.getEmail());
        assertEquals(customer.getContact(), resultCustomer.getContact());
        assertEquals(customer.getUsername(), resultCustomer.getUsername());
           assertEquals(customer.getPassword(), resultCustomer.getPassword());
              assertEquals(customer.getCpass(), resultCustomer.getCpass());

        System.out.println("updateCustomer");
        customer = new Customer("1", "tom","nuwantha98@gmail.com", "0552288177", "nuwantha", "12345", "12345");
        result = instance.updateCustomer(customer);

        assertEquals(expectedResult, result);

        resultCustomer = instance.getCustomer(customer.getId());
      
        assertEquals(customer.getName(), resultCustomer.getName());
        assertEquals(customer.getEmail(), resultCustomer.getEmail());
        assertEquals(customer.getContact(), resultCustomer.getContact());
        assertEquals(customer.getUsername(), resultCustomer.getUsername());
         assertEquals(customer.getPassword(), resultCustomer.getPassword());
              assertEquals(customer.getCpass(), resultCustomer.getCpass());
        System.out.println("deleteCustomer");
        result = instance.deleteCustomer(customer.getId());
        assertEquals(expectedResult, result);
    }


   
}
