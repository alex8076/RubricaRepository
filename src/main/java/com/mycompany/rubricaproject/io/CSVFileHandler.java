/**
 * @file CSVFileHandler.java
 * @brief Classe per la gestione di operazioni I/O su file esterni in formato CSV
 * @see FileHandler
 * 
 * Questa classe implementa i metodi definiti nell'interfaccia FileHandler appositamente
 * per la tipologia di file esterni CSV.
 * 
 * @author gae
 * @date 2024-12-7
 */
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Contatto;
import com.mycompany.rubricaproject.core.Rubrica;
import java.io.*;
import java.util.*;
import com.mycompany.rubricaproject.eccezioni.*;
import java.util.stream.Collectors;

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
     * 
     * @post Il file risultante conterrà i contatti formattati in righe CSV.
     */
   @Override
        public void esportaRubrica(String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
        // Scrittura dell'intestazione
        pw.println("NOME;COGNOME;TELEFONO_1;TELEFONO_2;TELEFONO_3;EMAIL_1;EMAIL_2;EMAIL_3");

        // Iterazione sui contatti della rubrica
        for (Contatto contatto : rubrica.getContatti()) {
            // Ottieni nome e cognome
            String nome = contatto.getNome() != null ? contatto.getNome() : "";
            String cognome = contatto.getCognome() != null ? contatto.getCognome() : "";

            // Gestione dei numeri di telefono
            String[] numeriTelefono = {"", "", ""};
            int i = 0;
            for (String numero : contatto.getNumeriTelefono()) {
                if (i < 3) {
                    numeriTelefono[i] = numero != null ? numero : "";
                    i++;
                } else {
                    break; // Esci dal ciclo se ci sono più di 3 numeri
                }
            }

            // Gestione degli indirizzi email
            String[] indirizziMail = {"", "", ""};
            i = 0;
            for (String mail : contatto.getIndirizziMail()) {
                if (i < 3) {
                    indirizziMail[i] = mail != null ? mail : "";
                    i++;
                } else {
                    break; // Esci dal ciclo se ci sono più di 3 email
                }
            }

            // Scrivi i dati del contatto nel file
            pw.println(String.join(";", nome, cognome,
                    numeriTelefono[0], numeriTelefono[1], numeriTelefono[2],
                    indirizziMail[0], indirizziMail[1], indirizziMail[2]));
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
     * 
     * @pre Il file deve avere un formato CSV valido con intestazioni corrette.
     */
@Override
public Rubrica importaRubrica(String fileName) throws FileNonTrovatoException, FormatoFileNonValidoException, IOException {
    Rubrica rubr = new Rubrica();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        // Leggi l'intestazione del file
        String header = br.readLine();
        System.out.println("Intestazione trovata: " + header);

        // Verifica che l'intestazione sia valida
        if (header == null || !isHeaderValid(header)) {
            throw new FormatoFileNonValidoException("Formato CSV non valido: intestazione non corretta.");
        }

        // Lettura delle righe dei contatti
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("Riga letta: " + line); // Debug: mostra la riga letta
            String[] fields = line.split(";");
            if (fields.length < 2) {
                System.out.println("Riga ignorata (incompleta): " + line);
                continue;
            }

            String nome = fields[0].trim();
            String cognome = fields[1].trim();

            Set<String> numeriTelefono = fields.length > 2 && !fields[2].isEmpty()
                    ? new HashSet<>(Arrays.asList(fields[2].split(",")))
                    : new HashSet<>();

            Set<String> indirizziMail = fields.length > 3 && !fields[3].isEmpty()
                    ? new HashSet<>(Arrays.asList(fields[3].split(",")))
                    : new HashSet<>();

            numeriTelefono.removeIf(numero -> numero == null || numero.equalsIgnoreCase("null") || numero.trim().isEmpty());
            indirizziMail.removeIf(mail -> mail == null || mail.equalsIgnoreCase("null") || mail.trim().isEmpty());

            Contatto contatto = new Contatto(nome, cognome);

            int numeroIndex = 0;
            for (String numero : numeriTelefono) {
                contatto.aggiungiNumero(numero, numeroIndex++);
            }

            int mailIndex = 0;
            for (String mail : indirizziMail) {
                contatto.aggiungiMail(mail, mailIndex++);
            }

            rubr.aggiungiContatto(contatto);
            System.out.println("Contatto aggiunto: " + contatto); // Debug: mostra il contatto aggiunto
        }

        System.out.println("Rubrica importata correttamente da file CSV: " + fileName);
    } catch (FileNotFoundException e) {
        throw new FileNonTrovatoException("File non trovato: " + fileName);
    } catch (IOException e) {
        throw e;
    }
    
    System.out.println("Contatti importati nella rubrica:");
for (Contatto contatto : rubr.getContatti()) {
    System.out.println(contatto); // Stampa ogni contatto importato
}
    return rubr;
}

/**
 * Valida l'intestazione del file CSV.
 * Controlla che contenga tutte le parole chiave richieste, ignorando ordine, spazi e maiuscole/minuscole.
 *
 * @param header Intestazione trovata nel file CSV.
 * @return true se valida, false altrimenti.
 */
private boolean isHeaderValid(String header) {
    // Parole chiave attese nell'intestazione
    String[] expectedKeywords = {"NOME", "COGNOME", "NUMERI DI TELEFONO", "INDIRIZZI MAIL"};

    // Normalizza l'intestazione: rimuove spazi extra e converte in minuscolo
    String normalizedHeader = header.replaceAll("\\s+", "").toLowerCase();

    // Verifica che tutte le parole chiave attese siano presenti
    for (String keyword : expectedKeywords) {
        if (!normalizedHeader.contains(keyword.replaceAll("\\s+", "").toLowerCase())) {
            return false;
        }
    }

    return true;
}
}