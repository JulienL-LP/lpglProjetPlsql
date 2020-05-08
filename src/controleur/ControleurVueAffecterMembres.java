package controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import main.App;

public class ControleurVueAffecterMembres implements Initializable{

	@FXML
	private Button btnValider;
	
	@FXML
	private Button btnAnnuler;
	
	@FXML
	private ComboBox<String> cbxVol;
	
	@FXML
	private ComboBox<String> cbxMembre;
	
	@FXML
	private App mainApp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }
	
	@FXML
	private void valider()
	{
		System.out.println("invocation Valider");
	}
	
	@FXML
	private void annuler()
	{
		System.out.println("invocation Annuler");
	}

}
