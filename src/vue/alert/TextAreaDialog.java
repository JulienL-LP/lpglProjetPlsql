package vue.alert;

import javafx.application.Platform;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import lombok.Getter;

public class TextAreaDialog extends Dialog<String> {

	@Getter
	private TextArea editor = new TextArea();

	public TextAreaDialog()
	{
		this("");
	}

	public TextAreaDialog(String text)
	{
		super();

		getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		editor.setWrapText(true);
		editor.setText(text);

		BorderPane expContent = new BorderPane();
		expContent.setCenter(editor);

		getDialogPane().setContent(expContent);

		setResultConverter((dialogButton) -> {
			ButtonData data = dialogButton == null ? null : dialogButton.getButtonData();
			return data == ButtonData.OK_DONE ? editor.getText() : null;
		});

		Platform.runLater(() -> editor.requestFocus());
	}

}
