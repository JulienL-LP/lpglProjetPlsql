package controleur;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import main.FXMLLoaded;
import main.Window;

public class ControleurVuePrincipale extends Controleur {

	@FXML
	private BorderPane borderPane;

	@FXML
	public void programmerVol() throws IOException
	{
		changeRightPane(app.loadComponent(Window.PROGRAMMER_VOL));
	}

	@FXML
	public void voirMembres() throws IOException
	{
		changeRightPane(app.loadComponent(Window.VOIR_MEMBRES_VOL));
	}

	@FXML
	public void affecterMembres() throws IOException
	{
		changeRightPane(app.loadComponent(Window.AFFECTER_MEMBRES));
	}

	public void clearRightPane()
	{
		if (borderPane.getRight() != null)
			borderPane.setRight(null);
	}

	public void changeRightPane(FXMLLoaded<Node, RightPaneControlleur> fxmlLoaded)
	{
		fxmlLoaded.getController().setVuePrincipale(this);
		changeRightPane(fxmlLoaded.getNode());
	}

	public void changeRightPane(Node node)
	{
		clearRightPane();
		borderPane.setRight(node);

		app.getWindow().sizeToScene();
		app.getWindow().centerOnScreen();
	}
}
