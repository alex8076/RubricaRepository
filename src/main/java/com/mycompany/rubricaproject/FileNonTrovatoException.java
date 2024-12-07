/**
 * @file FileNonTrovatoException.java
 * @brief Eccezione non controllata che emerge qualora un file non sia stato trovato
 * @see RuntimeException
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject;

public class FileNonTrovatoException extends RuntimeException {
 
    /**
     * @brief Costruttore senza parametri, costruisce un'eccezione con un messaggio di default
     */
    public FileNonTrovatoException() {}
    
    /**
     * @brief Costruttore con messaggio personalizzato, costruisce un'eccezione con uno specifico messaggio di errore
     * 
     * @param[in] msg Il messaggio mostrato dall'eccezione
     */
    public FileNonTrovatoException(String msg) { 
        super(msg); 
    }
    
}
