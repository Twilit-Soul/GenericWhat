package userInterface.borderPanes;

import userInterface.flowPanes.AbilityFilter;
import userInterface.vBoxes.titledListBoxes.AbilityList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Contains the ability list and the ability filters.
 * @author Mitchell
 */
public class ManageAbilitiesPane extends BorderPane {
	
	public ManageAbilitiesPane() {
		this.setLeft(new AbilityList());
		
		VBox filters = new VBox();
		filters.setSpacing(20);
		filters.getChildren().add(new AbilityFilter());
		
		
		
		this.setCenter(filters);
	}
	
}
