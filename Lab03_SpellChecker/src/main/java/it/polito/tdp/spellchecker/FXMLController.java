/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

/*package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}*/

package it.polito.tdp.spellchecker;

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private ObservableList<String> list= FXCollections.observableArrayList();
	private Dictionary dizionario;
	private List<String> inputList= new LinkedList<String>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> chooseMenu;

    @FXML
    private TextArea txtTesto;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtParole;

    @FXML
    private TextField txtErrori;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtTempo;

    @FXML
    void doClearText(ActionEvent event) {
    	txtTesto.clear();
    	txtParole.clear();
    	txtErrori.setText("The text contains ");
    	txtTempo.setText("Spell check completed in ");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String inputText= txtTesto.getText().toLowerCase();
    	inputText= inputText.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
    	
    	if(inputText==null || inputText.length()==0) {
    		txtTesto.appendText("Devi inserire un testo da correggere");
    	}
    	
    	StringTokenizer st= new StringTokenizer(inputText, "");
    	String testo= st.nextToken();
    	
    	while(st.hasMoreTokens()) {
    		inputList.add(testo);
    	}
    	
    }

    @FXML
    void initialize() {
        assert chooseMenu != null : "fx:id=\"chooseMenu\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
      
        
    }
    
    public void setModel(Dictionary model) {
    	list.addAll("English", "Italian");
        chooseMenu.setItems(list);
        chooseMenu.setValue("Italian");
        
    }
}



