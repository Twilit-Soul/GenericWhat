package userInterface.vBoxes.titledRadioButtons;

import java.util.ArrayList;
import java.util.List;

import userInterface.SceneMaker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class TitledRadioButtons extends VBox {

	List<RadioButton> buttons;

	public TitledRadioButtons(String title, String buttonText, String... choices) {
		this(title, buttonText, 0, 0, choices);
	}
	
	public TitledRadioButtons(String title, String buttonText, double height,
			double width, String... choices) {
		this.setSpacing(6);
		this.setAlignment(Pos.CENTER);

		Label choicesTitle = new Label(title);
		this.getChildren().add(choicesTitle);

		VBox choicesBox = new VBox();
		choicesBox.setSpacing(5);
		choicesBox.setStyle(SceneMaker.ROUND_BLACK_BORDER);
		choicesBox.setPadding(new Insets(10, 10, 10, 10));
		choicesBox.setAlignment(Pos.TOP_LEFT);

		if (width > 0) {
			choicesBox.setMinWidth(width);
			choicesBox.setMaxWidth(width);
		}
		if (height > 0) {
			choicesBox.setMinHeight(height);
			choicesBox.setMaxHeight(height);
		}

		ToggleGroup choicesGroup = new ToggleGroup();

		buttons = new ArrayList<RadioButton>(0);

		for (String choice : choices) {
			final RadioButton button = new RadioButton(choice);
			button.setToggleGroup(choicesGroup);
			choicesBox.getChildren().add((RadioButton) button);
			buttons.add(button);
		}

		this.getChildren().add(choicesBox);

		if (!buttonText.isEmpty()) {
			Button nextButton = new Button(buttonText);

			this.getChildren().add(nextButton);

		}
	}
	
	public RadioButton getRadioButton(String buttonText) {
		for (RadioButton button : buttons) {
			if (button.getText().equals(buttonText)) {
				return button;
			}
		}
		return null;
	}
	
	public List<RadioButton> getRadioButtons() {
		return buttons;
	}
}
