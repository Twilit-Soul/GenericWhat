package userInterface.borderPanes;

import abilities.Ability;
import userInterface.flowPanes.EffectFilter;
import userInterface.vBoxes.titledListBoxes.EffectList;
import javafx.scene.layout.BorderPane;

public class ManageEffectsPane extends BorderPane {
	
	EffectList effectList;
	EffectFilter effectFilter;
	Ability ability;
	 
	public ManageEffectsPane(Ability ability) {
		this.ability = ability;
		effectList = new EffectList(ability);
		effectFilter = new EffectFilter(ability);
		
		this.setLeft(effectList);
		this.setCenter(effectFilter);
	}
	
}
