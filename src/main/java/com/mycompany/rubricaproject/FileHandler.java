/**
 * @file FileHandler.java
 * @brief Interfaccia per la gestione di operazioni di I/O su file esterno
 * @see Rubrica
 * 
 * Questa interfaccia definisce i metodi necessari per esportare e importare
 * i dati della rubrica da/su un file esterno.
 * Può essere implementata per fornire diverse strategie di gestione dei file, ad esempio file CSV (ma anche altri formati)
 * 
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject;

public interface FileHandler {
    
    /**
     * @brief Esporta i dati di una ribrica su un file esterno
     * @param[in] fileName Il nome del file su cui esportare la rubrica
     * 
     * @pre la rubrica contiene almeno un contatto
     * @pre la directory specificata in fileName esiste ed è accessibile
     * @post l'utente riceve una notifica di completamento dell'operazione
     */
    void esportaRubrica(String fileName);
    
    /**
     * @brief Importa i dati da un file esterno su una rubrica
     * @param[in] fileName Il nome del file da cui importare la rubrica
     * @return Una rubrica contenente i dati letti dal file esterno
     * 
     * @pre l'utente ha a diposizione un file da importare
     * @post l'utente riceve una notifica di completamento dell'operazione
     */
    Rubrica importaRubrica(String fileName);
}
