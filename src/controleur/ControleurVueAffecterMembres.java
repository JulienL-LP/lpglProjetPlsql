package controleur;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DatabaseDepartVolDAO;
import database.DatabasePersonnelDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import modele.DepartVol;
import modele.Personnel;

public class ControleurVueAffecterMembres extends RightPaneControlleur implements Initializable {

	@FXML
	private ComboBox<DepartVol> cbxVol;

	@FXML
	private ComboBox<Personnel> cbxMembre;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		List<DepartVol> listeVol = DatabaseDepartVolDAO.getInstance().getList();
		cbxVol.setItems(FXCollections.observableArrayList(listeVol));

		List<Personnel> listeMembre = DatabasePersonnelDAO.getInstance().getList();
		cbxMembre.setItems(FXCollections.observableArrayList(listeMembre));	
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
