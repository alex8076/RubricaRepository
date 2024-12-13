/**
 * @brief Classe di Test per la classe Rubrica
 * 
 * questa classe testa tutti i metodi pulic definiti nella classe Rubrica
 * 
 * @see Rubrica
 * 
 * @author Giovanni Caldarelli
 * @date 2024-12-13
 */
package com.mycompany.rubricaproject.core;

import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class RubricaTest {
    
    private Rubrica rubrica;
    private Contatto contatto1;
    private Contatto contatto2;
    
    
    public RubricaTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        rubrica= new Rubrica();
        contatto1 = new Contatto("Giovanni", "Caldarelli");
        contatto2 = new Contatto("Maria", "Rossi");
    }
    
    
    
    @AfterEach
    public void tearDown() {
        rubrica = null;
        contatto1= null;
        contatto2= null;
    }

    
    
    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        Set<Contatto> contatti = rubrica.getContatti();
        
        assertNotNull(contatti);
        assertEquals(2, contatti.size());
    
    
        assertTrue(contatti.contains(contatto1));
        assertTrue(contatti.contains(contatto2));
    
    }

    
    
    
    /**
     * Test of setContatti method, of class Rubrica.
     */
    @Test
    public void testSetContatti() {
        System.out.println("setContatto");
        
        Set<Contatto> nuoviContatti = new TreeSet();
        nuoviContatti.add(contatto1);
        nuoviContatti.add(contatto2);
        
        rubrica.setContatti(nuoviContatti);
        
        Set<Contatto> contatti = rubrica.getContatti();
        
        assertTrue(contatti.contains(contatto1));
        assertTrue(contatti.contains(contatto2));
    }

    
    
    
    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        
         rubrica.aggiungiContatto(contatto1);
        
        Set<Contatto> contatti = rubrica.getContatti();
        
        assertEquals(1, contatti.size());
        assertTrue(contatti.contains(contatto1));
    }
    
    
    
    
    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        
        rubrica.aggiungiContatto(contatto1);
        rubrica.rimuoviContatto(contatto1);
        
        Set<Contatto> contatti = rubrica.getContatti();
        
        assertEquals(0, contatti.size());
    }

    
    
    
    /**
     * Test of CercaContatti method, of class Rubrica.
     */
    @Test
    public void testCercaContatti() {
        System.out.println("rimuoviContatto");
        
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        Set<Contatto> risultati = rubrica.cercaContatti("Giovanni");
        
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("rimuoviContatto");
        
        rubrica.aggiungiContatto(contatto1);
        Contatto contattoModificato = new Contatto("Giovanni", "Bianchi");
        rubrica.modificaContatto(contatto1);
        
        Set<Contatto> contatti = rubrica.getContatti();
        
        assertTrue(contatti.contains(contattoModificato));
    }
    
}
