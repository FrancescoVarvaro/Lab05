	package it.polito.tdp.anagrammi;

	import java.net.URL;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.ResourceBundle;

	import it.polito.tdp.anagrammi.model.Model;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class FXMLController {

		private Model model;
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button doCalcola;

	    @FXML
	    private Button doReset;

	    @FXML
	    private TextArea txtCorretto;

	    @FXML
	    private TextArea txtErrato;

	    @FXML
	    private TextField txtUtente;
	    
	    @FXML
	    void doCalcola(ActionEvent event) {
	    	String parola = txtUtente.getText();
	    	model.anagramma(parola);
	    	List<String> anagrammiCorretti = new LinkedList<String>(model.getAnagCorretti());
	    	List<String> anagrammiScorretti = new LinkedList<String>(model.getAnagScorretti());
	    	for(String s : anagrammiCorretti) {
	    		txtCorretto.appendText(s+"\n");}
	    	
	    	for(String s : anagrammiScorretti) {
	    		txtErrato.appendText(s+"\n");}
	    	txtUtente.clear();
	    }

	    @FXML
	    void doReset(ActionEvent event) {
	    	txtCorretto.clear();
	    	txtErrato.clear();
	    }

	    @FXML
	    void initialize() {
	        assert doCalcola != null : "fx:id=\"doCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert doReset != null : "fx:id=\"doReset\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtErrato != null : "fx:id=\"txtErrato\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtUtente != null : "fx:id=\"txtUtente\" was not injected: check your FXML file 'Scene.fxml'.";
	        
	    }
	    
	    public void setModel(Model model) {
	    	this.model = model;
	    	model = new Model();
	    }

	}