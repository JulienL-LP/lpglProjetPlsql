package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControleurVuePrincipale implements Initializable{

	@FXML
	private Button btnProgrammerVol;
	
	@FXML
	private Button btnVoirLesMembres;
	
	@FXML
	private Button btnAffecterPersonnel;
	
	@FXML
	private AnchorPane pane;
	
	@FXML 
	private VBox vboxDroite;
	
	private MainApp mainApp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void programmerVol()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/vue/vueProgrammerVol.fxml"));
			pane = (AnchorPane) loader.load();

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Ouverture de la fenetre correspondante");
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

	@FXML 
	private void voirMembres()
	{
		System.out.println("Ouverture du fxml correspondant");
	}
	
	@FXML
	private void affecterMembres() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/vue/vueAffecterMembres.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		
		vboxDroite.getChildren().add(pane);
		ControleurVueAffecterMembres controller = loader.getController();
		
//		controller.setMainApp(this);
		System.out.println("Ouverture du fxml affecter");
	}
}
