/**
 * @file Controller.java
 * @brief Controller per la gestione dell'interfaccia View.
 * 
 * Questa classe implementa il controller dell'interfaccia grafica definita tramite un file FXML.
 * @see View.fxml
 * @version 2.0
 * @date 2024-12-10
 * @author Gaetano Donnarumma
 */
package com.mycompany.rubricaproject.gui;

import com.mycompany.rubricaproject.core.Contatto;
import com.mycompany.rubricaproject.core.Rubrica;
import com.mycompany.rubricaproject.io.CSVFileHandler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Controller implements Initializable {

    // Creo un'istanza di rubrica in modo da poter invocare i metodi che ci consentano di gestirla e modificarla
    private Rubrica rubrica;
    // Creo un'istanza di CSVFileHandler per accedere ai metodi necessari all'I/O su file CSV esterno
    private CSVFileHandler fh;
    // Mappo ogni contatto con la relativa scheda contatto ad esso asscociata
    private Map<Contatto, VBox> mappaContatti;
    
    @FXML
    private Button addBtn;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCognome;
    @FXML
    private TextField tfTelefono1;
    @FXML
    private TextField tfTelefono2;
    @FXML
    private TextField tfTelefono3;
    @FXML
    private TextField tfEmail1;
    @FXML
    private TextField tfEmail2;
    @FXML
    private TextField tfEmail3;
    @FXML
    private Button cancelBtn;
    @FXML
    private VBox contactContainer;
    @FXML
    private VBox inputPane;
    @FXML
    private HBox dashboard;
    @FXML
    private Button newContactBtn;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button searchBtn;
    @FXML
    private Button importaBtn;
    @FXML
    private Button esportaBtn;
    
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
     * 
     * @see Rubrica
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica();
        this.mappaContatti = new HashMap<>();
        inputPane.setVisible(false);
        
        // Adatto la larghezza del pannello che mostra i contatti inseriti in base 
        // al fatto che il pannello di inserimento di un nuovo contatto sia visibile o meno
        contactContainer.maxWidthProperty().bind(
                Bindings.createDoubleBinding(
                        () -> inputPane.isVisible() ?
                                  contactContainer.getScene().getWidth() - inputPane.getPrefWidth()
                                : contactContainer.getScene().getWidth(), 
                        inputPane.visibleProperty(),
                        contactContainer.getScene().widthProperty()
            )
        );
    }   
    
    /**
     * @brief Gestisce l'aggiunta di un nuovo contatto alla rubrica.
     * 
     * Questo metodo viene invocato quando l'utente preme il pulsante 'Aggiungi'
     * per aggiungere un nuovo contatto. I dati vengono prelevati dai campi
     * di input e utilizzati per creare un nuovo contatto.
     * 
     * @param[in] e L'evento associato al click del pulsante.
     * 
     * 
     * @pre i dati inseriti sono validi (la validità è gestita dai metodi della classe Contatto)
     * @post viene aggiunto un nuovo contatto alla rubrica
     * @post la view viene aggiornata
     * @post i campi di input vengono ripuliti
     * @post Il pannello per l'inserimento di un nuovo utente viene nascosto
     * 
     * @see ripulisciCampi()
     * @see aggiornaContatti()
     * @see Contatto
     * @see Rubrica
     * 
     */
    @FXML
    private void handleAdd(ActionEvent e) {
        // creo un nuovo contatto
        Contatto nuovoContatto = new Contatto(tfNome.getText(), tfCognome.getText());
        
        // aggiungo nei dati del contatto gli eventuali numeri di telefono inseriti
        nuovoContatto.aggiungiNumero(tfTelefono1.getText());
        nuovoContatto.aggiungiNumero(tfTelefono2.getText());
        nuovoContatto.aggiungiNumero(tfTelefono3.getText());
        
        // aggiungo nei dati del contatto gli eventuali indirizzi email inseriti
        nuovoContatto.aggiungiMail(tfEmail1.getText());
        nuovoContatto.aggiungiMail(tfEmail2.getText());
        nuovoContatto.aggiungiMail(tfEmail3.getText());
        
        // aggiungo il contatto alla rubrica
        rubrica.aggiungiContatto(nuovoContatto);
        //aggiorno la view dopo aver inserito il nuovo contatto
        aggiornaContatti();
        // ripulisco i campi di input
        ripulisciCampi();
        // nascondo il pannello per l'inserimento di un nuovo contatto
        inputPane.setVisible(false);
    }
    
    
    /**
     * @brief Aggiorna la lista dei contatti visualizzata nell'interfaccia.
     * 
     * Questo metodo sincronizza l'elenco grafico dei contatti con i dati attualmente
     * presenti nella rubrica.
     *   
     * @pre La rubrica deve contenere almeno un contatto.
     * @post L'elenco grafico dei contatti corrisponde alla rubrica aggiornata.
     * 
     * @see Rubrica
     */
    private void aggiornaContatti() {
        // ripulisco la view dalle schede contatto precedenti
        contactContainer.getChildren().clear();
        // ripulisco la mappa contatti
        mappaContatti.clear();
        
        for (Contatto contatto: rubrica.getContatti()) {
            // creo per ogni contatto presente in rubrica un'apposita scehda contatto
            VBox card = creaSchedaContatto(contatto);
            // associo al contatto la propria scheda contatto
            mappaContatti.put(contatto, card);
            // aggiungo per ogni contatto la relativa scheda contatto creata alla view
            contactContainer.getChildren().add(card);
        }
    }
    
    
    /**
     * @brief Crea una Card per un singolo contatto.
     * 
     * Questo metodo genera una rappresentazione grafica di un contatto
     * con i dettagli del contatto e pulsanti per
     * modificarlo o eliminarlo.
     * 
     * @param[in] contatto Il contatto da rappresentare graficamente.
     * @return Un oggetto HBox che rappresenta graficamente il contatto.
     * 
     * @pre Il contatto contiene dati validi
     * (?) @post Un HBox viene restituito, pronto per essere aggiunto all'interfaccia.
     * 
     * @see AggiornaContatti
     * @see Contatto
     */
    private VBox creaSchedaContatto(Contatto contatto) {
        // Creo e configuro una nuova card
        VBox card = new VBox();
        card.setSpacing(10);
        card.setAlignment(Pos.CENTER);
        
        // Raggruppo le informazioni inerenti a Nome e Cognome
        VBox v1 = new VBox();
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(10);
        Label nomeLabel = new Label("Nome: " + contatto.getNome());
        Label cognomeLabel = new Label("Cognome: " + contatto.getCognome());
        v1.getChildren().addAll(nomeLabel, cognomeLabel);
        
        // Raggruppo le informazioni inerenti ai numeri di telefono
        VBox v2 = new VBox();
        v2.setAlignment(Pos.CENTER);
        v2.setSpacing(10);
        int cont;
        cont = 0;
        for (String numeroTelefono : contatto.getNumeriTelefono()) {
            cont++;
            Label numeroLabel = new Label("Numero di Telefono " + cont + ": " + numeroTelefono);
            v2.getChildren().add(numeroLabel);
        }
        
        // Raggruppo le informazioni inerenti agli indirizzi email
        VBox v3 = new VBox();
        v3.setAlignment(Pos.CENTER);
        v3.setSpacing(10);
        cont = 0;
        for (String indirizzoEmail : contatto.getIndirizziMail()) {
            cont++;
            Label emailLabel = new Label("Indirizzo email " + cont + ": " + indirizzoEmail);
            v3.getChildren().add(emailLabel);
        }
        
        // Creo e raggruppo i 2 pulsanti per eliminare e modificare un contatto
        HBox h1 = new HBox();
        h1.setAlignment(Pos.CENTER);
        h1.setSpacing(10);
        Button editBtn = new Button("Modifica");
        Button removeBtn = new Button("Elimina");
        h1.getChildren().addAll(removeBtn, editBtn);
        
        // Collego al pulsante di modifica la relativa azione
        editBtn.setOnAction(e -> modificaContatto(contatto));
        
        // Collego al pulsante di eliminazione la relativa azione
        removeBtn.setOnAction(e -> {
            // Rimuovo il contatto dalla rubrica
            rubrica.rimuoviContatto(contatto);
            // Aggiorno la view
            aggiornaContatti();
        });
        
        // Aggiungo tutti gli elementi creati alla card
        card.getChildren().addAll(v1, v2, v3, h1);
        
        return card;
    }
    
    
    
    /**
      * @brief Modifica un contatto esistente nella rubrica.
      * 
      * Questo metodo consente di aggiornare i dati di un contatto già presente
      * nella rubrica. Dopo la modifica, l'elenco dei contatti viene aggiornato
      * per riflettere i cambiamenti.
      * 
      * @param[in] contatto Il contatto da modificare.
      * @pre Il contatto deve esistere nella rubrica.
      * @pre I dati inseriti sono validi
      * @post Il contatto è stato aggiornato con i nuovi dati.
      * 
      * @see aggiornaContatti()
      * @see Contatto
      */
    private void modificaContatto(Contatto contatto) {
        // Creo e configuro una scheda contatto modificabile
        VBox editCard = new VBox();
        editCard.setAlignment(Pos.CENTER);
        editCard.setSpacing(10);
        
        // Inserisco i campi modificabili inerenti a Nome e Cognome
        VBox v1 = new VBox();
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(10);
        HBox h1 = new HBox();
        h1.setSpacing(10);
        TextField tfEditNome = new TextField(contatto.getNome());
        h1.getChildren().addAll(new Label("Nome: "), tfEditNome);
        HBox h2 = new HBox();
        h2.setSpacing(10);
        TextField tfEditCognome = new TextField(contatto.getCognome());
        h2.getChildren().addAll(new Label("Cognome: "), tfEditCognome);
        v1.getChildren().addAll(h1, h2);
        
        // Inserisco i campi modificabili inerenti ai numeri di telefono
        VBox v2 = new VBox();
        v2.setAlignment(Pos.CENTER);
        v2.setSpacing(10);
        String[] numeriTelefonoArray = contatto.getNumeriTelefono().toArray(new String[0]);
        TextField tfEditNumero1 = new TextField(numeriTelefonoArray[0] != null ? numeriTelefonoArray[0] : "");
        TextField tfEditNumero2 = new TextField(numeriTelefonoArray[1] != null ? numeriTelefonoArray[1] : "");
        TextField tfEditNumero3 = new TextField(numeriTelefonoArray[2] != null ? numeriTelefonoArray[2] : "");
        v2.getChildren().addAll(new Label("Numero di Telefono:"), tfEditNumero1, tfEditNumero2, tfEditNumero3);
        
        // Inserisco i campi modificabili inerenti agli indirizzi email
        VBox v3 = new VBox();
        v3.setAlignment(Pos.CENTER);
        v3.setSpacing(10);
        String[] indirizziEmailArray = contatto.getIndirizziMail().toArray(new String[0]);
        TextField tfEditEmail1 = new TextField(indirizziEmailArray[0] != null ? indirizziEmailArray[0] : "");
        TextField tfEditEmail2 = new TextField(indirizziEmailArray[1] != null ? indirizziEmailArray[1] : "");
        TextField tfEditEmail3 = new TextField(indirizziEmailArray[2] != null ? indirizziEmailArray[2] : "");
        v3.getChildren().addAll(new Label("Indirizzi email:"), tfEditEmail1, tfEditEmail2, tfEditEmail3);
        
        // Inserisco i pulsanti inerenti al salvataggio e l'annullamento delle modifiche
        HBox h3 = new HBox();
        h3.setAlignment(Pos.CENTER);
        h3.setSpacing(10);
        Button saveEditBtn = new Button("Salva");
        Button cancelEditBtn = new Button("Annulla");
        h3.getChildren().addAll(cancelEditBtn, saveEditBtn);
        
        // Collego il pulsante di salvataggio delle modifiche alla relativa azione
        saveEditBtn.setOnAction(e -> {
            // Aggiorno i dati inerenti a Nome e Cognome
            contatto.setNome(tfEditNome.getText());
            contatto.setCognome(tfEditCognome.getText());
            
            // Aggiorno i dati inerenti ai numero di telefono
            contatto.modificaNumero(tfEditNumero1.getText(), contatto.getNumeriTelefono().toArray(new String[3])[0]);
            contatto.modificaNumero(tfEditNumero2.getText(), contatto.getNumeriTelefono().toArray(new String[3])[1]);
            contatto.modificaNumero(tfEditNumero3.getText(), contatto.getNumeriTelefono().toArray(new String[3])[2]);
            
            // Aggiorno i dati inerenti agli indirizzi email
            contatto.modificaMail(tfEditEmail1.getText(), contatto.getIndirizziMail().toArray(new String[3])[0]);
            contatto.modificaMail(tfEditEmail2.getText(), contatto.getIndirizziMail().toArray(new String[3])[1]);
            contatto.modificaMail(tfEditEmail3.getText(), contatto.getIndirizziMail().toArray(new String[3])[2]);
            
            // Aggiorno la view
            aggiornaContatti();
        });
        
        // Collego il pulsante di annullamento delle modifiche alla relativa azione
        cancelEditBtn.setOnAction(e -> {
            // Aggiorno la view
            aggiornaContatti();
        });
        
        // Aggiungo gli elementi creati alla scheda contatto modificabile
        editCard.getChildren().addAll(v1, v2, v3, h3);
        
        // Rimuovo dalla view la scheda contatto precedentemente inserita e la sostituisco
        // con quella modificabile appena creata
        contactContainer.getChildren().remove(mappaContatti.get(contatto));
        contactContainer.getChildren().add(editCard);
    }
    
    
    /**
      * @brief Ripulisce tutti i campi di input nell'interfaccia.
      * 
      * Questo metodo svuota i campi di input per consentire l'inserimento di nuovi dati.
      * 
      * @pre I campi devono essere pieni.
      * @post Tutti i campi di input sono stati svuotati.
      */
    private void ripulisciCampi() {
        // ripulisco i campi Nome e Cognome
        tfNome.clear();
        tfCognome.clear();
        
        // ripulisco i campi inerenti ai numeri di telefono
        tfTelefono1.clear();
        tfTelefono2.clear();
        tfTelefono3.clear();
        
        // ripulisco i campi inerenti agli indirizzi email
        tfEmail1.clear();
        tfEmail2.clear();
        tfEmail3.clear();
    }

    /**
     * @brief Gestisce il caso in cui l'utente scelga di annullare l'aggiunta di un nuovo vontatto
     * 
     * @param event L'evento associato al click del pulsante
     * 
     * @post I campi di input vengono ripuliti
     * @post Il pannello per l'inserimento di un nuovo utente viene nascosto
     * 
     * @see ripulisciCampi()
     */
    @FXML
    private void handleCancel(ActionEvent event) {
        // Ripulisco i campi input
        ripulisciCampi();
        // Nascondo il pannello per l'inserimento di un nuovo utente 
        inputPane.setVisible(false);
    }

    /**
     * @brief Mostra il pannello contenente i campi di input per l'aggiunta di un nuovo contatto qualora venisse premuto l'apposito tasto nella dashboard
     * 
     * Se il pulsante viene premuto e il pannello di aggiunta utente è nascosto, quest'ultimo viene mostrato.
     * Se invece il pulsante viene premuto e il pannello è già visibile, questo viene nascoto.
     * 
     * @param event L'evento associato al click del pulsante
     * 
     * @post Il pannello per l'inserimento di un nuovo utente compare/scompare
     */
    @FXML
    private void onNewContact(ActionEvent event) {
        boolean isVisible = inputPane.isVisible();
        inputPane.setVisible(!isVisible);
    }

    /**
     * @brief Mostra nella view unicamente i contatti il cui nome/cognome contiene la stringa inserita nel campo di ricerca
     * 
     * @param event L'evento associato al click del pulsante
     * 
     * @pre è stata fornita una stringa come parametro di ricerca
     * @post sono mostrate solo le card dei contatti corrispondenti alla ricerca
     * 
     * @see Contatto
     * @see Rubrica
     * 
     */
    @FXML
    private void handleSearch(ActionEvent event) {
        // Ripulisco la view
        contactContainer.getChildren().clear();
        for (Contatto contatto: rubrica.getContatti()) {
            if (contatto.getNome().contains(tfSearch.getText()) || contatto.getCognome().contains(tfSearch.getText())) {
                // Creo una card per ogni contatto che rispetti i criteri di ricerca
                VBox card = creaSchedaContatto(contatto);
                // Mostro nella view ogni nuova card creata
                contactContainer.getChildren().add(card);
            }
        }
        
        // Creo e aggiungo alla view un pulsante da premere qualora si sia completata la ricerca
        Button okBtn = new Button("Ok");
        contactContainer.getChildren().add(okBtn);
        
        // Associo al pulsante la relativa azione
        okBtn.setOnAction(e -> {
            // Aggiorno la view, tornando a mostrare tutti i contatti
            aggiornaContatti();
        });
    }

    /**
     * @brief Permette di importare in rubrica i contenuti di un file esterno
     * 
     * Viene mostrata una finestra di dialogo che consenta di caricare un file prelevandolo dalla propria directory
     * 
     * @param event L'evento associato al click del pulsante
     * 
     * (?) @pre Il file da importare esiste ed è correttamente formattato
     * @post Il contenuto del file viene caricato in rubrica
     * @post Viene mostrata una notifica alla fine dell'operazione
     * 
     * @see CSVFileHandler
     */
    @FXML
    private void handleImport(ActionEvent event) {
        // Mostro una finestra di dialogo per permettere all'utente di selezionare il file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un file CSV");
        // Specifico che l'utente può selezionare unicamente file .csv
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*csv"));
        // Ottengo il file selezionato
        Stage primaryStage = (Stage) importaBtn.getScene().getWindow();
        File fileSelezionato = fileChooser.showOpenDialog(primaryStage);
        
        // Controllo che il file sia stato selezionato
        if (fileSelezionato != null) {
            // Ottengo il path del file
            String filePath = fileSelezionato.getAbsolutePath();
            try {
                // Invoco la funzione di importazione da CSVFileHandler passando il path del file
                fh.importaRubrica(filePath);
                // Aggiorno la view
                aggiornaContatti();
                // Mostro una notifica di completamento
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Importazione completata con successo");
                alert.setHeaderText(null);
                alert.showAndWait();
            } catch (IOException ex) {
                // Gestisco il caso in cui sorga un'eccezione
                System.err.println("Importazione fallita: " + ex.getMessage());
                // Mostro una notifica di fallimento
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Importazione fallita");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } else {
            // Gestisco il caso in cui non venga selezionato alcun file, annullando l'operazione
            System.out.println("Nessun file selezionato");
            // Mostro una notifica di fallimento
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Importazione fallita");
                alert.setHeaderText(null);
                alert.showAndWait();
        }

    }

    /**
     * @brief Permette di esportare i dati presenti in rubrica su un file CSV esterno
     * 
     * Viene mostrata una finestra di dialogo che consente di selezionare la directory/file in cui salvare i dati
     * 
     * @param event L'evento associato al clic del pulsante
     * 
     * @pre La rubrica contiene dati da esportare
     * @post I dati presenti in ribrica vengono salavti su file CSV prensente nella directory specificata
     * @post Viene mostrata una notifica alla fine dell'operazione
     * 
     * @see CSVFileHandler
     */
    @FXML
    private void handleExport(ActionEvent event) {
        // Mostro all'utente una finestra di dialogo per permettere all'utente di selezionare un file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Esporta Rubrica");
        // Specifico che l'utene può selezionare unicamente file .csv
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
        // Ottengo il file selezionato
        Stage primaryStage = (Stage) esportaBtn.getScene().getWindow();
        File fileDaSalvare = fileChooser.showSaveDialog(primaryStage);
        
        // Controllo che il file sia stato selezionato
        if (fileDaSalvare != null) {
            // Ottengo il path del file
            String filePath = fileDaSalvare.getAbsolutePath();
            // Nel caso non sia presente, aggiungo l'estensione .csv al path del file
            if(!filePath.endsWith(".csv")) {
                filePath += ".csv";
            }
            
            try {
                // Invoco la funzione di esportazione di CSVFilehandler passando il path del file
                fh.esportaRubrica(filePath);
                // Mostro una notifica di completamento dell'operazione
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Esportazione completata con successo");
                alert.setHeaderText(null);
                alert.showAndWait();
            } catch (IOException ex) {
                // Gestisco il caso in cui sorga un'eccezione
                System.err.println("Errore nell'esportazione: " + ex.getMessage());
                // Mostro una notifica di fallimento
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Esportazione fallita");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } else {
            // Gestisco il caso in cui l'esportazione fallisca, annullando l'operazione
            System.out.println("Esportazione annullata");
            // Mostro una notifica di fallimento
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Esportazione fallita");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
    
}
