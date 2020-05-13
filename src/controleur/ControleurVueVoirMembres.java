package controleur;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controleur.cellfactory.DepartVolCellFactory;
import database.DatabaseDepartVolDAO;
import database.SQL;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import modele.DepartVol;

public class ControleurVueVoirMembres extends RightPaneControlleur implements Initializable{

	@FXML
	private ComboBox<DepartVol> cbxVol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<DepartVol> listeVol = DatabaseDepartVolDAO.getInstance().getList();
		cbxVol.setItems(FXCollections.observableArrayList(listeVol));

		cbxVol.setButtonCell(new DepartVolCellFactory().call(null));
		cbxVol.setCellFactory(new DepartVolCellFactory());
	}
	
	@FXML
	public void valider()
	{
		DepartVol vol = cbxVol.getValue();

		if (vol == null)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Attention");
			alert.setContentText("Le vol doit être donné");
			alert.showAndWait();

			return;
		}

		SQL.getInstance().membresEquipage(vol);
	}

	@FXML
	public void annuler()
	{
		vuePrincipale.clearRightPane();
	}

	
}
