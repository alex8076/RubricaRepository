/*
 * @file NumeroNonCorrettoException.java
 * @brief Eccezione non controllata che emerge qualora un numero inserito non sia correttamente formattato
 */
package com.mycompany.rubricaproject;

/**
 *
 * @author gae
 */
public class NumeroNonCorrettoException extends RuntimeException {
    
    public NumeroNonCorrettoException() {}
    
    public NumeroNonCorrettoException(String msg) { super(msg); }
    
}
