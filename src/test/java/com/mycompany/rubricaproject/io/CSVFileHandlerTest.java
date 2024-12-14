/**
 * @brief Classe di Test per la classe CSVFileHandler
 * 
 * questa classe testa tutti i metodi pulic definiti nella classe CSVFileHandler
 * 
 * @see CSVFileHandler
 * 
 * @author Giovanni Caldarelli
 * @date 2024-12-14
 */
package com.mycompany.rubricaproject.io;

import com.mycompany.rubricaproject.core.Contatto;
import com.mycompany.rubricaproject.core.Rubrica;
import java.io.File;
import java.io.PrintWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CSVFileHandlerTest {
    private CSVFileHandler csvFileHandler;
    private Rubrica rubrica;
    
    public CSVFileHandlerTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        rubrica = new Rubrica();
        rubrica.aggiungiContatto(new Contatto("Giovanni", "Caldarelli"));
        rubrica.aggiungiContatto(new Contatto("Mario", "Rossi"));
        csvFileHandler = new CSVFileHandler(rubrica);
    }
    
    
    
    @AfterEach
    public void tearDown() {
    }

    
    
    /**
     * Test of esportaRubrica method, of class CSVFileHandler.
     */
    @Test
    public void testEsportaRubrica() throws Exception {
        System.out.println("esportaRubrica");
        
        String fileName = "testRubrica.csv";
        csvFileHandler.esportaRubrica(fileName);

        File file = new File(fileName); //verifica che il file sia stato creato
        assertTrue(file.exists());
    }

    
    
    
    /**
     * Test of importaRubrica method, of class CSVFileHandler.
     */
    @Test
    public void testImportaRubrica() throws Exception {
        System.out.println("importaRubrica");
        
        String fileName = "testRubricaImport.csv";
        
        File file = new File(fileName);
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("NOME;COGNOME; TELEFONO_1; EMAIL_1");
            writer.println("Giovanni; Caldarelli; 123456789; giovanni@email.com");
            writer.println("Mario; Rossi; 987654321; mario@email.com");
        }


        Rubrica nuovaRubrica = new Rubrica();
        csvFileHandler.importaRubrica(fileName, nuovaRubrica);

        assertEquals(2, nuovaRubrica.getContatti().size());
    }
    
}
