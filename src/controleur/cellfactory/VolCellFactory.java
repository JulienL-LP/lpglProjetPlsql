package controleur.cellfactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import modele.Vol;

public class VolCellFactory implements Callback<ListView<Vol>, ListCell<Vol>> {

	@Override
	public ListCell<Vol> call(ListView<Vol> view)
	{
		return new ListCell<Vol>() {

			@Override
			public void updateItem(Vol item, boolean empty)
			{
				super.updateItem(item, empty);
				if (item == null || empty)
					setGraphic(null);
				else setText(item.getNoVol() + " : " + item.getDepart() + " - " + item.getArrivee());
			}
		};
	}
}
