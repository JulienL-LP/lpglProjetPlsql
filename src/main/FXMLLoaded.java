package main;

import javafx.scene.Node;

public class FXMLLoaded<TN extends Node, TC> {

	private final TN node;
	private final TC controller;

	public FXMLLoaded(TN node, TC controller)
	{
		this.node = node;
		this.controller = controller;
	}

	public TN getNode()
	{
		return node;
	}

	public TC getController()
	{
		return controller;
	}
}
