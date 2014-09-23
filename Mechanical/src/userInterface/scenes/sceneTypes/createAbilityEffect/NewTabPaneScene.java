package userInterface.scenes.sceneTypes.createAbilityEffect;

import userInterface.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;

/**
 * This is the basis for the ManageAbilitiesScene, but can likely be used later by others.
 * @author Mitchell
 */
public abstract class NewTabPaneScene extends Scene {
	protected Tab tab;
	
	public NewTabPaneScene() {
		super(new GridPane());
		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.ALL_TABS);
		
		//Tab for abilities/effects list
		tab = new Tab();

		tabPane.getTabs().add(tab);
		tab.setClosable(false);
		
		this.setRoot(tabPane);
		
		SceneManager.setTabPane(tabPane);
		//This was a failed experiment to get rid of the arrow on a choice box.
		//I still want to remember how to use style sheets.
//		scene.getStylesheets().add(
//				SceneMaker.class.getResource("/css/addEditAbilityScene.css")
//						.toExternalForm());
	}
}
