package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import modele.Vol;

public class ControleurVueVoirMembres extends RightPaneControlleur {

	@FXML
	private ComboBox<Vol> cbxVol;

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
