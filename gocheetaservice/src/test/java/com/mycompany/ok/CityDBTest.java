/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.ok;

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
public class CityDBTest {
    
    public CityDBTest() {
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
     * Test of getCity method, of class CityDB.
     */
    @Test
     public void testGetCity() {
        System.out.println("getCity");
        String id = "1";
       CityDB instance = new CityDB();
        City expResult = new City("1", "colombo");
        City result = instance.getCity(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
     
    }
    
    
    @Test
    public void testAddCity() {
        System.out.println("addCity");
       CityDB instance = new CityDB();
        City student = new City("999", "ja-ela");
        boolean expectedResult = true;
        boolean result = instance.addCity(student);
        
        assertEquals(expectedResult, result);
   
        City resultCity = instance.getCity(student.getId());
        assertEquals(student.getId(), resultCity.getId());
        assertEquals(student.getName(), resultCity.getName());
     
        
        System.out.println("updateCity");
        student = new City("999", "ja-ela");
        result = instance.updateCity(student);
        
        assertEquals(expectedResult, result);
        
      
        resultCity = instance.getCity(student.getId());
        assertEquals(student.getId(), resultCity.getId());
        assertEquals(student.getName(), resultCity.getName());
       
        
        System.out.println("deleteCity");
        result = instance.deleteCity(student.getId());
        assertEquals(expectedResult, result);  
    }
}
