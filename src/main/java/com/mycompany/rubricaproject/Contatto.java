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


package com.mycompany.rubricaproject;

import java.util.Set;



public class Contatto implements Comparable<Contatto> {
    
    private String nome;
    private String cognome;
    private Set<String> numeriTelefono;
    private Set<String> indirizziMail;
    
    
    /**
     * @brief Costruttore della classe Contatto.
     * 
     * 
     * @post Un'istanza valida della classe Contatto è creata, se i dati passati sono validi.
     * @see isValido()
     * 
     * @param[in] nome Nome del contatto.
     * @param[in] cognome Cognome del contatto.
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
     * @param[in] nome Nuovo nome del contatto, ammesso che l'utente aggiornato risulti valido.
     * @see isValido()
     * 
     * 
     * @post Il nome del contatto è aggiornato.
     * 
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
     * @post Il cognome del contatto è aggiornato, ammesso che l'utente aggiornato risulti valido.
     * @see isValido()
     * 
     * @throws UtenteNonValidoException se nomer è nullo e si setta cognome nullo
     */
     public void setCognome(String cognome){
        
    }
    
     
     
     public Set<String> getNumeriDiTelefono(){
         
     }
     
     
     
     /**
     * @brief Aggiunge un numero di telefono al contatto.
     * 
     * Consente di aggiungere un nuovo numero di telefono alla lista esistente,
     *          rispettando il limite massimo di tre numeri.
     * 
     * @param[in] numero Numero di telefono da aggiungere.
     * 
     * 
     * @post Il contatto avrà un nuovo numero di telefono
     */
     public void aggiungiNumero (String numero) {
         
     }
     
     /**
     * @brief Modifica un numero di telefono del contatto.
     * 
     * Sostituisce un numero esistente con uno nuovo.
     * 
     * @param[in] numero Nuovo numero di telefono.
     * 
     * 
     * @post Il numero di telefono selezionato è stato aggiornato.
     */
     public void modificaNumero (String numero){
         
     }
     
     
     
     
      /**
     * @brief Rimuove un numero di telefono dal contatto.
     * 
     * @param[in] numero Numero di telefono da rimuovere.
     * 
     * 
     * @post La lista dei numeri di telefono è aggiornata.
     */
     public void rimuoviNumero (String numero){
         
     }
     
     
     /**
     * @brief Verifica se un numero di telefono è valido.
     * 
     * @param[in] numero Numero di telefono da verificare.
     * @return `true` se il numero è valido, altrimenti `false`.
     * @throws NumeroNonCorrettoException Se il numero passato non è correttamente formattato
     */
     public boolean isNumeroValido (String numero){
         
     }
     
     
      
     /**
     * @brief Verifica se il contatto è valido.
     * 
     * Un contatto è considerato valido se ha almeno un nome o un cognome.
     * 
     * @return `true` se il contatto è valido, altrimenti `false`.
     * 
     * @throws UtenteNonValidoException Se l'utente ha nulli contemporaneamente sia nome che cognome
     */
     public boolean isValido(){
         
     }
     
     
      /**
     * @brief Restituisce l'insieme degli indirizzi email associati al contatto.
     * 
     * @invariant Il set restituito non contiene più di 3 indirizzi email.
     * 
     * @return Un insieme di indirizzi email.
     */
     public Set<String> getIndirizziMail (){
         
     }
     
     
      /**
     * @brief Aggiunge un indirizzo email al contatto.
     * 
     * Consente di aggiungere un nuovo indirizzo email alla lista esistente,
     *          rispettando il limite massimo di tre indirizzi.
     * 
     * @param[in] mail Indirizzo email da aggiungere.
     * 
     * 
     * @post La lista degli indirizzi email è aggiornata.
     */
     public void aggiungiMail (String mail){
         
     }
     
     
     
     /**
     * @brief Modifica un indirizzo email del contatto.
     * 
     * Sostituisce un indirizzo esistente con uno nuovo.
     * 
     * @param[in] mail Nuovo indirizzo email.
     * 
     * 
     * @post L'indirizzo email specificato è stato aggiornato.
     */
     public void modificaMail(String mail){
         
     }
     
     
     /**
     * @brief Rimuove un indirizzo email dal contatto.
     * 
     * @param[in] mail Indirizzo email da rimuovere.
     * 
     * 
     * @post La lista degli indirizzi email è aggiornata.
     */
     
     public void rimuoviMail (String mail){
         
     }
     
      /**
     * @brief Verifica se un indirizzo email è valido.
     * 
     * @param[in] mail Indirizzo email da verificare.
     * @return `true` se l'indirizzo è valido, altrimenti `false`.
     * @throws MailNonCorrettaException Se il la mail passata non è correttamente formattata
     */
     public boolean isMailValido(String mail){
         
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
