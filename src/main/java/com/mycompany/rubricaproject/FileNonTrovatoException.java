/*
 * @file FileNonTrovatoException.java
 * @brief Eccezione non controllata che emerge qualora un file non sia stato trovato
 */
package com.mycompany.rubricaproject;

/**
 *
 * @author gae
 */
public class FileNonTrovatoException extends RuntimeException {
 
    public FileNonTrovatoException() {}
    
    public FileNonTrovatoException(String msg) { super(msg); }
    
}
