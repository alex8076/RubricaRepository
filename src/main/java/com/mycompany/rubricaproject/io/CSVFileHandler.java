/**
 * @file CSVFileHandler.java
 * @brief Classe per la gestione di operazioni I/O su file esterni in formato CSV
 * @see FileHandler
 * 
 * Questa classe implementa i metodi definiti nell'interfaccia FileHandler appositamente
 * per la tipologia di file esterni CSV.
 * 
 * @version 1.0
 * @date 2024-12-13
 * @author Giovanni Caldarelli
 */
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Contatto;
import com.mycompany.rubricaproject.core.Rubrica;
import com.mycompany.rubricaproject.eccezioni.FileNonTrovatoException;
import com.mycompany.rubricaproject.eccezioni.FormatoFileNonValidoException;
import java.io.*;
import java.util.*;

/**
 * Classe CSVFileHandler.
 * Implementa metodi per esportare e importare contatti da file CSV
 */
public class CSVFileHandler implements FileHandler {

    private Rubrica rubrica;

    /**
     * Costruttore della classe CSVFileHandler.
     * @param rubrica La rubrica da gestire.
     */
    public CSVFileHandler(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    /**
     * Esporta i contatti della rubrica in un file CSV.
     * @param fileName Il nome del file CSV in cui esportare i dati.
     * @throws IOException Se si verifica un errore durante l'operazione di scrittura.
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
     * Importa i contatti da un file CSV in una nuova rubrica.
     * @param fileName Il nome del file CSV da cui importare i dati.
     * @return Una nuova rubrica contenente i dati importati.
     * @throws FileNonTrovatoException Se il file non viene trovato.
     * @throws FormatoFileNonValidoException Se il file non è in formato CSV valido.
     * @throws IOException Se si verifica un errore durante l'operazione di lettura.
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
     * Valida l'intestazione del file CSV.
     * @param header Intestazione trovata nel file CSV.
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