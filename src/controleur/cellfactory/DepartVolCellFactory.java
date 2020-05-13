package controleur.cellfactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import main.Tools;
import modele.DepartVol;

public class DepartVolCellFactory implements Callback<ListView<DepartVol>, ListCell<DepartVol>> {

	@Override
	public ListCell<DepartVol> call(ListView<DepartVol> view)
	{
		return new ListCell<DepartVol>() {

			@Override
			public void updateItem(DepartVol item, boolean empty)
			{
				super.updateItem(item, empty);
				if (item == null || empty)
					setGraphic(null);
				else setText(item.getVol().getNoVol() + " " + item.getDateDepart().format(Tools.DATE_FORMAT));
			}
		};
	}
}
