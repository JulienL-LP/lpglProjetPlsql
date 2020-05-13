package controleur;

import lombok.Setter;

public class RightPaneControlleur extends Controleur {

	@Setter
	protected ControleurVuePrincipale vuePrincipale;

	public ControleurVuePrincipale getVuePrincipale() {
		return vuePrincipale;
	}

	public void setVuePrincipale(ControleurVuePrincipale vuePrincipale) {
		this.vuePrincipale = vuePrincipale;
	}
	
	
}
