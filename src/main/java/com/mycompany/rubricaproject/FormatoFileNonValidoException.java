/*
 * @file FormatoFileNonValidoException.java
 * @brief Eccezione non controllata che emerge qualora il formato di un file non sia valido
 */
package com.mycompany.rubricaproject;

/**
 *
 * @author gae
 */
public class FormatoFileNonValidoException extends RuntimeException {
    
    public FormatoFileNonValidoException() {}
    
    public FormatoFileNonValidoException(String msg) { super(msg); }
    
}
