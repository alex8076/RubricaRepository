/**
 * @file Controller.java
 * @brief Controller per la gestione dell'interfaccia View.
 * 
 * Questa classe implementa il controller dell'interfaccia grafica definita tramite un file FXML.
 * @see View.fxml
 * @version 1.0
 * @date 2024-12-07
 * @author Giovanni Caldarelli
 */
package com.mycompany.rubricaproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class Controller implements Initializable {

    /**
     * @brief Inizializza il controller.
     * 
     * Questo metodo viene invocato automaticamente da JavaFX al momento
     * del caricamento del file FXML. Può essere utilizzato per
     * eseguire operazioni di preparazione necessarie.
     * 
     * @param[in] url L'URL del file FXML caricato .
     * @param[in] rb Il bundle delle risorse associato.
     * @pre Il file FXML e le risorse devono essere caricati correttamente.
     * @post I componenti dell'interfaccia grafica sono pronti per l'uso.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
