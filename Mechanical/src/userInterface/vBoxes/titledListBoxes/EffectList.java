package userInterface.vBoxes.titledListBoxes;

import java.util.Collections;
import java.util.function.Predicate;

import effects.Effect;
import mainRunner.GameManager;
import abilities.Ability;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import userInterface.SceneMaker;
import userInterface.gridPanes.nameCreation.CreateEffectName;
import userInterface.tabs.EffectTab;
import userInterface.vBoxes.ChooseEffectAttributes;

public class EffectList extends TitledListWithButtons {

	private String nameToCheck = "";
	private long lastSortedBottom = 0;
	private Ability ability;
	
	
	public EffectList(Ability pAbility) {
		super();
		ability = pAbility;

		Label allEffectsLabel = new Label("All Effects");

		this.getChildren().add(1, allEffectsLabel);

		// List of Effects (will be, anyway)
		ListView<Effect> list = new ListView<>();

		FilteredList<Effect> filteredEffectList = GameManager.getEffectList().filtered(p -> true);

		list.setItems(filteredEffectList);
		
		list.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				makeEditAbilityTab(list, ability);
			}
		});
		
		double listHeight = GameManager.getWindowHeight() * 0.33;
		list.setMinHeight(listHeight);
		list.setMaxHeight(listHeight);
		// I want this width to match the filter width.
		list.setMinWidth(filterBoxWidth);
		list.setMaxWidth(filterBoxWidth);
		this.getChildren().add(list); // Add to box

		HBox addRemoveBox = new HBox();
		addRemoveBox.setAlignment(Pos.CENTER);
		addRemoveBox.setMinWidth(filterBoxWidth);
		addRemoveBox.setMaxWidth(filterBoxWidth);
		addRemoveBox.setSpacing(30);

		Button removeEffectButton = new Button("↑");
		addRemoveBox.getChildren().add(removeEffectButton);

		Button addEffectButton = new Button("↓");
		addRemoveBox.getChildren().add(addEffectButton);

		this.getChildren().add(addRemoveBox);

		ListView<Effect> abilityEffectList = new ListView<>();

		ObservableList<Effect> abilityEffectsObsvList = ability.getEffects();
		
		FilteredList<Effect> filteredAbilityEffectList = abilityEffectsObsvList.filtered(p -> true);
		
		abilityEffectList.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				makeEditAbilityTab(abilityEffectList, ability);
			}
		});
		
		abilityEffectList.setItems(filteredAbilityEffectList);

		abilityEffectList.setMinHeight(listHeight);
		abilityEffectList.setMaxHeight(listHeight);
		// I want this width to match the filter width.
		abilityEffectList.setMinWidth(filterBoxWidth);
		abilityEffectList.setMaxWidth(filterBoxWidth);
		this.getChildren().add(abilityEffectList); // Add to box

		removeEffectButton.setOnAction(event -> {
			Effect effect = abilityEffectList.getSelectionModel()
					.getSelectedItem();
			if (effect != null) {
				ability.removeEffect(effect);
				filteredEffectList.setPredicate(getPredicateTopList());
				filteredAbilityEffectList.setPredicate(getPredicateBottomList());
			}
		});

		addEffectButton.setOnAction(event -> {
			Effect effect = list.getSelectionModel().getSelectedItem();
			if (effect != null) {
				ability.addEffect(effect);
				filteredEffectList.setPredicate(getPredicateTopList());
				filteredAbilityEffectList.setPredicate(getPredicateBottomList());
			}
		});
		
		abilityEffectsObsvList.addListener((ListChangeListener<Effect>) change -> {
			long curTime = System.currentTimeMillis();
			if (curTime - lastSortedBottom > 100) {
				lastSortedBottom = curTime;
				Collections.sort(abilityEffectsObsvList);
			}
		});
		
		// Set left side of border pane up
		BorderPane.setAlignment(list, Pos.CENTER);
		BorderPane.setMargin(list, new Insets(12, 12, 12, 12));

		Button makeNewAbilityOrEffectButton = new Button("Make New Effect");

		makeNewAbilityOrEffectButton.setOnAction((ActionEvent e) -> {
			EffectTab newEffectTab = new EffectTab("newEffect00");

			newEffectTab
					.setContent(new CreateEffectName(newEffectTab, ability));
			TabPane tabPane = SceneMaker.getTabPane();
			tabPane.getTabs().add(newEffectTab);
			tabPane.getSelectionModel().select(newEffectTab);
		});
		
		templateButton.setOnAction(event -> {
			EffectTab newEffectTab = new EffectTab("newEffect00");
			Effect templateEffect = list.getSelectionModel().getSelectedItem();

			newEffectTab
					.setContent(new CreateEffectName(newEffectTab, ability, templateEffect));
			TabPane tabPane = SceneMaker.getTabPane();
			tabPane.getTabs().add(newEffectTab);
			tabPane.getSelectionModel().select(newEffectTab);
		});

		buttonBox.getChildren().add(makeNewAbilityOrEffectButton);

		addNameFilter();
		
		filteredEffectList.setPredicate(getPredicateTopList());
		filteredAbilityEffectList.setPredicate(getPredicateBottomList());
		
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			nameToCheck = newValue;
			
			filteredEffectList.setPredicate(getPredicateTopList());
			filteredAbilityEffectList.setPredicate(getPredicateBottomList());
		});
	}
	
	private void makeEditAbilityTab(ListView<Effect> listView, Ability ability) {
		Effect toModify = listView.getSelectionModel().getSelectedItem();
		String effectName = toModify.getName();

		TabPane tabPane = SceneMaker.getTabPane();
		ObservableList<Tab> tabs = tabPane.getTabs();

		boolean needToMake = true;
		for (Tab tab : tabs) {
			if (tab.getText().equals("Effect:" + effectName)) {
				needToMake = false;
				tabPane.getSelectionModel().select(tab);
				break;
			}
		}
		if (needToMake) {
			Tab editAbilityTab = new Tab("Effect:" + effectName);
			editAbilityTab.setContent(new ChooseEffectAttributes(
					editAbilityTab, toModify, ability));
			tabPane.getTabs().add(editAbilityTab);
			tabPane.getSelectionModel().select(editAbilityTab);
		}
	}
	
	private Predicate<Effect> getPredicateTopList() {
		if (!nameToCheck.isEmpty()) {
			return p -> p.getName().startsWith(nameToCheck) && !ability.getEffects().contains(p);
		} else {
			return p -> !ability.getEffects().contains(p);
		}
	}
	
	private Predicate<Effect> getPredicateBottomList() {
		if (!nameToCheck.isEmpty()) {
			return p -> p.getName().startsWith(nameToCheck);
		} else {
			return p -> true;
		}
	}
}
