package controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ControleurVueAffecterMembres extends RightPaneControlleur implements Initializable {

	@FXML
	private ComboBox<String> cbxVol;

	@FXML
	private ComboBox<String> cbxMembre;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub

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
