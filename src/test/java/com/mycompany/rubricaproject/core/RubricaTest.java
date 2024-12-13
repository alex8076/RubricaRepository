/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricaproject.core;

import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author giovannicaldarelli
 */
public class RubricaTest {
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        Rubrica instance = new Rubrica();
        Set<Contatto> expResult = null;
        Set<Contatto> result = instance.getContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContatti method, of class Rubrica.
     */
    @Test
    public void testSetContatti() {
        System.out.println("setContatti");
        Set<Contatto> contatti = null;
        Rubrica instance = new Rubrica();
        instance.setContatti(contatti);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto contatto = null;
        Rubrica instance = new Rubrica();
        instance.aggiungiContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.rimuoviContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CercaContatti method, of class Rubrica.
     */
    @Test
    public void testCercaContatti() {
        System.out.println("CercaContatti");
        String ricercaStr = "";
        Rubrica instance = new Rubrica();
        Set<Contatto> expResult = null;
        Set<Contatto> result = instance.CercaContatti(ricercaStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.modificaContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
