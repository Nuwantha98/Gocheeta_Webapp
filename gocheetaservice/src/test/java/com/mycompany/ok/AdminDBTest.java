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
public class AdminDBTest {

    public AdminDBTest() {
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
     * Test of getAdmin method, of class AdminDB.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        String id = "1";
        AdminDB instance = new AdminDB();
        Admin expResult = new Admin("1", "kamal", "kmal@gmail.com", "kamal", "123456");
        Admin result = instance.getAdmin(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
    }

    @Test
    public void testAddAdmin() {
        System.out.println("addAdmin");
        AdminDB instance = new AdminDB();
        Admin admin = new Admin("996", "kamal", "kmal@gmail", "kamal", "123456");
        boolean expectedResult = true;
        boolean result = instance.addAdmin(admin);

        assertEquals(expectedResult, result);

        Admin resultAdmin = instance.getAdmin(admin.getId());
        assertEquals(admin.getId(), resultAdmin.getId());
        assertEquals(admin.getName(), resultAdmin.getName());
        assertEquals(admin.getName(), resultAdmin.getEmail());
        assertEquals(admin.getName(), resultAdmin.getUsername());
        assertEquals(admin.getName(), resultAdmin.getPassword());

        System.out.println("updateAdmin");
        admin = new Admin("996", "kamal", "kmal@gmail", "kamal", "123456");
        result = instance.updateAdmin(admin);

        assertEquals(expectedResult, result);

        resultAdmin = instance.getAdmin(admin.getId());
        assertEquals(admin.getId(), resultAdmin.getId());
        assertEquals(admin.getName(), resultAdmin.getName());
        assertEquals(admin.getName(), resultAdmin.getEmail());
        assertEquals(admin.getName(), resultAdmin.getUsername());
        assertEquals(admin.getName(), resultAdmin.getPassword());

        System.out.println("deleteAdmin");
        result = instance.deleteAdmin(admin.getId());
        assertEquals(expectedResult, result);
    }
}
