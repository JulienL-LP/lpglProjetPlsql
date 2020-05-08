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
	private void programmerVol() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/vue/vueProgrammerVol.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		
		vboxDroite.getChildren().clear();
		vboxDroite.getChildren().add(pane);
		ControleurVueProgrammerVol controller = loader.getController();
		
//		controller.setMainApp(this);
		System.out.println("Ouverture du fxml affecter");
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

	@FXML 
	private void voirMembres() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/vue/vueVoirMembres.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		
		vboxDroite.getChildren().clear();
		vboxDroite.getChildren().add(pane);
		ControleurVueVoirMembres controller = loader.getController();
		
//		controller.setMainApp(this);
		System.out.println("Ouverture du fxml affecter");
	}
	
	@FXML
	private void affecterMembres() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/vue/vueAffecterMembres.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		
		vboxDroite.getChildren().clear();
		vboxDroite.getChildren().add(pane);
		ControleurVueAffecterMembres controller = loader.getController();
		
//		controller.setMainApp(this);
		System.out.println("Ouverture du fxml affecter");
	}
}
