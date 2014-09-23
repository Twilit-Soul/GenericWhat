package userInterface.vBoxes;

import java.util.List;

import mainRunner.GameManager;
import mainRunner.GameManager.NameTakenException;
import userInterface.vBoxes.titledRadioButtons.TitledRadioButtons;
import effects.Effect;
import effects.attributes.EffectAffectsWhat;
import effects.attributes.EffectAffectsWho;
import effects.attributes.EffectDurationType;
import effects.attributes.EffectPowerSource;
import effects.attributes.EffectPowerSourceAttribute;
import effects.attributes.EffectRequiresWhat;
import effects.attributes.EffectStatusType;
import effects.attributes.EffectWhen;
import genericEnums.NumberType;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * This has two parts:
 * The top half, which is a flowpane containing all of the Effect attributes decisions.
 * The bottom half, which is just an "I'm done" button and a "no you're not" message.
 * @author Mitchell
 */
public class ChooseEffectAttributes extends VBox {
	Effect effect;
	
	/**
	 * @param tab When finished, needs this to close its own tab.
	 * @param newEffect This is the effect we're choosing the attributes of.
	 */
	public ChooseEffectAttributes(Tab tab, Effect newEffect) {
		this.effect = newEffect;
		
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		
		//Contains radio button sections
		FlowPane choicesFlowPane = new FlowPane();
		choicesFlowPane.setAlignment(Pos.CENTER);
		choicesFlowPane.setHgap(15);
		choicesFlowPane.setVgap(10);
		choicesFlowPane.setPrefWidth(GameManager.getWindowWidth() * 0.8);
		
		//For each section to reference
		double boxHeight = 200;
		double boxWidth = 130;
		
		List<RadioButton> radioButtons = null;
		
		
		TitledRadioButtons affectsWhoButtons = new TitledRadioButtons("Affects Who", "", boxHeight, boxWidth, EffectAffectsWho.stringValues());
		TitledRadioButtons numberTypeButtons = new TitledRadioButtons("Number Type", "", boxHeight, boxWidth, NumberType.stringValues());
		TitledRadioButtons requiresWhatButtons = new TitledRadioButtons("Requires What", "", boxHeight, boxWidth, EffectRequiresWhat.stringValues());
		TitledRadioButtons durationTypeButtons = new TitledRadioButtons("Duration Type", "", boxHeight, boxWidth, EffectDurationType.stringValues());
		TitledRadioButtons happensWhenButtons = new TitledRadioButtons("Happens When", "", boxHeight, boxWidth, EffectWhen.stringValues());
		TitledRadioButtons powerSourceAttributeButtons = new TitledRadioButtons("Power Source Attribute", "", boxHeight, boxWidth, EffectPowerSourceAttribute.stringValues());
		TitledRadioButtons powerSourceButtons = new TitledRadioButtons("Power Source", "", boxHeight, boxWidth, EffectPowerSource.stringValues());
		TitledRadioButtons statusTypeButtons = new TitledRadioButtons("Status Type", "", boxHeight, boxWidth, EffectStatusType.stringValues());
		TitledRadioButtons affectsWhatButtons = new TitledRadioButtons("Affects What", "", boxHeight, boxWidth, EffectAffectsWhat.stringValues());
		
		//I'll try to break this down...
		
		choicesFlowPane.getChildren().add(affectsWhoButtons);
		radioButtons = affectsWhoButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			//Each radio button section will have something like this,
			//where we select this option if the effect already has this defined.
			//(This means we're working from a template)
			String buttonText = button.getText();
			EffectAffectsWho effectHas = effect.getAffectsWho();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			//This radio button section in particular has to deal with
			//the compatibility of 'self' and other options.
			//Particularly, if you haven't chosen 'self', we limit
			//when the effect can take...er, effect.
			button.setOnAction((ActionEvent e) -> {
				//Set Effect attribute to match button
				effect.setAffectsWho(EffectAffectsWho.fromString(buttonText));
				boolean isSelf = buttonText.equals(EffectAffectsWho.self.toString());
				//Grabbing button references from tempMap
				List<RadioButton> tempButtons = happensWhenButtons.getRadioButtons();
				for (RadioButton tempButton: tempButtons) {
					String tempButtonText = tempButton.getText();
					//Unless it's 'self', only allowing "On Use" and "Toggle"
					boolean isUseOrToggle = tempButtonText.equals(EffectWhen.onUse.toString()) ||
							tempButtonText.equals(EffectWhen.toggle.toString());
					if (!isUseOrToggle) {
						if (isSelf) {
							tempButton.setDisable(false);
						} else {
							tempButton.setDisable(true);
							if (tempButton.isSelected()) {
								effect.setWhen(null);
								tempButton.setSelected(false);
							}
						}
					}
				}
			});
		}
		
		
		choicesFlowPane.getChildren().add(affectsWhatButtons);
		radioButtons = affectsWhatButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectAffectsWhat effectHas = effect.getAffectsWhat();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setAffectsWhat(EffectAffectsWhat.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(statusTypeButtons);
		radioButtons = statusTypeButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectStatusType effectHas = effect.getStatusType();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setStatusType(EffectStatusType.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(powerSourceButtons);
		radioButtons = powerSourceButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectPowerSource effectHas = effect.getPowerSource();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setPowerSource(EffectPowerSource.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(powerSourceAttributeButtons);
		radioButtons = powerSourceAttributeButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectPowerSourceAttribute effectHas = effect.getPowerSourceAttribute();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setPowerSourceAttribute(EffectPowerSourceAttribute.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(happensWhenButtons);
		radioButtons = happensWhenButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectWhen effectHas = effect.getWhen();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setWhen(EffectWhen.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(durationTypeButtons);
		radioButtons = durationTypeButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectDurationType effectHas = effect.getDurationType();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setDurationType(EffectDurationType.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(requiresWhatButtons);
		radioButtons = requiresWhatButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			EffectRequiresWhat effectHas = effect.getRequiresWhat();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setRequiresWhat(EffectRequiresWhat.fromString(buttonText));
			});
		}
		
		
		choicesFlowPane.getChildren().add(numberTypeButtons);
		radioButtons = numberTypeButtons.getRadioButtons();
		for (RadioButton button : radioButtons) {
			String buttonText = button.getText();
			NumberType effectHas = effect.getPowerNumberType();
			if (effectHas != null && buttonText.equals(effectHas.toString())) {
				button.setSelected(true);
			}
			button.setOnAction((ActionEvent e) -> {
				effect.setPowerNumberType(NumberType.fromString(buttonText));
			});
		}
		
		//Add radio sections to overall container
		this.getChildren().add(choicesFlowPane);
		
		Button confirmButton = new Button("Confirm");
		this.getChildren().add(confirmButton);
		
		//Starts out hidden, this is to show errors
		Label errorLabel = new Label();
		errorLabel.setVisible(false);
		
		this.getChildren().add(errorLabel);
		
		confirmButton.setOnAction((ActionEvent e) -> {
			if (effect.isFullyConstructed()) {
				//This be how you close a tab.
				tab.getTabPane().getTabs().remove(tab);
				try {
					//If it's a new effect, then...
					GameManager.addEffect(effect);
					//..it's ALIVE! IT'S ALIIIIVE!
				} catch (NameTakenException e1) {
					//This means we're just modifying the effect so don't need to add it again.
					//(So who cares about your error? SUCK IT)
				}
			} else {
				errorLabel.setText("You forgot a setting.");
				errorLabel.setVisible(true);
			}
		});
	}
}
