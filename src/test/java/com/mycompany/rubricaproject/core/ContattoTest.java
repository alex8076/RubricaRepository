/**
 * @brief Classe di Test per la classe Contatto
 * 
 * questa classe testa tutti i metodi pulic definiti nella classe Contatto
 * 
 * @see Contatto
 * 
 * @author Gaetano Donnarumma
 * @date 2024-12-13
 */
package com.mycompany.rubricaproject.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContattoTest {
    
    private Contatto c;
    
    public ContattoTest() {
    }
    
    @BeforeEach
    public void setUp() {
        c = new Contatto("Mario", "Rossi");
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
        String expResult = "Mario";
        String result = c.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Marco";
        c.setNome(nome);
        assertEquals(nome, c.getNome());
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        String expResult = "Rossi";
        String result = c.getCognome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "Bianchi";
        c.setCognome(cognome);
        assertEquals(cognome, c.getCognome());
    }

    /**
     * Test of getNumeriTelefono method, of class Contatto.
     */
    @Test
    public void testGetNumeriTelefono() {
        System.out.println("getNumeriTelefono");
        c.aggiungiNumero("1234567890", 0);
        c.aggiungiNumero("1234567891", 1);
        c.aggiungiNumero("1234567892", 2);
        String[] expResult = {"1234567890", "1234567891", "1234567892"};
        String[] result = c.getNumeriTelefono();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of aggiungiNumero method, of class Contatto.
     */
    
    @Test
    public void testAggiungiNumero1() {
        System.out.println("aggiungiNumero1: aggiunta di un numero non presente");
        String numero = "1234567890";
        int index = 0;
        c.aggiungiNumero(numero, index);
        assertEquals(numero, c.getNumeriTelefono()[index]);
    }
    
    public void testAggiungiNumero2() {
        System.out.println("aggiungiNumero2: aggiunta di un numero già presente");
        String numero = "1234567890";
        int index = 0;
        c.aggiungiNumero(numero, index);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            c.aggiungiNumero(numero, index+1);
        });
        assertEquals("Il numero di telefono è già presente.", ex.getMessage());
    }

    /**
     * Test of modificaNumero method, of class Contatto.
     */
    
    @Test
    public void testModificaNumero1() {
        System.out.println("modificaNumero1: modifica di un numero");
        String numero = "1234567890";
        String numeroNuovo = "1234567891";
        int index = 0;
        c.aggiungiNumero(numero, index);
        assertEquals(numero, c.getNumeriTelefono()[index]);
        c.modificaNumero(numeroNuovo, index);
        assertEquals(numeroNuovo, c.getNumeriTelefono()[index]);
    }
    
    @Test
    public void testModificaNumero2() {
        System.out.println("modificaNumero2: modifica di un numero in un altro già presente");
        String numero = "1234567890";
        String numeroNuovo = "1234567891";
        int index = 0;
        c.aggiungiNumero(numero, index);
        c.aggiungiNumero(numeroNuovo, index+1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            c.modificaNumero(numeroNuovo, index);
        });
        assertEquals("Il numero di telefono da sostituire è già presente", ex.getMessage());
    }

    /**
     * Test of rimuoviNumero method, of class Contatto.
     */
    @Test
    public void testRimuoviNumero() {
        System.out.println("rimuoviNumero");
        int index = 0;
        c.aggiungiNumero("1234567890", index);
        c.rimuoviNumero(index);
        assertEquals(null, c.getNumeriTelefono()[index]);
    }

    /**
     * Test of getIndirizziMail method, of class Contatto.
     */
    @Test
    public void testGetIndirizziMail() {
        System.out.println("getIndirizziMail");
        c.aggiungiMail("mario@rossi.it", 0);
        c.aggiungiMail("mario@rossi.com", 1);
        c.aggiungiMail("mario@rossi.uk", 2);
        String[] expResult = {"mario@rossi.it", "mario@rossi.com", "mario@rossi.uk"};
        String[] result = c.getIndirizziMail();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of aggiungiMail method, of class Contatto.
     */
    
    @Test
    public void testAggiungiMail1() {
        System.out.println("aggiungiMail1: aggiunta di una mail non presente");
        String mail = "mario@rossi.it";
        int index = 0;
        c.aggiungiMail(mail, index);
        assertEquals(mail, c.getIndirizziMail()[index]);
    }
    
    @Test
    public void testAggiungiMail2() {
        System.out.println("aggiungiMail2: aggiunta di una mail già presente");
        String mail = "mario@rossi.it";
        int index = 0;
        c.aggiungiMail(mail, index);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            c.aggiungiMail(mail, index+1);
        });
        assertEquals("La mail è già presente", ex.getMessage());
    }

    /**
     * Test of modificaMail method, of class Contatto.
     */
    
    @Test
    public void testModificaMail1() {
        System.out.println("modificaMail1: modifica di una mail");
        String mail = "mario@rossi.it";
        String mailNuova = "mario@rossi.com";
        int index = 0;
        c.aggiungiMail(mail, index);
        assertEquals(mail, c.getIndirizziMail()[index]);
        c.modificaMail(mailNuova, index);
        assertEquals(mailNuova, c.getIndirizziMail()[index]);
    }
    
    @Test
    public void testModificaMail2() {
        System.out.println("modificaMail2: modifica di una mail in un'altra già presente");
        String mail = "mario@rossi.it";
        String mailNuova = "mario@rossi.com";
        int index = 0;
        c.aggiungiMail(mail, index);
        c.aggiungiMail(mailNuova, index+1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            c.modificaMail(mailNuova, index);
        });
        assertEquals("La mail inserita è già presente", ex.getMessage());
    }

    /**
     * Test of rimuoviMail method, of class Contatto.
     */
    @Test
    public void testRimuoviMail() {
        System.out.println("rimuoviMail");
        int index = 0;
        c.aggiungiMail("mario@rossi.it", index);
        c.rimuoviMail(index);
        assertEquals(null, c.getIndirizziMail()[index]);
    }

    /**
     * Test of hashCode method, of class Contatto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String numero = "1234567890";
        String mail = "prova@gmail.it";
        c.aggiungiNumero(numero, 0);
        c.aggiungiMail(mail, 0);
        Contatto c2 = new Contatto("Mauro", "Galli");
        c2.aggiungiNumero(numero, 0);
        c2.aggiungiMail(mail, 0);
        assertEquals(c.hashCode(), c2.hashCode());
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    
    @Test
    public void testCompareTo1() {
        System.out.println("compareTo1: nome diverso, cognome diverso (Con Rossi che precede Verdi)");
        Contatto c2 = new Contatto("Luigi", "Verdi");
        assertTrue(c.compareTo(c2) < 0);
    }
    
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo2: stesso cognome, nome diverso (con Mario che segue Marco)");
        Contatto c2 = new Contatto("Marco", "Rossi");
        assertTrue(c.compareTo(c2) > 0);
    }
    
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo3: nome diverso, cognome diverso (con Rossi che segue Ambrosio)");
        Contatto c2 = new Contatto("Giulio", "Ambrosio");
        assertFalse(c.compareTo(c2) < 0);
    }
    
    @Test
    public void testCompareTo4() {
        System.out.println("compareTo4: stesso cognome, nome diverso (con Mario che precede Oscar)");
        Contatto c2 = new Contatto("Oscar", "Rossi");
        assertFalse(c.compareTo(c2) > 0);
    }

    /**
     * Test of equals method, of class Contatto.
     */
    
    @Test
    public void testEquals1() {
        System.out.println("equals1: stesso numero nella stessa posizione");
        c.aggiungiNumero("1234567890", 0);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567890", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals2() {
        System.out.println("equals2: stesso numero in posizione differenti");
        c.aggiungiNumero("1234567890", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567890", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals3() {
        System.out.println("equals3: numeri diversi nella stessa posizione");
        c.aggiungiNumero("1234567891", 0);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567890", 0);
        assertFalse(c.equals(c2));
    }
    
    @Test
    public void testEquals4() {
        System.out.println("equals4: numeri diversi in posizioni differenti");
        c.aggiungiNumero("1234567891", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567890", 0);
        assertFalse(c.equals(c2));
    }
    
    @Test
    public void testEquals5() {
        System.out.println("equals5: stessa mail nella stessa posizione");
        c.aggiungiMail("prova@gmail.com", 0);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiMail("prova@gmail.com", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals6() {
        System.out.println("equals6: stessa mail in posizioni differenti");
        c.aggiungiMail("prova@gmail.com", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiMail("prova@gmail.com", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals7() {
        System.out.println("equals7: mail diverse nella stessa posizione");
        c.aggiungiMail("prova@gmail.it", 0);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiMail("prova@gmail.com", 0);
        assertFalse(c.equals(c2));
    }
    
    @Test
    public void testEquals8() {
        System.out.println("equals8: mail diverse in posizioni differenti");
        c.aggiungiMail("prova@gmail.it", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiMail("prova@gmail.com", 0);
        assertFalse(c.equals(c2));
    }
    
    @Test
    public void testEquals9() {
        System.out.println("equals9: numeri identici in posizioni differenti, mail diverse in posizioni differenti");
        c.aggiungiNumero("1234567890", 0);
        c.aggiungiMail("prova@gmail.it", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567890", 1);
        c2.aggiungiMail("prova@gmail.com", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals10() {
        System.out.println("equals10: numeri diversi in posizioni differenti, mail identiche in posizioni differenti");
        c.aggiungiNumero("1234567890", 0);
        c.aggiungiMail("prova@gmail.it", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567891", 1);
        c2.aggiungiMail("prova@gmail.it", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals11() {
        System.out.println("equals11: numeri identici in posizioni differenti, Mail identiche in posizioni differenti");
        c.aggiungiNumero("1234567890", 0);
        c.aggiungiMail("prova@gmail.it", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567890", 1);
        c2.aggiungiMail("prova@gmail.it", 0);
        assertTrue(c.equals(c2));
    }
    
    @Test
    public void testEquals12() {
        System.out.println("equals12: numero diversi in posizioni differenti, Mail diverse in posizioni differenti");
        c.aggiungiNumero("1234567890", 0);
        c.aggiungiMail("prova@gmail.com", 1);
        Contatto c2 = new Contatto("Luigi", "Verdi");
        c2.aggiungiNumero("1234567891", 1);
        c2.aggiungiMail("prova@gmail.it", 0);
        assertFalse(c.equals(c2));
    }
    
}
