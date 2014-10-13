package userInterface.gridPanes.nameCreation;

import mainRunner.GameManager;
import effects.Effect;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import userInterface.SceneManager;
import userInterface.vBoxes.ChooseEffectAttributes;

/**
 * Starting point of effect creation.
 * @author Mitchell
 */
@Deprecated
public class CreateEffectName extends CreateName {

	/**
	 * For creating a new effect.
	 * @param tab The tab name/content is changed in the creation process.
	 */
	public CreateEffectName(Tab tab) {
		this(tab,null);
	}

	/**
	 * For creating an effect from a template.
	 * @param tab The tab name/content is changed in the creation process.
	 * @param templateEffect This is the effect we're using as a basis.
	 */
	public CreateEffectName(Tab tab, Effect templateEffect) {
		super(tab);

		Button nameButton = new Button("Next");
		nameButton.setOnAction((ActionEvent e) -> {
			String nameToUse = nameField.getText();
			if (!nameToUse.isEmpty()) {
				Effect newEffect = new Effect(nameToUse, templateEffect);
				if (GameManager.getEffect(nameToUse) == null) {
					tab.setText(SceneManager.effectTabTitle(newEffect));
					tab.setContent(new ChooseEffectAttributes(tab, newEffect));
				} else {
					nameTakenLabel.setVisible(true);
				}
			}
		});

		nextBox.getChildren().add(nameButton);
	}

}
