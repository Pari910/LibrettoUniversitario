/**
 * Sample Skeleton for 'LibrettoUniversitario.fxml' Controller Class
 */

package it.polito.tdp.librettoUniversitario;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.librettoUniversitario.model.Esame;
import it.polito.tdp.librettoUniversitario.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoUniversitarioController {
	/*
	 * Se costruissi il model all'interno del controller,
	 * qualora avessi più finestre, ognuna avrebbe un suo model
	 * e non riuscirebbero a comunicare
	 * 
	 * Il model va costruito nel main e sempre nel main settato un model
	 * presente nel controller.
	 * In questo modo tutti agiscono sullo stesso model.
	 */
	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<5){
    		txtMessage.appendText("Codice corso non valido\n");
    		return;
    	}
    	
    	Esame esame = model.trovaEsame(codice);
    	
    	if(null!=esame){
    		txtMessage.appendText("Esame con codice "+codice+" trovato\n");
    		txtCodice.setText(esame.getCodice());
    		txtTitolo.setText(esame.getTitolo());
    		txtDocente.setText(esame.getDocente());
    		return;
    	}else{
    		txtMessage.appendText("Esame con codice "+codice+" NON trovato\n");
    		return;
    	}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	// recupero i dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	// verifica validità dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esame insufficienti\n");
    		return;
    	}
    	
    	// chiedi al Model di effettuare l'operazione
    	Esame esame = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(esame);

    	// aggiorna la vista con il risultato dell'operazione
    	if(result){
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    		return;
    	}else{
    		txtMessage.appendText("Esame NON aggiunto (codice duplicato)\n");
    		return;
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
    }

	public void setModel(Model model) {
		this.model = model;
	}
}
