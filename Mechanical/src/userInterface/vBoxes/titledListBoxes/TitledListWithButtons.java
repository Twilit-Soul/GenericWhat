package userInterface.vBoxes.titledListBoxes;

import mainRunner.GameManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class TitledListWithButtons extends VBox {
	
	protected FlowPane buttonBox;
	protected double filterLabelWidth;
	protected double filterFieldWidth;
	protected double filterBoxWidth;
	protected int spacing;
	protected TextField filterField;
	protected Button templateButton;

	public TitledListWithButtons() {
		//Vbox for left pane in ability list tab
		this.setTranslateX(10);
		this.setTranslateY(10);
		this.setSpacing(10);
		
		filterLabelWidth = GameManager.getWindowWidth() * 0.034;
		filterFieldWidth = GameManager.getWindowWidth() * 0.19;
		
		spacing = 10;

		filterBoxWidth = filterLabelWidth + filterFieldWidth + spacing;
		
		//Button to make new from current
		templateButton = new Button("Use As Template");
		
		//HBox to have bottom buttons
		buttonBox = new FlowPane();
		buttonBox.setHgap(10);
		buttonBox.setVgap(10);
		buttonBox.setPrefWrapLength(filterBoxWidth);
		buttonBox.getChildren().add(templateButton);
		this.getChildren().add(buttonBox);
	}
	
	protected void addNameFilter() {
		addNameFilter(-1);
	}
	
	protected void addNameFilter(int index) {
		
		//HBox for label and filter text
		HBox filterBox = new HBox();
		filterBox.setSpacing(spacing);
		
		//Filter label
		Label filterLabel = new Label("Name: ");
		filterLabel.setMinWidth(filterLabelWidth);
		filterLabel.setMaxWidth(filterLabelWidth);
		filterBox.getChildren().add(filterLabel);
		
		//Filter text input
		filterField = new TextField();
		filterField.setMinWidth(filterFieldWidth);
		filterField.setMaxWidth(filterFieldWidth);
		filterBox.getChildren().add(filterField);
		
		if (index > -1) {
			this.getChildren().add(index, filterBox);
		} else {
			this.getChildren().add(filterBox);
		}
	}
}
