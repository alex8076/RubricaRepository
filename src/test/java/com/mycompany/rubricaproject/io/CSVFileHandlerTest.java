/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Rubrica;
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
public class CSVFileHandlerTest {
    
    public CSVFileHandlerTest() {
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
     * Test of esportaRubrica method, of class CSVFileHandler.
     */
    @Test
    public void testEsportaRubrica() throws Exception {
        System.out.println("esportaRubrica");
        String fileName = "";
        CSVFileHandler instance = null;
        instance.esportaRubrica(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importaRubrica method, of class CSVFileHandler.
     */
    @Test
    public void testImportaRubrica() throws Exception {
        System.out.println("importaRubrica");
        String fileName = "";
        Rubrica rubr = null;
        CSVFileHandler instance = null;
        instance.importaRubrica(fileName, rubr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
