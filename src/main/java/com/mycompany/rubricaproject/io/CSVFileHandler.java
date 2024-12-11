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
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Contatto;
import com.mycompany.rubricaproject.core.Rubrica;
import java.io.*;
import java.util.*;
import com.mycompany.rubricaproject.eccezioni.*;

public class CSVFileHandler implements FileHandler {
    
    private Rubrica rubrica;
    
    public CSVFileHandler(Rubrica rubrica) {
    this.rubrica = rubrica;
}
    /**
     * 
     * @param fileName
     * @throws java.io.IOException
     * @brief implementazione della funzione di esportazione per file CSV
     * 
     * @post il file in cui sono esportati i dati deve essere in formato CSV
     */
    @Override
    public void esportaRubrica(String fileName) throws IOException{
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            // Scrittura dell'intestazione
            pw.println("NOME; COGNOME; NUMERI DI TELEFONO; INDIRIZZI MAIL");

            // Iterazione sui contatti della rubrica
            for (Contatto contatto : rubrica.getContatti()) {
                pw.print(contatto.getNome() + ";");
                pw.print(contatto.getCognome() + ";");
                pw.print(String.join(",", contatto.getNumeriTelefono()) + ";");
                pw.println(String.join(",", contatto.getIndirizziMail()));
            }
            System.out.println("Rubrica esportata correttamente in formato CSV: " + fileName);
        } catch (IOException e) {
            System.err.println("Errore durante l'esportazione: " + e.getMessage());
            throw e;
        }
        
    }
    
    /**
     * @param fileName
     * @throws java.io.IOException
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
    public Rubrica importaRubrica(String fileName) throws FileNonTrovatoException, FormatoFileNonValidoException, IOException {
        Rubrica rubr = new Rubrica();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Verifica l'intestazione
            String header = br.readLine();
            if (header == null || !header.equals("Nome;Cognome;NumeriTelefono;IndirizziMail")) {
                throw new FormatoFileNonValidoException("Formato CSV non valido: intestazione non corretta.");
            }

            // Lettura delle righe dei contatti
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length < 2) {
                    throw new FormatoFileNonValidoException("Formato CSV non valido: riga incompleta.");
                }

                String nome = fields[0];
                String cognome = fields[1];
                Set<String> numeriTelefono = fields.length > 2 && !fields[2].isEmpty()
                        ? new HashSet<>(Arrays.asList(fields[2].split(","))) : new HashSet<>();
                Set<String> indirizziMail = fields.length > 3 && !fields[3].isEmpty()
                        ? new HashSet<>(Arrays.asList(fields[3].split(","))) : new HashSet<>();

                Contatto contatto = new Contatto(nome, cognome);
                numeriTelefono.forEach(contatto::aggiungiNumero);
                indirizziMail.forEach(contatto::aggiungiMail);

                rubr.aggiungiContatto(contatto);
            }

            System.out.println("Rubrica importata correttamente da file CSV: " + fileName);
        } catch (FileNotFoundException e) {
            throw new FileNonTrovatoException("File non trovato: " + fileName);
        } catch (IOException e) {
            throw e;
        }

        return rubr;
    }
}
               
    
    

