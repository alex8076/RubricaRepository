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
    public void testGetContatti1() {
        System.out.println("getContatti1");
        
        assertTrue(rubrica.getContatti().isEmpty());

        
        rubrica.aggiungiContatto(contatto1);

        Set<Contatto> contatti = rubrica.getContatti();
        assertEquals(1, contatti.size());
        assertTrue(contatti.contains(contatto1));
    
    }

    
    
    @Test
    public void testGetContatti2() {
        System.out.println("getContatti2");
        
        assertTrue(rubrica.getContatti().isEmpty());

        
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        Set<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size());
        assertTrue(contatti.contains(contatto1));
        assertTrue(contatti.contains(contatto2));
    
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
    public void testAggiungiContatto1() {
        System.out.println("aggiungiContatto1 : aggiunta di un contatto alla rubrica");
        
        rubrica.aggiungiContatto(contatto1);
        assertTrue(rubrica.getContatti().contains(contatto1));
    }
    
    
    @Test
    public void testAggiungiContatto2() {
        System.out.println("aggiungiContatto2 : aggiunta di più contatti alla rubrica");

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
       
        rubrica.aggiungiContatto(contatto1);
        rubrica.rimuoviContatto(contatto1);
        
        assertFalse(rubrica.getContatti().contains(contatto1));
    }

    
    
    /**
     * Test of CercaContatti method, of class Rubrica.
     */
    @Test
    public void testCercaContatti1() {
        System.out.println("cercaContatti1");
        
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        Set<Contatto> risultati = rubrica.cercaContatti("Giovanni");
        
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }
    
    
    
     @Test
    public void testCercaContatti2() {
        System.out.println("cercaContatti2");
        
        rubrica.aggiungiContatto(contatto1);
        
        Set<Contatto> risultati = rubrica.cercaContatti("Gio");
        
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }
    
    
    
     @Test
    public void testCercaContatti3() {
        System.out.println("cercaContatti3");
        
        rubrica.aggiungiContatto(contatto1);
        
        Set<Contatto> risultati = rubrica.cercaContatti("francesco");
        
        assertEquals(0, risultati.size());
        assertFalse(risultati.contains(contatto1));
    }
    
    
    
     @Test
    public void testCercaContatti4() {
        System.out.println("cercaContatti4");
        
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



