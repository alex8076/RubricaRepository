/**
 * @brief Classe di Test per la classe ValidatoreDati
 * 
 * questa classe testa tutti i metodi pulic definiti nella classe ValidatoreDati
 * 
 * @see ValidatoreDati
 * 
 * @author Giovanni Caldarelli
 * @date 2024-12-14
 */

package com.mycompany.rubricaproject.core;

import com.mycompany.rubricaproject.eccezioni.MailNonCorrettaException;
import com.mycompany.rubricaproject.eccezioni.NumeroNonCorrettoException;
import com.mycompany.rubricaproject.eccezioni.UtenteNonValidoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValidatoreDatiTest {
    
    private String nomeValido;
    private String cognomeValido;
    private String nomeNonValido;
    private String cognomeNonValido;
    private String mailValida;
    private String mailNonValida;
    private String numeroValido;
    private String numeroNonValido;
    private String numeroLunghezzaErrata;
    private boolean exception;
    
    public ValidatoreDatiTest() {
    }
  
    
    
    @BeforeEach
    public void setUp() {
        nomeValido = "Giovanni";
        cognomeValido = "Caldarelli";
        nomeNonValido = "";
        cognomeNonValido = "";
        mailValida = "giovanni@example.com";
        mailNonValida = "giovanni.com";
        numeroValido = "1234567890";
        numeroNonValido = "12345ABCDF";
        numeroLunghezzaErrata = "123456789";
        exception = false;
    }
    
    
    
    @AfterEach
    public void tearDown() {
    }

    
    
    /**
     * Test of isValido method, of class ValidatoreDati.
     */
    @Test
    public void testIsValido1() {
        System.out.println("isValido1 : nome e cognome valido");
        try {
            ValidatoreDati.isValido(nomeValido, cognomeValido);
        } catch (UtenteNonValidoException e) {
             exception = true; // Se l'eccezione è stata lanciata, segnala che è avvenuto
    }
        assertFalse(exception);// Verifica che l'eccezione non non sia stata lanciata
    }

    
    
    @Test
    public void testIsValido2() {
        System.out.println("isValido2 : nome valido e cognome non valido");
        try {
            ValidatoreDati.isValido(nomeValido, cognomeNonValido);
        } catch (UtenteNonValidoException e) {
             exception = true; // Se l'eccezione è stata lanciata, segnala che è avvenuto
    }
        assertFalse(exception);// Verifica che l'eccezione non sia stata lanciata
    }
    
    
    
    @Test
    public void testIsValido3() {
        System.out.println("isValido3 : nome non valido e cognome non valido");
        try {
            ValidatoreDati.isValido(nomeNonValido, cognomeNonValido);
        } catch (UtenteNonValidoException e) {
             exception = true; // Se l'eccezione è stata lanciata, segnala che è avvenuto
    }
        assertTrue(exception);// Verifica che l'eccezione sia stata lanciata
    }
    
    
    
    @Test
    public void testIsValido4() {
        System.out.println("isValido4 : nome non valido e cognome valido");
        try {
            ValidatoreDati.isValido(nomeNonValido, cognomeValido);
        } catch (UtenteNonValidoException e) {
             exception = true; // Se l'eccezione è stata lanciata, segnala che è avvenuto
    }
        assertFalse(exception);// Verifica che l'eccezione non sia stata lanciata
    }
    
    
    
    
    /**
     * Test of isMailValida method, of class ValidatoreDati.
     */
    @Test
    public void testIsMailValida1() {
        System.out.println("isMailValida1 : mail valida");
        
        try {
            ValidatoreDati.isMailValida(mailValida);
        } catch (MailNonCorrettaException e) {
            exception = true;
    }

        assertFalse(exception);
    }
    
    
    
    @Test
    public void testIsMailValida2() {
        System.out.println("isMailValida2 : mail non valida");
        
        try {
            ValidatoreDati.isMailValida(mailNonValida);
        } catch (MailNonCorrettaException e) {
            exception = true;
    }

        assertTrue(exception);
    }

    
    
    
    /**
     * Test of isNumeroValido method, of class ValidatoreDati.
     */
    @Test
    public void testIsNumeroValido1() {
        System.out.println("isNumeroValido1 : numero valido");
        
        try {
            ValidatoreDati.isNumeroValido(numeroValido);
        } catch (NumeroNonCorrettoException e) {
            exception = true;
        }

        assertFalse(exception);
    }
    
    
    
    @Test
    public void testIsNumeroValido2() {
        System.out.println("isNumeroValido2 : numero non valido");
        
        try {
            ValidatoreDati.isNumeroValido(numeroNonValido);
        } catch (NumeroNonCorrettoException e) {
            exception = true;
        }

        assertTrue(exception);
    }
    
    
    
    @Test
    public void testIsNumeroValido3() {
        System.out.println("isNumeroValido3 : numero con lunghezza errata");
        
        try {
            ValidatoreDati.isNumeroValido(numeroLunghezzaErrata);
        } catch (NumeroNonCorrettoException e) {
            exception = true;
        }

        assertTrue(exception);
    }
    
    
}
