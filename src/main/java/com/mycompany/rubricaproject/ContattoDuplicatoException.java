/**
 * @file ContattoDuplicatoException.java
 * @brief Eccezione non controllata che emerge qualora vi siano contatti duplicati
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject;

public class ContattoDuplicatoException extends RuntimeException {
    
    /**
     * @brief Costruttore senza parametri, costruisce un'eccezione con un messaggio di default
     */
    public ContattoDuplicatoException() {}
    
     /**
     * @brief Costruttore con messaggio personalizzato, costruisce un'eccezione con uno specifico messaggio di errore
     * 
     * @param[in] msg Il messaggio mostrato dall'eccezione
     */
    public ContattoDuplicatoException(String msg) { 
        super(msg); 
    }
    
}
