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
public class ValidatoreDatiTest {
    
    public ValidatoreDatiTest() {
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
     * Test of isValido method, of class ValidatoreDati.
     */
    @Test
    public void testIsValido() {
        System.out.println("isValido");
        String nome = "";
        String cognome = "";
        ValidatoreDati.isValido(nome, cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMailValida method, of class ValidatoreDati.
     */
    @Test
    public void testIsMailValida() {
        System.out.println("isMailValida");
        String mail = "";
        ValidatoreDati.isMailValida(mail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumeroValido method, of class ValidatoreDati.
     */
    @Test
    public void testIsNumeroValido() {
        System.out.println("isNumeroValido");
        String numero = "";
        ValidatoreDati.isNumeroValido(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
