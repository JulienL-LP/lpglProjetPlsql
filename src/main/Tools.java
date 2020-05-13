package main;

import java.time.format.DateTimeFormatter;
import java.util.function.UnaryOperator;

import javafx.scene.control.TextFormatter.Change;

public final class Tools {

	private Tools() {}

	public final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");

	public static final UnaryOperator<Change> INTEGER_FILTER = change -> change.getControlNewText().matches("([0-9][0-9]*)?") ? change : null;
}
