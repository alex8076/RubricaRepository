/**
 * @file Rubrica.java
 * @brief Classe per la gestione di una rubrica di contatti.
 *
 * La classe gestisce un insieme di contatti, fornendo metodi per aggiungere, 
 * rimuovere e ottenere tutti i contatti presenti. Ogni contatto è unico.
 * Utilizza un TreeSet per garantire l'unicità dei contatti.
 *
 * @version 1.0
 * @date 2024-12-07
 * @author Giovanni Caldarelli
 */
package com.mycompany.rubricaproject.core;

import com.mycompany.rubricaproject.eccezioni.ContattoDuplicatoException;
import java.util.TreeSet;
import java.util.Set;




public class Rubrica {
     private Set<Contatto> contatti;
     
     
     /**
     * @brief Costruttore della classe rubrica.
     * 
     * @post Un'istanza valida della classe Rubrica è creata.
     * 
     */
     public Rubrica() {
         this.contatti=new TreeSet<>();
     }
     
     
     /**
     * @brief Permette di accedere alla lista contatti.
     * 
     * @return La lista dei contatti.
     */
     public Set<Contatto> getContatti() {
         return contatti;
        
    }
     
     
    /**
     * @brief Aggiunge un contatto alla rubrica.
     * @see Contatto
     * 
     * @param[in] c il contatto da aggiungere. 
     *
     * 
     * @post Se il contatto non era già presente, viene aggiunto alla rubrica.
     * 
     * @throws ContattoDuplicatoException Se si prova ad aggiungere un contatto già presente
     */
    public void aggiungiContatto(Contatto c) {
        if(!contatti.add(c)){
        throw new ContattoDuplicatoException ("Contatto già presente in rubrica:"+c);}
        
    }
    
    /**
     * @brief Rimuove un contatto dalla rubrica.
     * @see Contatto
     * 
     * @param[in] c il contatto da rimuovere.
     * @post Se il contatto era presente, viene rimosso dalla rubrica.
     */
    public void rimuoviContatto(Contatto c) {
         if (!contatti.contains(contatti)) 
            throw new IllegalArgumentException("Il contatto da rimuovere non è presente."); 
        contatti.remove(c);
        
    }
    
    
    /**
     * @brief Cerca e restituisce i contatti della rubrica che hanno nome o cognome uguale al parametro "ricercaStr".
     * @see Contatto
     * 
     * @return un oggetto `Set` contenente i contatti che corrispondono al criterio di ricerca.
     *         Se nessun contatto soddisfa il criterio, restituisce un insieme vuoto.
     * @pre Il contatto che l'utente desidera cercare è presente nella rubrica.
     * @post Viene mostrata la lista di contatti corrispondente alla sottostringa inserita.
     * @invariant contatti.
     */
    public Set<Contatto> CercaContatti(String ricercaStr){
        Set<Contatto> risultati= new TreeSet<>();
        for (Contatto c: contatti){
            if(c.getNome().contains(ricercaStr)|| c.getCognome().contains(ricercaStr)){
                risultati.add(c);
            }
        }
        return risultati;
    }
    
}
