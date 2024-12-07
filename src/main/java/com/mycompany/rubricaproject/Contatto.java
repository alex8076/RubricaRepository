package com.mycompany.rubricaproject;

import java.util.Set;

/**
 *
 * @file Contatto.java
 * @brief Rappresenta un contatto con informazioni personali e metodi di gestione.
 * 
 * Classe progettata per gestire informazioni personali di un contatto come nome, cognome,
 * numeri di telefono e indirizzi email. Implementa metodi per la verifica della validità,
 * aggiunta, modifica e rimozione di dati.
 * 
 * @author alessandro
 * @version 1.0
 * @date 2024-12-07
 */

public class Contatto implements Comparable<Contatto> {
    
    private String nome;
    private String cognome;
    private Set<String> numeriTelefono;
    private Set<String> indirizziMail;
    
    
    /**
     * @brief Costruttore della classe Contatto.
     * 
     * 
     * @post Un'istanza valida della classe Contatto è creata.
     * 
     * @param[in] nome Nome del contatto.
     * @param[in] cognome Cognome del contatto.
     * 
     * 
     * 
     */
    public Contatto(String nome, String cognome){
        
    }
    
    
    /**
     * @brief Restituisce il nome del contatto.
     * 
     * @return Nome del contatto.
     */
    public String getNome(){
        
    }
    
    
    /**
     * @brief Imposta il nome del contatto.
     * 
     * @param[in] nome Nuovo nome del contatto. 
     * 
     * 
     * @post Il nome del contatto è aggiornato.
     */
    public void setNome(String nome){
        
    }
    
    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @return Cognome del contatto.
     */
    public String getCognome(){
        
    }
    
    /**
     * @brief Imposta il cognome del contatto.
     * 
     * @param[in] cognome Nuovo cognome del contatto. 
     * 
     * 
     * @post Il cognome del contatto è aggiornato.
     */
     public void setCognome(String cognome){
        
    }
     
     /**
     * @brief Verifica se il contatto è valido.
     * 
     * Un contatto è considerato valido se ha almeno un nome o un cognome.
     * 
     * @return `true` se il contatto è valido, altrimenti `false`.
     */
     public boolean isValido(){
         
     }
     
     /**
     * @brief Genera il codice hash del contatto.
     * 
     * @return Codice hash calcolato.
     */
     @Override
     public int hashCode(){
         
     }
    
    /**
     * @brief Confronta questo contatto con un altro.
     * 
     * @param[in] o L'oggetto Contatto con cui confrontare.
     * @return Un valore negativo, zero o positivo se questo contatto è rispettivamente
     *         minore, uguale o maggiore dell'altro contatto.
     */
     @Override
     public int compareTo(Contatto o){
         
     }
    
     /**
     * @brief Verifica se questo contatto è uguale a un altro oggetto.
     * 
     * @param[in] obj Oggetto da confrontare.
     * @return `true` se gli oggetti sono uguali, altrimenti `false`.
     */
     @Override
     public boolean equals(Object obj){
         
     }

     
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
