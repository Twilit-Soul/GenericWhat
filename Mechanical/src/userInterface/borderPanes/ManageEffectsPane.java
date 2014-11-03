package userInterface.borderPanes;

import mainRunner.GameManager;
import abilities.Ability;
import userInterface.SceneManager;
import userInterface.flowPanes.EffectFilter;
import userInterface.vBoxes.titledListBoxes.EffectList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Contains the effect list and the effect filters for an ability.
 * @author Mitchell
 */
public class ManageEffectsPane extends BorderPane {
	
	public ManageEffectsPane(Ability ability) {
		this.setLeft(new EffectList(ability));
		
		VBox filters = new VBox();
		filters.setSpacing(20);
		filters.getChildren().add(new EffectFilter());
		
		//Rename Ability Section//
		
		HBox renameAbilityBox = new HBox();
		renameAbilityBox.setPadding(new Insets(0,0,0,20));
		renameAbilityBox.setSpacing(10);
		
		Label renameAbilityLabel = new Label("Rename Ability: ");
		
		TextField renameAbilityField = new TextField();
		renameAbilityField.setText(ability.getName());
		
		Label nameTakenLabel = new Label("");
		
		renameAbilityField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!GameManager.abilityExists(newValue)) {
				ability.setName(newValue);
				SceneManager.getTabPane().getSelectionModel().getSelectedItem().setText(SceneManager.abilityTabTitle(ability));
				//Forces the list to update and re-sort
				GameManager.sortAbilityList();
				nameTakenLabel.setText("");
			} else {
				nameTakenLabel.setText(newValue+" is taken already.");
			}
        });
		
		renameAbilityBox.getChildren().add(renameAbilityLabel);
		renameAbilityBox.getChildren().add(renameAbilityField);
		renameAbilityBox.getChildren().add(nameTakenLabel);
		
		filters.getChildren().add(renameAbilityBox);
		
		//Rename Ability Section//
		
		this.setCenter(filters);
	}
	
}
