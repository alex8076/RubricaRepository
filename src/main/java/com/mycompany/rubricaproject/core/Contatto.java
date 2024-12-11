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


package com.mycompany.rubricaproject.core;

import com.mycompany.rubricaproject.eccezioni.MailNonCorrettaException;
import com.mycompany.rubricaproject.eccezioni.NumeroNonCorrettoException;
import com.mycompany.rubricaproject.eccezioni.UtenteNonValidoException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;



public class Contatto implements Comparable<Contatto> {
    
    private String nome;
    private String cognome;
    private Set<String> numeriTelefono; //indecisione sul fatto di usare una list
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
       if (!isValido(nome, cognome)) 
            throw new UtenteNonValidoException("Deve essere presente almeno un nome o un cognome");
        
        
        this.nome=nome;
        this.cognome=cognome;
        this.numeriTelefono= new TreeSet<>();
        this.indirizziMail= new TreeSet<>();
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
     * @see isValido()
     * 
     * 
     * @post Il nome del contatto è aggiornato.
     * 
     */
    public void setNome(String nome){
        if (!isValido(nome, this.cognome)) 
            throw new UtenteNonValidoException("Se il nome è vuoto, il cognome deve essere presente");
        
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
     * @see isValido()
     * 
     * @throws UtenteNonValidoException se nome è nullo e si setta cognome nullo
     */
     public void setCognome(String cognome){
        if (!isValido(this.nome, cognome)) 
            throw new UtenteNonValidoException("Se il cognome è vuoto, il nome deve essere presente");
        
        this.cognome=cognome;
    }
    
     
     
     
    /**
    * @brief Restituisce i numeri di telefono associati al contatto.
    * 
    * @return Un set contenente i numeri di telefono del contatto.
    */
     public Set<String> getNumeriTelefono(){
        return numeriTelefono;
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
       
        if (numero == null || !isNumeroValido(numero)) 
            throw new NumeroNonCorrettoException("Il numero di telefono non è valido.");
    
        if (!numeriTelefono.add(numero))
            throw new IllegalArgumentException("Il numero di telefono è già presente.");
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
    public void modificaNumero (String numeroNuovo, String numeroVecchio){
        if (!isNumeroValido(numeroNuovo)) 
            throw new NumeroNonCorrettoException("Il numero di telefono non è valido");
        

    
        if (!numeriTelefono.contains(numeroVecchio))
            throw new IllegalArgumentException("Il numero di telefono da sostituire non è stato trovato"); 
        
        numeriTelefono.remove(numeroVecchio);
        numeriTelefono.add(numeroNuovo);
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
         
        if (!numeriTelefono.contains(numero)) 
            throw new IllegalArgumentException("Il numero da rimuovere non è presente."); 
        
        
        numeriTelefono.remove(numero);
     }
     
    
     
    
     /**
     * @brief Verifica se un numero di telefono è valido.
     * 
     * @param[in] numero Numero di telefono da verificare.
     * @return `true` se il numero è valido, altrimenti `false`.
     * @throws NumeroNonCorrettoException Se il numero passato non è correttamente formattato
     */
    private boolean isNumeroValido (String numero){
        if (numero == null || numero.isEmpty()) 
            throw new NumeroNonCorrettoException("Il numero non può essere nullo o vuoto.");
        
        
        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i))) 
                throw new NumeroNonCorrettoException("Il numero deve contenere solo cifre.");
        }

        
        if (numero.length() != 10) 
            throw new NumeroNonCorrettoException("Il numero deve contenere esattamente 10 cifre.");
        

        return true; 
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
     private boolean isValido(String nome, String cognome){
         return (nome != null && !nome.isEmpty()) || (cognome != null && !cognome.isEmpty());
     }
     
     
     
     
      /**
     * @brief Restituisce l'insieme degli indirizzi email associati al contatto.
     * 
     * @invariant Il set restituito non contiene più di 3 indirizzi email.
     * 
     * @return Un insieme di indirizzi email.
     */
     public Set<String> getIndirizziMail (){
        return indirizziMail;
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
        if (!isMailValida(mail))
            throw new MailNonCorrettaException("L'indirizzo email non è valido.");
            
        indirizziMail.add(mail);
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
     public void modificaMail(String mailVecchia, String mailNuova){
        if (!isMailValida(mailNuova)) 
            throw new MailNonCorrettaException("La nuova email non è valida.");
        
        if (!indirizziMail.contains(mailVecchia)) 
            throw new IllegalArgumentException("La vecchia email non è presente.");
        
        
        indirizziMail.remove(mailVecchia);
        indirizziMail.add(mailNuova);
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
        if (!indirizziMail.contains(mail)) 
            throw new IllegalArgumentException("L'indirizzo email non è presente.");
       
        indirizziMail.remove(mail);
     }
     
     
     
     
      /**
     * @brief Verifica se un indirizzo email è valido.
     * 
     * @param[in] mail Indirizzo email da verificare.
     * @return `true` se l'indirizzo è valido, altrimenti `false`.
     * @throws MailNonCorrettaException Se il la mail passata non è correttamente formattata
     */
     private boolean isMailValida(String mail){
          return mail != null && mail.contains("@") && mail.contains(".");
     }
     
     
     
     
     /**
     * @brief Genera il codice hash del contatto.
     * 
     * @return Codice hash calcolato.
     */
     @Override
    public int hashCode(){
        /*int code = cognome == null ? 0 : cognome.hashCode();
        code = 31 * code + (nome == null ? 0 : nome.hashCode());
        code = 31 * code + numeriTelefono.hashCode();
        code = 31 * code + indirizziMail.hashCode();
        return code; */
        return Objects.hash(numeriTelefono, indirizziMail);
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
        
         for(String numero : this.numeriTelefono)
             if(c.numeriTelefono.contains(numero))
                 return true;
         
         for(String mail : this.indirizziMail)
             if(c.indirizziMail.contains(mail))
                 return true;
     
         return false;

     }         
}
