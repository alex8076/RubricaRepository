/**
 * @file MailNonCorrettaException.java
 * @brief Eccezione non controllata che emerge qualora la mail inserita non sia correttamente formattata
 * @see RuntimeException
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject.eccezioni;

public class MailNonCorrettaException extends RuntimeException {
    
    /**
     * @brief Costruttore senza parametri, costruisce un'eccezione con un messaggio di default
     */
    public MailNonCorrettaException() {}
    
    /**
     * @brief Costruttore con messaggio personalizzato, costruisce un'eccezione con uno specifico messaggio di errore
     * 
     * @param[in] msg Il messaggio mostrato dall'eccezione
     */
    public MailNonCorrettaException(String msg) { 
        super(msg); 
    }
    
}
