/**
 * @file CSVFileHandler.java
 * @brief Classe per la gestione di operazioni I/O su file esterni in formato CSV
 * @see FileHandler
 * 
 * Questa classe implementa l'interfaccia FileHandler e fornisce metodi specifici 
 * per esportare i contatti in formato CSV e importare contatti da file CSV.
 * 
 * @version 1.0
 * @date 2024-12-13
 * @author Alessandro Auricchio
 */
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Contatto;
import com.mycompany.rubricaproject.core.Rubrica;
import com.mycompany.rubricaproject.eccezioni.FileNonTrovatoException;
import com.mycompany.rubricaproject.eccezioni.FormatoFileNonValidoException;
import java.io.*;
import java.util.*;


public class CSVFileHandler implements FileHandler {

    private Rubrica rubrica;

    /**
     * @brief Costruttore della classe CSVFileHandler.
     * @param rubrica La rubrica da gestire.
     */
    public CSVFileHandler(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    /**
     * @brief Esporta i contatti della rubrica in un file CSV.
     * 
     * Il file CSV include una riga di intestazione e una riga per ciascun contatto, 
     * con i 3 campi dei numeri di telefono e i 3 campi degli indirizzi email.
     * 
     * @param[in] fileName Il nome del file CSV in cui esportare i dati.
     * @throws IOException Se si verifica un errore durante l'operazione di scrittura.
     * 
     * @post Il file conterrà tutti i contatti della rubrica in formato CSV.
     */
    @Override
    public void esportaRubrica(String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            // Scrittura dell'intestazione del file CSV
            pw.println("NOME;COGNOME;TELEFONO_1;TELEFONO_2;TELEFONO_3;EMAIL_1;EMAIL_2;EMAIL_3");

            // Iterazione sui contatti della rubrica
            for (Contatto contatto : rubrica.getContatti()) {
                String nome = contatto.getNome() != null ? contatto.getNome() : "";
                String cognome = contatto.getCognome() != null ? contatto.getCognome() : "";

                String[] numeriTelefono = contatto.getNumeriTelefono();
                String[] indirizziMail = contatto.getIndirizziMail();

                // Scrittura dei dati del contatto, evitando "null"
                pw.println(String.join(";",
                        nome, cognome,
                        numeriTelefono.length > 0 && numeriTelefono[0] != null ? numeriTelefono[0] : "",
                        numeriTelefono.length > 1 && numeriTelefono[1] != null ? numeriTelefono[1] : "",
                        numeriTelefono.length > 2 && numeriTelefono[2] != null ? numeriTelefono[2] : "",
                        indirizziMail.length > 0 && indirizziMail[0] != null ? indirizziMail[0] : "",
                        indirizziMail.length > 1 && indirizziMail[1] != null ? indirizziMail[1] : "",
                        indirizziMail.length > 2 && indirizziMail[2] != null ? indirizziMail[2] : ""));
            }
        }
    }

    
    /**
     * @brief Importa la rubrica da un file CSV.
     * 
     * @briefLegge un file CSV contenente contatti e li aggiunge a una rubrica.
     * Gestisce eventuali eccezioni legate a formati non validi o file mancanti.
     * 
     * I contatti del file vengono aggiunti a quelli già presenti nell'applicazione, senza importare i duplicati.
     * Inoltre verranno aggiunti i campi mancanti all'interno della rubrica se vi sono campi aggiuntivi nel file.
     * 
     * 
     * 
     * @param[in] fileName Il nome del file CSV da cui importare i dati.
     * @param[out] rubr La rubrica a cui aggiungere i contatti importati.
     * @return Una rubrica contenente i contatti importati.
     * @throws FileNonTrovatoException Se il file non viene trovato.
     * @throws FormatoFileNonValidoException Se il file non è in formato CSV.
     * @throws IOException Se si verifica un errore durante l'operazione di lettura.
     * 
     * @post La rubrica conterrà i contatti importati dal file.
     */
    
    @Override
    public void importaRubrica(String fileName, Rubrica rubr) throws FileNonTrovatoException, FormatoFileNonValidoException, IOException {
        //Rubrica rubr = new Rubrica();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Lettura dell'intestazione del file
            String header = br.readLine();
            if (header == null || !isHeaderValid(header)) {
                throw new FormatoFileNonValidoException("Formato CSV non valido: intestazione non corretta.");
            }

            // Determina il delimitatore (virgola o punto e virgola)
            String delimitatore = header.contains(",") ? "," : ";";

            // Lettura delle righe del file
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimitatore);

                // Rimuove eventuali virgolette dai campi
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].replaceAll("^\"|\"$", "").trim();
                }

                String nome = fields.length > 0 ? fields[0].trim() : "";
                String cognome = fields.length > 1 ? fields[1].trim() : "";

                if (nome.isEmpty() && cognome.isEmpty()) {
                    System.err.println("Contatto ignorato: manca nome e cognome.");
                    continue;
                }

                Contatto contatto = new Contatto(nome, cognome);

                // Aggiunta dei numeri di telefono con validazione
                for (int i = 2; i < Math.min(fields.length, 5); i++) {
                    String numero = fields[i].trim();
                    if (!numero.isEmpty()) {
                        try {
                            contatto.aggiungiNumero(numero, i - 2);
                        } catch (Exception e) {
                            System.err.println("Numero ignorato: " + numero);
                        }
                    }
                }

                // Aggiunta degli indirizzi email con validazione
                for (int i = 5; i < Math.min(fields.length, 8); i++) {
                    String email = fields[i].trim();
                    if (!email.isEmpty()) {
                        try {
                            contatto.aggiungiMail(email, i - 5);
                        } catch (Exception e) {
                            System.err.println("Email ignorata: " + email);
                        }
                    }
                }
                
                if (!rubr.getContatti().contains(contatto))
                    rubr.aggiungiContatto(contatto);
                else {
                    rubr.modificaContatto(contatto);
                }
                            
            }
        } catch (FileNotFoundException e) {
            throw new FileNonTrovatoException("File non trovato: " + fileName);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * @brief Valida l'intestazione del file CSV.
     * 
     * Controlla che l'intestazione del file CSV contenga i campi obbligatori richiesti.
     * 
     * @param[in] header L'intestazione trovata nel file CSV.
     * @return true se valida, false altrimenti.
     */
    private boolean isHeaderValid(String header) {
        String[] expectedKeywords = {"NOME", "COGNOME", "TELEFONO_1", "EMAIL_1"};
        for (String keyword : expectedKeywords) {
            if (!header.toUpperCase().contains(keyword)) {
                return false;
            }
        }
        return true;
    }
}