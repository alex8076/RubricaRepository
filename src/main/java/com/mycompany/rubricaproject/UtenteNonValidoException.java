/*
 * @file UtenteNonValidoException.java
 * @brief Eccezione non controllata che emerge qualora un utente inserito non sia valido (ossia non abbia almeno un nome o un cognome)
 */
package com.mycompany.rubricaproject;

/**
 *
 * @author gae
 */
public class UtenteNonValidoException extends RuntimeException {
    
    public UtenteNonValidoException() {}
    
    public UtenteNonValidoException(String msg) { super(msg); }
    
}
