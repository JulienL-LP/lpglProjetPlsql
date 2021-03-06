package controleur;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controleur.cellfactory.DepartVolCellFactory;
import controleur.cellfactory.PersonnelCellFactory;
import database.DatabaseDepartVolDAO;
import database.DatabasePersonnelDAO;
import database.SQL;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import main.App;
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

		cbxVol.setButtonCell(new DepartVolCellFactory().call(null));
		cbxVol.setCellFactory(new DepartVolCellFactory());

		cbxMembre.setButtonCell(new PersonnelCellFactory().call(null));
		cbxMembre.setCellFactory(new PersonnelCellFactory());
	}

	@FXML
	public void valider()
	{
		DepartVol vol = cbxVol.getValue();
		Personnel personnel = cbxMembre.getValue();

		if (vol == null || personnel == null)
		{
			App.showWarning("Toutes les informations doivent �tre rempli");
			return;
		}

		SQL.getInstance().affecterPersonnel(vol, personnel);
		vuePrincipale.clearRightPane();

		App.showSuccess("Le membre a bien �t� affect�");
	}

	@FXML
	public void annuler()
	{
		vuePrincipale.clearRightPane();
	}

}
