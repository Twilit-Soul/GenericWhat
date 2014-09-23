package userInterface.scenes.sceneTypes.createAbilityEffect;

import userInterface.borderPanes.ManageAbilitiesPane;

/**
 * Called when you hit "Ability" in the create menu.
 * @author Mitchell
 */
public class ManageAbilitiesScene extends NewTabPaneScene {
	
	public ManageAbilitiesScene() {
		super();
		tab.setText("Abilities");
		tab.setContent(new ManageAbilitiesPane());
	}
}
