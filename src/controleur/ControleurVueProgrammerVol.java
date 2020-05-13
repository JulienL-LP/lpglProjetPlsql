package controleur;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DatabaseVolDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import modele.Vol;

public class ControleurVueProgrammerVol extends RightPaneControlleur implements Initializable {

	@FXML
	private TextField txtDate;

	@FXML
	private TextField txtDuree;

	@FXML
	private ChoiceBox<Vol> cbxListeVol;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Vol> listeVol = DatabaseVolDAO.getInstance().getList();
		cbxListeVol.setItems(FXCollections.observableArrayList(listeVol));
	}
	
	@FXML
	public void valider()
	{
		System.out.println("invocation Valider");
	}

	@FXML
	public void annuler()
	{
		vuePrincipale.clearRightPane();
	}

	
}
