package userInterface.gridPanes.nameCreation;

import mainRunner.GameManager;
import mainRunner.GameManager.NameTakenException;
import userInterface.borderPanes.ManageEffectsPane;
import abilities.Ability;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

public class CreateAbilityName extends CreateName {

	public CreateAbilityName(Tab tab) {
		this(tab, null);
	}
	
	public CreateAbilityName(Tab tab, Ability ability) {
		super(tab);
		
		nameBox.getChildren().add(0, new Label("Ability Name: "));
		
		Button nameButton = new Button("Next");
		nameButton.setOnAction((ActionEvent e) -> {
			String nameToUse = nameField.getText();
			if (!nameToUse.isEmpty()) {
				tab.setText("Ability:"+nameToUse);
				Ability newAbility = new Ability(nameToUse, ability);
				try {
					GameManager.addAbility(newAbility);
					tab.setContent(new ManageEffectsPane(newAbility));
				} catch (NameTakenException e1) {
					nameTakenLabel.setVisible(true);
				}
			}
		});
		
		nextBox.getChildren().add(nameButton);
	}

}
