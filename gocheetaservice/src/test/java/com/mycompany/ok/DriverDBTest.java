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
public class DriverDBTest {
    
    public DriverDBTest() {
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
     * Test of getDriver method, of class DriverDB.
     */
   @Test
    public void testGetDriver() {
        System.out.println("getDriver");
        String id = "1";
        DriverDB  instance = new DriverDB ();
        Driver expResult = new Driver("1","nimal","0552288177","nuwantha","1234","car");
                
        Driver result = instance.getDriver(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getContact(), result.getContact());
    }
    
    
    @Test
    public void testAddDriver() {
        System.out.println("addDriver");
        DriverDB  instance = new DriverDB();
        Driver driver = new Driver("3","nimal","0552288177","nuwantha","1234","car");
        boolean expectedResult = true;
        boolean result = instance.addDriver(driver);
        
        assertEquals(expectedResult, result);
   
        Driver resultDriver = instance.getDriver(driver.getId());
        assertEquals(driver.getId(), resultDriver.getId());
        assertEquals(driver.getName(), resultDriver.getName());
       
        
        System.out.println("updateDriver");
        driver = new Driver("3","nimal","0552288177","nuwantha","1234","car");
        result = instance.updateDriver(driver);
        
        assertEquals(expectedResult, result);
        
      
        resultDriver = instance.getDriver(driver.getId());
        assertEquals(driver.getId(), resultDriver.getId());
        assertEquals(driver.getName(), resultDriver.getName());
        
        
        System.out.println("deleteDriver");
        result = instance.deleteDriver(driver.getId());
        assertEquals(expectedResult, result);  
    }
}


