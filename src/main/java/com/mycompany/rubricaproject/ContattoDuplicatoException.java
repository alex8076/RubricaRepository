/*
 * @file ContattoDuplicatoException.java
 * @brief Eccezione non controllata che emerge qualora vi siano contatti duplicati
 */
package com.mycompany.rubricaproject;

/**
 *
 * @author gae
 */
public class ContattoDuplicatoException extends RuntimeException {
    
    public ContattoDuplicatoException() {}
    
    public ContattoDuplicatoException(String msg) { super(msg); }
    
}
