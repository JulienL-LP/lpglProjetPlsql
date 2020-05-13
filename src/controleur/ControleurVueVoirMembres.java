package controleur;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DatabaseVolDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import modele.Vol;

public class ControleurVueVoirMembres extends RightPaneControlleur implements Initializable{

	@FXML
	private ComboBox<Vol> cbxVol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Vol> listeVol = DatabaseVolDAO.getInstance().getList();
		cbxVol.setItems(FXCollections.observableArrayList(listeVol));
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
