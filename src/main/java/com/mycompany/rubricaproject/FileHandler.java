/**
 * @file FileHandler.java
 * @brief l'interfaccia specifica i metodi per gestire l'importazione/esportazione di contatti da/su file esterno
 */

public interface FileHandler {
    void esportaRubrica(String filename);
    Rubrica importaRubrica(String filename);
}