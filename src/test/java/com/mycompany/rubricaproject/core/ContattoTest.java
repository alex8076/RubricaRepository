/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricaproject.core;

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
public class ContattoTest {
    
    public ContattoTest() {
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
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Contatto instance = null;
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Contatto instance = null;
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeriTelefono method, of class Contatto.
     */
    @Test
    public void testGetNumeriTelefono() {
        System.out.println("getNumeriTelefono");
        Contatto instance = null;
        String[] expResult = null;
        String[] result = instance.getNumeriTelefono();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiNumero method, of class Contatto.
     */
    @Test
    public void testAggiungiNumero() {
        System.out.println("aggiungiNumero");
        String numero = "";
        int index = 0;
        Contatto instance = null;
        instance.aggiungiNumero(numero, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaNumero method, of class Contatto.
     */
    @Test
    public void testModificaNumero() {
        System.out.println("modificaNumero");
        String numeroNuovo = "";
        int index = 0;
        Contatto instance = null;
        instance.modificaNumero(numeroNuovo, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviNumero method, of class Contatto.
     */
    @Test
    public void testRimuoviNumero() {
        System.out.println("rimuoviNumero");
        int index = 0;
        Contatto instance = null;
        instance.rimuoviNumero(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndirizziMail method, of class Contatto.
     */
    @Test
    public void testGetIndirizziMail() {
        System.out.println("getIndirizziMail");
        Contatto instance = null;
        String[] expResult = null;
        String[] result = instance.getIndirizziMail();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiMail method, of class Contatto.
     */
    @Test
    public void testAggiungiMail() {
        System.out.println("aggiungiMail");
        String mail = "";
        int index = 0;
        Contatto instance = null;
        instance.aggiungiMail(mail, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaMail method, of class Contatto.
     */
    @Test
    public void testModificaMail() {
        System.out.println("modificaMail");
        String mailNuova = "";
        int index = 0;
        Contatto instance = null;
        instance.modificaMail(mailNuova, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviMail method, of class Contatto.
     */
    @Test
    public void testRimuoviMail() {
        System.out.println("rimuoviMail");
        int index = 0;
        Contatto instance = null;
        instance.rimuoviMail(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Contatto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Contatto instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contatto c = null;
        Contatto instance = null;
        int expResult = 0;
        int result = instance.compareTo(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Contatto instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
