package userInterface.gridPanes.nameCreation;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class CreateName extends GridPane {

	protected Tab tab;
	protected HBox nameBox;
	protected HBox nextBox;
	protected TextField nameField;
	protected Label nameTakenLabel;
	
	public CreateName(Tab pTab) {
		tab = pTab;
		
		this.setAlignment(Pos.CENTER);
		
		nameBox = new HBox();
		nameBox.setSpacing(10);
		nameBox.setAlignment(Pos.CENTER);
		
		nameField = new TextField();
		nameBox.getChildren().add(nameField);
		
		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);
		container.setSpacing(20);
		container.getChildren().add(nameBox);
		
		nextBox = new HBox();
		nextBox.setAlignment(Pos.BASELINE_RIGHT);
		
		container.getChildren().add(nextBox);
		
		nameTakenLabel = new Label("Name already taken.");
		nameTakenLabel.setVisible(false);
		
		container.getChildren().add(nameTakenLabel);
		
		this.add(container, 0, 0);
	}

}
