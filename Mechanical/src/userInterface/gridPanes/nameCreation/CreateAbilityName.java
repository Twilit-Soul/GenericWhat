package userInterface.gridPanes.nameCreation;

import mainRunner.GameManager;
import mainRunner.GameManager.NameTakenException;
import userInterface.SceneManager;
import userInterface.borderPanes.ManageEffectsPane;
import abilities.Ability;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

/**
 * Starting point of ability creation.
 * @author Mitchell
 */
public class CreateAbilityName extends CreateName {

	/**
	 * For creating a new ability.
	 * @param tab The tab name/content is changed in the creation process.
	 */
	public CreateAbilityName(Tab tab) {
		this(tab, null);
	}
	
	/**
	 * For creating an ability from a template.
	 * @param tab The tab name/content is changed in the creation process.
	 * @param templateAbility This is the ability we're using as a basis.
	 */
	public CreateAbilityName(Tab tab, Ability templateAbility) {
		super(tab);
		
		nameBox.getChildren().add(0, new Label("Ability Name: "));
		
		Button nameButton = new Button("Next");
		nameButton.setOnAction((ActionEvent e) -> {
			String nameToUse = nameField.getText();
			if (!nameToUse.isEmpty()) {
				//Doesn't matter if templateAbility is null. Ability constructor says "whatever"
				Ability newAbility = new Ability(nameToUse, templateAbility);
				tab.setText(SceneManager.abilityTabTitle(newAbility));
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
