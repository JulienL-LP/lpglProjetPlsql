package controleur.cellfactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import modele.Personnel;

public class PersonnelCellFactory extends ListCell<Personnel> implements Callback<ListView<Personnel>, ListCell<Personnel>> {

	@Override
	public ListCell<Personnel> call(ListView<Personnel> view)
	{
		return this;
	}

	@Override
	public void updateItem(Personnel item, boolean empty)
	{
		super.updateItem(item, empty);
		if (item == null || empty)
			setGraphic(null);
		else setText(item.getMatricule() + " - " + item.getNom() + " - " + item.getFonction());
	}
}
