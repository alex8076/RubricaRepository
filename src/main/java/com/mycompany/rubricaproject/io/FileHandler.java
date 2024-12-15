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
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Rubrica;
import com.mycompany.rubricaproject.eccezioni.FileNonTrovatoException;
import com.mycompany.rubricaproject.eccezioni.FormatoFileNonValidoException;
import java.io.IOException;

public interface FileHandler {
    
    /**
     * @param[in] fileName La directory del file su cui esportare i dati
     * @throws java.io.IOException
     * @brief Esporta i dati di una ribrica su un file esterno
     * 
     * @pre la rubrica contiene almeno un contatto
     * @pre la directory specificata in fileName esiste ed è accessibile
     * @post l'utente riceve una notifica di completamento dell'operazione
     */
    void esportaRubrica(String fileName) throws IOException;
    
    /**
     * @param[in] fileName La directory del file da cui importare i dati
     * @param[inout] rbr La rubrica su cui importare i dati
     * @throws java.io.IOException
     * @brief Importa i dati da un file esterno su una rubrica
     * 
     * I dati vengono letti da file e importati su rubrica,
     * se dei dati presenti nel file sono già presenti in rubrica (duplicati),
     * allora i dati già presenti vengono sovrascitti da quelli letti dal file
     * 
     * @pre l'utente ha a diposizione un file da importare
     * @post l'utente riceve una notifica di completamento dell'operazione
     * 
     * @throws FileNonTrovatoException Se il file non viene trovato
     */
    void importaRubrica(String fileName, Rubrica rbr) throws FileNonTrovatoException, FormatoFileNonValidoException, IOException;
}
