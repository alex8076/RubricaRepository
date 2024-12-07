/**
 * @file NumeroNonCorrettoException.java
 * @brief Eccezione non controllata che emerge qualora un numero inserito non sia correttamente formattato
 * @see RuntimeException
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject;

public class NumeroNonCorrettoException extends RuntimeException {
    
    /**
     * @brief Costruttore senza parametri, costruisce un'eccezione con un messaggio di default
     */
    public NumeroNonCorrettoException() {}
    
    /**
     * @brief Costruttore con messaggio personalizzato, costruisce un'eccezione con uno specifico messaggio di errore
     * 
     * @param[in] msg Il messaggio mostrato dall'eccezione
     */
    public NumeroNonCorrettoException(String msg) { 
        super(msg); 
    }
    
}
