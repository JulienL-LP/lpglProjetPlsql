package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import modele.Vol;

public class ControleurVueProgrammerVol extends RightPaneControlleur {

	@FXML
	private TextField txtDate;

	@FXML
	private TextField txtDuree;

	@FXML
	private ChoiceBox<Vol> cbxListeVol;

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
