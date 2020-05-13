package controleur;

import lombok.Setter;
import main.App;

public abstract class Controleur {

	@Setter
	protected App app;

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
	
}
