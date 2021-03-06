package controleur;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controleur.cellfactory.VolCellFactory;
import database.DatabaseVolDAO;
import database.SQL;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
import main.App;
import main.Tools;
import modele.DepartVol;
import modele.Vol;

public class ControleurVueProgrammerVol extends RightPaneControlleur implements Initializable {

	@FXML
	private ComboBox<Vol> cbxListeVol;

	@FXML
	private TextField txtDate;

	@FXML
	private TextField txtDuree;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		txtDuree.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, Tools.INTEGER_FILTER));

		List<Vol> listeVol = DatabaseVolDAO.getInstance().getList();
		cbxListeVol.setItems(FXCollections.observableArrayList(listeVol));

		cbxListeVol.setButtonCell(new VolCellFactory().call(null));
		cbxListeVol.setCellFactory(new VolCellFactory());
	}
	
	@FXML
	public void valider()
	{
		Vol vol = cbxListeVol.getValue();
		String dateStr = txtDate.getText().trim();
		String dureeStr = txtDuree.getText().trim();

		LocalDate date = null;
		List<String> errors = new ArrayList<>();

		if (vol == null)
			errors.add("Vous devez choisir un vol");

		try
		{
			date = LocalDate.parse(dateStr, Tools.DATE_FORMAT);
		}
		catch (DateTimeParseException e)
		{
			errors.add("Vous devez une date valide");
		}

		if (dureeStr.isEmpty())
			errors.add("Vous devez mettre une dur�e valide");

		if (!errors.isEmpty())
		{
			App.showWarning(String.join("\n", errors));
			return;
		}

		DepartVol departVol = new DepartVol(vol, date, Integer.parseInt(dureeStr));

		SQL.getInstance().programmer(departVol);
		vuePrincipale.clearRightPane();

		App.showSuccess("Le vol a bien �t� programm�");
	}

	@FXML
	public void annuler()
	{
		vuePrincipale.clearRightPane();
	}

	
}
