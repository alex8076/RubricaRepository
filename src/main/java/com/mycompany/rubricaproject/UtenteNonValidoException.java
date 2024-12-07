/**
 * @file UtenteNonValidoException.java
 * @brief Eccezione non controllata che emerge qualora un utente inserito non sia valido (ossia non abbia almeno un nome o un cognome)
 * @see RuntimeException
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject;

public class UtenteNonValidoException extends RuntimeException {
    
    /**
     * @brief Costruttore senza parametri, costruisce un'eccezione con un messaggio di default
     */
    public UtenteNonValidoException() {}
    
    /**
     * @brief Costruttore con messaggio personalizzato, costruisce un'eccezione con uno specifico messaggio di errore
     * 
     * @param[in] msg Il messaggio mostrato dall'eccezione
     */
    public UtenteNonValidoException(String msg) { 
        super(msg); 
    }
    
}
