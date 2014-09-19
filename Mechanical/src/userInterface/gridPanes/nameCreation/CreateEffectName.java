package userInterface.gridPanes.nameCreation;

import mainRunner.GameManager;
import abilities.Ability;
import effects.Effect;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import userInterface.tabs.EffectTab;
import userInterface.vBoxes.ChooseEffectAttributes;

public class CreateEffectName extends CreateName {

	public CreateEffectName(EffectTab tab, Ability ability) {
		this(tab,ability,null);
	}

	public CreateEffectName(EffectTab tab, Ability ability, Effect templateEffect) {
		super(tab);

		Button nameButton = new Button("Next");
		nameButton.setOnAction((ActionEvent e) -> {
			String nameToUse = nameField.getText();
			if (!nameToUse.isEmpty()) {
				Effect newEffect = new Effect(nameToUse, templateEffect);
				if (GameManager.getEffect(nameToUse) == null) {
					tab.setText("Effect:"+nameToUse);
					tab.setContent(new ChooseEffectAttributes(tab, newEffect, ability));
				} else {
					nameTakenLabel.setVisible(true);
				}
			}
		});

		nextBox.getChildren().add(nameButton);
	}

}
