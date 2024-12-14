/**
 *
 * @file ValidatoreDati.java
 * @brief Classe che fornisce metodi per la validazione dei dati di un contatto, come nome, cognome, email e numero di telefono.
 * 
 * Questa classe contiene metodi per verificare la correttezza dei dati di un contatto, come il controllo della presenza di almeno un nome o cognome,
 * la validità di un indirizzo email e la formattazione corretta di un numero di telefono.
 * Vengono lanciate eccezioni specifiche quando i dati non sono validi.
 * 
 * @author Giovanni Caldarelli
 * @version 1.0
 * @date 2024-12-13
 */


package com.mycompany.rubricaproject.core;

import com.mycompany.rubricaproject.eccezioni.MailNonCorrettaException;
import com.mycompany.rubricaproject.eccezioni.NumeroNonCorrettoException;
import com.mycompany.rubricaproject.eccezioni.UtenteNonValidoException;



public class ValidatoreDati {
    
    
      /**
     * @brief Verifica se il contatto è valido.
     * 
     * Un contatto è considerato valido se ha almeno un nome o un cognome.
     * 
     * @param[in] nome Nome da verificare se presente.
     * @param[in] cognome Cognome da verificare se presente.
     * 
     *   
     * @throws UtenteNonValidoException Se l'utente ha nulli contemporaneamente sia nome che cognome
     */
     public static void isValido(String nome, String cognome){
         if ((nome == null || nome.isEmpty()) && (cognome == null || cognome.isEmpty())) 
            throw new UtenteNonValidoException("Deve essere presente almeno un nome o un cognome");
        
     }
     
    
    
     
     /**
     * @brief Verifica se un indirizzo email è valido.
     * L'indirizzo email è considerato valido se contiene il simbolo "@" e il punto "."
     * 
     * @param[in] mail Indirizzo email da verificare.
     * 
     * @throws MailNonCorrettaException Se il la mail passata non è correttamente formattata
     */
     public static void isMailValida(String mail){
        
         if (!(mail != null && mail.contains("@") && mail.contains(".")))
              throw new MailNonCorrettaException("L'indirizzo email non è valido.");
     }
     
   
     
     
     /**
     * @brief Verifica se un numero di telefono è valido.
     * Un numero di telefono è considerato valido se contiene esattamente 10 cifre e 
     * non include caratteri non numerici
     * 
     * @param[in] numero Numero di telefono da verificare.
     * 
     * @throws NumeroNonCorrettoException Se il numero passato non è correttamente formattato
     */
    public static void isNumeroValido (String numero){
        
        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i))) 
                throw new NumeroNonCorrettoException("Il numero deve contenere solo cifre.");
        }

        
        if (numero.length() != 10) 
            throw new NumeroNonCorrettoException("Il numero deve contenere esattamente 10 cifre.");
    }
    
    
}

