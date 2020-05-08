package main;

import java.net.URL;

public enum Window
{
	MENU("vuePrincipale"),
	PROGRAMMER_VOL("vueProgrammerVol"),
	AFFECTER_MEMBRES("vueAffecterMembres"),
	VOIR_MEMBRES_VOL("vueVoirMembres");

	public static final String PACKAGE_NAME = "/";

	private final URL url;
	
	Window(String name)
	{
		this.url = getClass().getResource(PACKAGE_NAME + "vue/" + name + ".fxml");
	}

	public URL getUrl()
	{
		return url;
	}
}
