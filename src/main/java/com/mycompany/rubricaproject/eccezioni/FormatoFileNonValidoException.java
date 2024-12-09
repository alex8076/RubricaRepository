/**
 * @file FormatoFileNonValidoException.java
 * @brief Eccezione non controllata che emerge qualora il formato di un file non sia valido
 * @see RuntimeException
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject.eccezioni;

public class FormatoFileNonValidoException extends RuntimeException {
    
    /**
     * @brief Costruttore senza parametri, costruisce un'eccezione con un messaggio di default
     */
    public FormatoFileNonValidoException() {}
    
    /**
     * @brief Costruttore con messaggio personalizzato, costruisce un'eccezione con uno specifico messaggio di errore
     * 
     * @param[in] msg Il messaggio mostrato dall'eccezione
     */
    public FormatoFileNonValidoException(String msg) { 
        super(msg); 
    }
    
}
