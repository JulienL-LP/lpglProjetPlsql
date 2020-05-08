package main;

import java.io.IOException;
import java.net.URL;

import controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

public class App extends Application {

	@Getter
	private Stage window;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage window) throws IOException
	{
		this.window = window;
		window.setTitle("VolApp");

		FXMLLoaded<Parent, Controleur> fxmlLoaded = loadComponent(Window.MENU);

		Scene scene = new Scene(fxmlLoaded.getNode());
		window.setScene(scene);

		window.show();
	}

	public <T extends Node, T1 extends Controleur> FXMLLoaded<T, T1> loadComponent(Window window) throws IOException
	{
		FXMLLoaded<T, T1> fxmlLoaded = loadComponent(window.getUrl());

		fxmlLoaded.getController().setApp(this);

		return fxmlLoaded;
	}

	public static <T extends Node, T1> FXMLLoaded<T, T1> loadComponent(URL url) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(url);

		T node = loader.load();

		return new FXMLLoaded<T, T1>(node, loader.getController());
	}
}
