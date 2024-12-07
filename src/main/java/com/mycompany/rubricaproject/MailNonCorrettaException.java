/*
 * @file MailNonCorrettaException.java
 * @brief Eccezione non controllata che emerge qualora la mail inserita non sia correttamente formattata
 */
package com.mycompany.rubricaproject;

/**
 *
 * @author gae
 */
public class MailNonCorrettaException extends RuntimeException {
    
    public MailNonCorrettaException() {}
    
    public MailNonCorrettaException(String msg) { super(msg); }
    
}
