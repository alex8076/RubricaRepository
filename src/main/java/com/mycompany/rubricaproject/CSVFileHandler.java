/**
 * @file CSVFileHandler.java
 * @brief Classe per la gestione di operazione I/O su file esterno in formato CSV
 * @see FileHandler
 * 
 * Questa classe implementa i metodi definiti nell'interfaccia FileHandler appositamente
 * per la tipologia di file esterni CSV
 * 
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject;

public class CSVFileHandler implements FileHandler {
    
    /**
     * @brief implementazione della funzione di esportazione per file CSV
     * @param[in] fileName il nome del file da esportare
     * 
     * @post il file in cui sono esportati i dati deve essere in formato CSV
     */
    @Override
    public void esportaRubrica(String fileName) {
    
    }
    
    /**
     * @brief implementazione della funzione di importazione per file CSV
     * @param[in] fileName il nome del file da importare
     * @return la rubrica contenente i dati letti dal file
     * 
     * @pre il file deve essere in formato CSV
     * 
     * @throws FileNonTrovatoException Se il file non viene trovato
     * @throws FormatoFileNonValidoException Se il file non è in formato CSV
     */
    @Override
    public Rubrica importaRubrica(String fileName) {
        
    }
    
}
