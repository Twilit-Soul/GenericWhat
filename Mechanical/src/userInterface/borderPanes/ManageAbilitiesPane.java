package userInterface.borderPanes;

import userInterface.flowPanes.AbilityFilter;
import userInterface.vBoxes.titledListBoxes.AbilityList;
import javafx.scene.layout.BorderPane;

/**
 * Contains the ability list and the ability filters.
 * @author Mitchell
 */
public class ManageAbilitiesPane extends BorderPane {
	
	public ManageAbilitiesPane() {
		this.setLeft(new AbilityList());
		this.setCenter(new AbilityFilter());
	}
	
}
