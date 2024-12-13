/**
 *
 * @file Contatto.java
 * @brief Rappresenta un contatto con informazioni personali e metodi di gestione.
 * 
 * Classe progettata per gestire informazioni personali di un contatto come nome, cognome,
 * numeri di telefono e indirizzi email. Implementa metodi di aggiunta, modifica e rimozione di dati.
 * 
 * @author alessandro
 * @version 1.0
 * @date 2024-12-07
 */
//

package com.mycompany.rubricaproject.core;

import java.util.Arrays;
import java.util.Objects;



public class Contatto implements Comparable<Contatto> {
    
    private String nome;
    private String cognome;
    private String[] numeriTelefono; 
    private String[] indirizziMail;
    
    
    
    
    /**
     * @brief Costruttore della classe Contatto.
     * 
     * 
     * @post Un'istanza valida della classe Contatto è creata, se i dati passati sono validi.
     * @see ValidatoreDati
     * 
     * @param[in] nome Nome del contatto.
     * @param[in] cognome Cognome del contatto.
     * 
     */
    public Contatto(String nome, String cognome){
       ValidatoreDati.isValido(nome, cognome);
          
        this.nome=nome;
        this.cognome=cognome;
        this.numeriTelefono= new String[3];
        this.indirizziMail= new String[3];
    }
    
    
    
    
    /**
     * @brief Restituisce il nome del contatto.
     * 
     * @return Nome del contatto.
     */
    public String getNome(){
        return nome;
    }
    
    
    
    
    /**
     * @brief Imposta il nome del contatto.
     * 
     * @param[in] nome Nuovo nome del contatto, ammesso che l'utente aggiornato risulti valido.
     * @see ValidatoreDati
     * 
     * 
     * @post Il nome del contatto è aggiornato.
     * 
     */
    public void setNome(String nome){
        ValidatoreDati.isValido(nome, this.cognome); 
           
        
        this.nome=nome;
    }
    
    
    
    
    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @return Cognome del contatto.
     */
    public String getCognome(){
        return cognome;
    }
    
    
    
    
    /**
     * @brief Imposta il cognome del contatto.
     * 
     * @param[in] cognome Nuovo cognome del contatto. 
     * 
     * 
     * @post Il cognome del contatto è aggiornato, ammesso che l'utente aggiornato risulti valido.
     * @see VAlidatoreDati
     * 
     *
     */
     public void setCognome(String cognome){
        ValidatoreDati.isValido(this.nome, cognome);
            
        this.cognome=cognome;
    }
    
     
     
     
    /**
    * @brief Restituisce i numeri di telefono associati al contatto.
    * 
    * @return Un set contenente i numeri di telefono del contatto.
    */
     public String[] getNumeriTelefono(){
        return numeriTelefono;
     }
     
     
     
     
     /**
     * @brief Aggiunge un numero di telefono al contatto.
     * 
     * Consente di aggiungere un nuovo numero di telefono alla lista esistente,
     * rispettando il limite massimo di tre numeri.
     * 
     * @param[in] numero Numero di telefono da aggiungere.
     * @param[in] index Indice che corrisponde alla posizione del numero nell'array.
     * 
     * @post Il contatto avrà un nuovo numero di telefono
     */
     public void aggiungiNumero (String numero, int index) {
       
        ValidatoreDati.isNumeroValido(numero); 

    
        for (String num: this.numeriTelefono) {
            if (num != null && num.equals(numero))
                throw new IllegalArgumentException("Il numero di telefono è già presente.");
        }
        
        this.numeriTelefono[index] = numero;
     }
     
     
     
     
     /**
     * @brief Modifica un numero di telefono del contatto.
     * 
     * Sostituisce un numero esistente con uno nuovo.
     * 
     * @param[in] numeroNuovo Nuovo numero di telefono.
     * @param[in] index Indice che corrisponde alla posizione del numero nell'array.
     * 
     * @post Il numero di telefono selezionato è stato aggiornato.
     */
    public void modificaNumero (String numeroNuovo, int index){
        
        ValidatoreDati.isNumeroValido(numeroNuovo);
            
        
        for (String num: this.numeriTelefono) {
            if (num != null && num.equals(numeroNuovo)) {
                System.out.println(num);
                throw new IllegalArgumentException("Il numero di telefono da sostituire è già presente");
            }
        }
        
        this.numeriTelefono[index] = numeroNuovo;
    }
     
     
     
     
      /**
     * @brief Rimuove un numero di telefono dal contatto.
     * 
     * @param[in] index Indice che corrisponde alla posizione del numero nell'array.
     * 
     * 
     * @post La lista dei numeri di telefono è aggiornata.
     */
    public void rimuoviNumero (int index){
          this.numeriTelefono[index] = null;
    }
     
    
 
    
      /**
     * @brief Restituisce l'insieme degli indirizzi email associati al contatto.
     * 
     * @invariant Il set restituito non contiene più di 3 indirizzi email.
     * 
     * @return Un insieme di indirizzi email.
     */
     public String[] getIndirizziMail (){
        return indirizziMail;
     }
     
     
     
     
      /**
     * @brief Aggiunge un indirizzo email al contatto.
     * 
     * Consente di aggiungere un nuovo indirizzo email alla lista esistente,
     *          rispettando il limite massimo di tre indirizzi.
     * 
     * @param[in] mail Indirizzo email da aggiungere.
     * @param[in] index Indice che corrisponde alla posizione della mail nell'array.
     * 
     * @post La lista degli indirizzi email è aggiornata.
     */
     public void aggiungiMail (String mail, int index){
        ValidatoreDati.isMailValida(mail);
        
        for (String m: this.indirizziMail)
            if (m != null && m.equals(mail))
                throw new IllegalArgumentException("La mail è già presente");
        
        this.indirizziMail[index] = mail;
     }
     
     
     
     
     /**
     * @brief Modifica un indirizzo email del contatto.
     * 
     * Sostituisce un indirizzo esistente con uno nuovo.
     * 
     * @param[in] mail Nuovo indirizzo email.
     * @param[in] index Indice che corrisponde alla posizione della mail nell'array.
     * 
     * @post L'indirizzo email specificato è stato aggiornato.
     */
     public void modificaMail(String mailNuova, int index){
        ValidatoreDati.isMailValida(mailNuova);
            
        
        for (String m: this.indirizziMail)
            if (m != null && m.equals(mailNuova))
                throw new IllegalArgumentException("La mail inserita è già presente");
        
        this.indirizziMail[index] = mailNuova;
     }
     
     
     
     
     /**
     * @brief Rimuove un indirizzo email dal contatto.
     * 
     * @param[in] index Indice che corrisponde alla posizione della mail nell'array.
     * 
     * 
     * @post La lista degli indirizzi email è aggiornata.
     */
     
     public void rimuoviMail (int index){
        this.indirizziMail[index] = null;
     }
     
     
     
     
     /**
     * @brief Genera il codice hash del contatto.
     * 
     * @return Codice hash calcolato.
     */
     @Override
     public int hashCode(){
        int result = 1;

        // Aggiungi hash per numeri di telefono (ignora null)
        if (numeriTelefono != null) {
            for (String numero : numeriTelefono) {
                if (numero != null) {
                    result = 31 * result + numero.hashCode();
                }
            }
        }

        // Aggiungi hash per indirizzi email (ignora null)
        if (indirizziMail != null) {
            for (String mail : indirizziMail) {
                if (mail != null) {
                    result = 31 * result + mail.hashCode();
                }
            }
        }

        return result;
      }
    
     
     
     
    /**
     * @brief Confronta questo contatto con un altro.
     * 
     * @param[in] o L'oggetto Contatto con cui confrontare.
     * @return Un valore negativo, zero o positivo se questo contatto è rispettivamente
     *         minore, uguale o maggiore dell'altro contatto.
     */
     @Override
     public int compareTo(Contatto c){
         
        int tmp = this.cognome.compareTo(c.cognome);
        if (tmp != 0) {
        return tmp;
        }
    
        return this.nome.compareTo(c.nome);
    }
    
     
    
     
     /**
     * @brief Verifica se questo contatto è uguale a un altro oggetto.
     * 
     * @param[in] obj Oggetto da confrontare.
     * @return `true` se gli oggetti sono uguali, altrimenti `false`.
     */
     @Override
     public boolean equals(Object obj){
         if(obj==null) return false;
         if(this==obj) return true;
         if(this.getClass()!=obj.getClass()) return false;
         
         Contatto c = (Contatto) obj;
        
         for(String numero1 : this.numeriTelefono)
             for (String numero2 : c.getNumeriTelefono())
                if (numero1 != null && numero2 != null)
                    if (numero1.equals(numero2))
                        return true;
         
         for(String mail1 : this.indirizziMail)
             for (String mail2: c.getIndirizziMail())
                if (mail1 != null && mail2 != null)
                    if(mail1.equals(mail2))
                        return true;
     
         return false;

     }         
}