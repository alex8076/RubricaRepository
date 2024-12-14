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
    }

    
    
    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        
        assertTrue(rubrica.getContatti().isEmpty());

        Contatto contatto = new Contatto("Mario", "Rossi");
        rubrica.aggiungiContatto(contatto);

        Set<Contatto> contatti = rubrica.getContatti();
        assertEquals(1, contatti.size());
        assertTrue(contatti.contains(contatto));
    
    }

    
    
    
    /**
     * Test of setContatti method, of class Rubrica.
     */
    @Test
    public void testSetContatti() {
        System.out.println("setContatti");
        
        Set<Contatto> nuoviContatti = new TreeSet<>();
       

        nuoviContatti.add(contatto1);
        nuoviContatti.add(contatto2);

        rubrica.setContatti(nuoviContatti);

        assertTrue(rubrica.getContatti().contains(contatto1));
        assertTrue(rubrica.getContatti().contains(contatto2));
    }

    
    
    
    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        
        Contatto contatto = new Contatto("Giovanni", "Rossi");

        rubrica.aggiungiContatto(contatto);
        assertTrue(rubrica.getContatti().contains(contatto));
    }
    
    
    @Test
    public void testAggiungiContatto2() {
        System.out.println("aggiungiContatto");

        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        assertTrue(rubrica.getContatti().contains(contatto1));
        assertTrue(rubrica.getContatti().contains(contatto2));
        
        assertEquals(2, rubrica.getContatti().size());
    }
    
    
    
    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        
        Contatto contatto = new Contatto("Giovanni", "Rossi");

        rubrica.aggiungiContatto(contatto);
        rubrica.rimuoviContatto(contatto);
        assertFalse(rubrica.getContatti().contains(contatto));
    }

    
    
    
    /**
     * Test of CercaContatti method, of class Rubrica.
     */
    @Test
    public void testCercaContatti() {
        System.out.println("cercaContatti");
        
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        Set<Contatto> risultati = rubrica.cercaContatti("Giovanni");
        
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }
    
     @Test
    public void testCercaContatti2() {
        System.out.println("cercaContatti");
        
        rubrica.aggiungiContatto(contatto1);
        
        Set<Contatto> risultati = rubrica.cercaContatti("Gio");
        
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }
    
     @Test
    public void testCercaContatti3() {
        System.out.println("cercaContatti");
        
        rubrica.aggiungiContatto(contatto1);
        
        Set<Contatto> risultati = rubrica.cercaContatti("francesco");
        
        assertEquals(0, risultati.size());
        assertFalse(risultati.contains(contatto1));
    }
    
     @Test
    public void testCercaContatti4() {
        System.out.println("cercaContatti");
        
        rubrica.aggiungiContatto(contatto1);
        
        Set<Contatto> risultati = rubrica.cercaContatti("Caldarelli");
        
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }



    
    
    
    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");

        rubrica.aggiungiContatto(contatto1);
        rubrica.modificaContatto(contatto1);

        assertTrue(rubrica.getContatti().contains(contatto1));
    }
    
}



