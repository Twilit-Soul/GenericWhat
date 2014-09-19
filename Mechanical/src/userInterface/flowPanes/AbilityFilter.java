package userInterface.flowPanes;

import mainRunner.GameManager;
import userInterface.vBoxes.titledCheckBoxes.TitledCheckBoxes;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class AbilityFilter extends FlowPane {
	
	public AbilityFilter() {
		this.setPrefWrapLength(GameManager.getWindowWidth() * 0.8);
		this.setPadding(new Insets(15,15,15,20));
		this.setHgap(30);
		this.setVgap(25);
		
		this.getChildren().add(
				new TitledCheckBoxes(false, "Affects Who", "Target", "Self", "All Enemies", "All Allies", "Everyone"));
		this.getChildren().add(
				new TitledCheckBoxes(false, "Duration Type", "Permanent", "One Battle", "X Turns", "X Battles", "X Seconds"));
		this.getChildren().add(
				new TitledCheckBoxes(false, "Status Type", "Physical", "Disease", "Poison", "Curse", "Magic", "Elemental"));
		this.getChildren().add(
				new TitledCheckBoxes(false, "Happens When", "Every Turn", "Damage Taken", "Attack Received", "Damage Dealt", "Attack Done", "Ability Acquired", "On Use", "Toggle"));
		this.getChildren().add(
				new TitledCheckBoxes(false, "Number Type", "Absolute", "Percent"));
		this.getChildren().add(
				new TitledCheckBoxes(false, "Affects What", "Health", "Power", "Hit", "Defense", "Attack", "Status", "Ability", "Effect"));
		this.getChildren().add(
				new TitledCheckBoxes(false, "Requires", "Nothing", "Effect", "Health", "Power", "Race", "Class"));
	}
}
