package userInterface.vBoxes.titledRadioButtons;

import java.util.ArrayList;
import java.util.List;

import userInterface.SceneManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * This is a quick way to get a titled section of radio buttons with a border.
 * @author Mitchell
 */
public class TitledRadioButtons extends VBox {

	protected List<RadioButton> buttons;
	protected Button button;

	/**
	 * @param title Title of the section.
	 * @param buttonText Text of the button you might put at the bottom of this section.
	 * If it's blank, well, no button.  
	 * @param choices Each radio button's label.
	 */
	public TitledRadioButtons(String title, String buttonText, String... choices) {
		this(title, buttonText, 0, 0, choices);
	}
	
	/**
	 * 
	 * @param title Title of the section.
	 * @param buttonText Text of the button you might put at the bottom of this section.
	 * If it's blank, well, no button.
	 * @param height Of the section.
	 * @param width Of the section.
	 * @param choices Each radio button's label.
	 */
	public TitledRadioButtons(String title, String buttonText, double height,
			double width, String... choices) {
		this.setSpacing(6);
		this.setAlignment(Pos.CENTER);

		Label choicesTitle = new Label(title);
		this.getChildren().add(choicesTitle);

		VBox choicesBox = new VBox();
		choicesBox.setSpacing(5);
		choicesBox.setStyle(SceneManager.ROUND_BLACK_BORDER);
		choicesBox.setPadding(new Insets(10, 10, 10, 10));
		choicesBox.setAlignment(Pos.TOP_LEFT);

		//If width/height not specified, let it be free to auto.
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
			button = new Button(buttonText);

			this.getChildren().add(button);

		}
	}
	
	/**
	 * If you gave it a lonely button, you can set the action of it with this reference.
	 */
	public Button getButton() {
		return button;
	}
	
	/**
	 * Get one of the radio buttons by the text!
	 * @param buttonText Name of the button.
	 * @return null if button not found.
	 */
	public RadioButton getRadioButton(String buttonText) {
		for (RadioButton button : buttons) {
			if (button.getText().equals(buttonText)) {
				return button;
			}
		}
		return null;
	}
	
	/**
	 * Get all the radio buttons!
	 */
	public List<RadioButton> getRadioButtons() {
		return buttons;
	}
}
