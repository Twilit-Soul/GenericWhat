package userInterface.scenes.sceneTypes.createAbilityEffect;

import userInterface.SceneMaker;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;

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
		
		SceneMaker.setTabPane(tabPane);
//		scene.getStylesheets().add(
//				SceneMaker.class.getResource("/css/addEditAbilityScene.css")
//						.toExternalForm());
	}
}
