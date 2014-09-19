package userInterface.scenes.sceneTypes.createAbilityEffect;

import userInterface.borderPanes.ManageAbilitiesPane;

public class ManageAbilitiesScene extends NewTabPaneScene {
	
	public ManageAbilitiesScene() {
		super();
		tab.setText("Abilities");
		tab.setContent(new ManageAbilitiesPane());
	}
}
