package userInterface.vBoxes.titledListBoxes;

import java.util.function.Predicate;

import abilities.Ability;
import mainRunner.GameManager;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import userInterface.SceneManager;
import userInterface.gridPanes.nameCreation.CreateAbilityName;
import userInterface.borderPanes.ManageEffectsPane;

/**
 * The list for managing all abilities in the game.
 * @author Mitchell
 */
public class AbilityList extends TitledListWithButtons {

	private Predicate<Ability> predicate = null;
	private String nameToCheck = "";
	
	public AbilityList() {
		super();
		
		ListView<Ability> list = new ListView<>();
		
		FilteredList<Ability> filteredList = GameManager.getAbilityList().filtered(p -> true);
		
		list.setItems(filteredList);
		
		double listHeight = GameManager.getWindowHeight() * 0.75;
		list.setMinHeight(listHeight);
		list.setMaxHeight(listHeight);
		//I want this width to match the filter width.
		list.setMinWidth(filterBoxWidth);
		list.setMaxWidth(filterBoxWidth);
		
		list.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				Ability toModify = list.getSelectionModel().getSelectedItem();
				String abilityName = toModify.getName();
				
				TabPane tabPane = SceneManager.getTabPane();
				ObservableList<Tab> tabs = tabPane.getTabs();
				
				boolean needToMake = true;
				for (Tab tab: tabs) {
					if (tab.getText().equals("Ability:"+abilityName)) {
						needToMake = false;
						tabPane.getSelectionModel().select(tab);
						break;
					}
				}
				if (needToMake) {
					Tab editAbilityTab = new Tab("Ability:"+abilityName);
					editAbilityTab.setContent(new ManageEffectsPane(toModify));
					tabPane.getTabs().add(editAbilityTab);
					tabPane.getSelectionModel().select(editAbilityTab);
				}
			}
		});
		
		this.getChildren().add(1, list); //Add to box
		
		//Set left side of border pane up
		BorderPane.setAlignment(list, Pos.CENTER);
		BorderPane.setMargin(list, new Insets(12,12,12,12));
		
		Button makeNewAbilityOrEffectButton = new Button("Make New Ability");
		makeNewAbilityOrEffectButton.setOnAction((ActionEvent e) -> {
			Tab newAbilityTab = new Tab("newAbility00");
			
			newAbilityTab.setContent(new CreateAbilityName(newAbilityTab));
			TabPane tabPane = SceneManager.getTabPane();
			tabPane.getTabs().add(newAbilityTab);
			tabPane.getSelectionModel().select(newAbilityTab);
		});
		
		templateButton.setOnAction(event -> {
			Tab newAbilityTab = new Tab("newAbility00");
			Ability templateAbility = list.getSelectionModel().getSelectedItem();
			newAbilityTab.setContent(new CreateAbilityName(newAbilityTab, templateAbility));
			TabPane tabPane = SceneManager.getTabPane();
			tabPane.getTabs().add(newAbilityTab);
			tabPane.getSelectionModel().select(newAbilityTab);
		});
		
		buttonBox.getChildren().add(makeNewAbilityOrEffectButton);
		
		addNameFilter();
		
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			nameToCheck = newValue;
			updatePredicate();
			
			filteredList.setPredicate(predicate);
		});
		
	}
	
	/**
	 * Filter the list by name.
	 */
	private void updatePredicate() {
		if (!nameToCheck.isEmpty()) {
			predicate = p -> p.getName().startsWith(nameToCheck);
		} else {
			predicate = p -> true;
		}
	}

}
