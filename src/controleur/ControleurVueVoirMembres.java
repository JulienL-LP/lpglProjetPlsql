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
import javafx.scene.control.ComboBox;
import main.App;
import modele.DepartVol;
import vue.alert.TextAreaDialog;

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
			App.showWarning("Le vol doit être donné");
			return;
		}

		List<String> list = SQL.getInstance().membresEquipage(vol);

		TextAreaDialog alert = new TextAreaDialog(String.join("\n", list));
		alert.getEditor().setEditable(false);
		alert.setTitle("Console");
		alert.setContentText("Console DBMS : ");

		vuePrincipale.clearRightPane();

		alert.showAndWait();
	}

	@FXML
	public void annuler()
	{
		vuePrincipale.clearRightPane();
	}
}
