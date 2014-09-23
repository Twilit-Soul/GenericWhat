package userInterface.borderPanes;

import abilities.Ability;
import userInterface.flowPanes.EffectFilter;
import userInterface.vBoxes.titledListBoxes.EffectList;
import javafx.scene.layout.BorderPane;

/**
 * Contains the effect list and the effect filters.
 * @author Mitchell
 */
public class ManageEffectsPane extends BorderPane {
	
	public ManageEffectsPane(Ability ability) {
		this.setLeft(new EffectList(ability));
		this.setCenter(new EffectFilter());
	}
	
}
