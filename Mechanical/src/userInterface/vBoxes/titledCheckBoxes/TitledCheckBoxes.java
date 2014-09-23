package userInterface.vBoxes.titledCheckBoxes;

import userInterface.SceneManager;
import mainRunner.GameManager;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Create a titled section of checkboxes with a border.
 * @author Mitchell
 */
public class TitledCheckBoxes extends VBox {

	/**
	 * @param hasTextField Considering including text box here to further filter something like,
	 * for "X turns", the number of turns.
	 * @param sectionTitle Title of section.
	 * @param labels Label for each checkbox.
	 */
	public TitledCheckBoxes(boolean hasTextField,
			String sectionTitle, String... labels) {
		//Section Container
		this.setSpacing(7);
		
		//Title Container
		HBox sectionTitleBox = new HBox();
		sectionTitleBox.setSpacing(5);
		sectionTitleBox.setPadding(new Insets(0,0,0,7));
		sectionTitleBox.setAlignment(Pos.BASELINE_LEFT);
		sectionTitleBox.setMinHeight(25);
		sectionTitleBox.setMaxHeight(25);
		//Title Text
		Label sectionTitleLabel = new Label(sectionTitle);
		sectionTitleBox.getChildren().add(sectionTitleLabel);
		//If input field, add it along with combo box
		if (hasTextField) {
			sectionTitleBox.getChildren().add(SceneManager.getOperatorsBox());
			TextField textField = new TextField();
			textField.setMaxWidth(80);
			sectionTitleBox.getChildren().add(textField);
		}
		//Add Title Container to Section
		this.getChildren().add(sectionTitleBox);
		//Create check boxes Container
		FlowPane checkBoxesFlowPane = new FlowPane(Orientation.VERTICAL);
		checkBoxesFlowPane.setPrefWrapLength(GameManager.getWindowWidth() * 0.066);
		checkBoxesFlowPane.setHgap(25);
		checkBoxesFlowPane.setVgap(15);
		checkBoxesFlowPane.setPadding(new Insets(9,9,-9,9));
		checkBoxesFlowPane.setStyle(SceneManager.ROUND_BLACK_BORDER);
		//Check boxes
		for (String label: labels) {
			checkBoxesFlowPane.getChildren().add(new CheckBox(label));
		}
		//Add Check boxes container to section
		this.getChildren().add(checkBoxesFlowPane);
	}
}
