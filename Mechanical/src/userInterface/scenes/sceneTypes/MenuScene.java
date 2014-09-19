package userInterface.scenes.sceneTypes;

import java.util.ArrayList;
import java.util.List;

import userInterface.SceneMaker;
import userInterface.scenes.sceneTypes.createAbilityEffect.ManageAbilitiesScene;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScene extends Scene {

	private List<Button> menuButtons = new ArrayList<Button>(0);
	private Scene previousScene;
	private String previousTitle;
	
	public MenuScene(String...buttons) {
		this(true,buttons);
	}
	
	public MenuScene(boolean hasBackButton, String...buttons) {
		super(new GridPane());
		
		Stage current = SceneMaker.getStage();
		previousScene = current.getScene();
		previousTitle = current.getTitle();

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		
		for (String button: buttons) {
			menuButtons.add(new Button(button));
		}
		
		VBox buttonHolder = new VBox();
		buttonHolder.setAlignment(Pos.CENTER);
		buttonHolder.setSpacing(15);
		
		for (Button button: menuButtons) {
			buttonHolder.getChildren().add(button);
		}
		
		if (hasBackButton) {
			buttonHolder.getChildren().add(SceneMaker.getBackButton(previousTitle, previousScene));
		}
		
		grid.add(buttonHolder, 0, 0);
		
		this.setRoot(grid);
	}
	
	public Button getMenuButton(String buttonText) {
		for (Button button : menuButtons) {
			if (button.getText().equals(buttonText)) {
				return button;
			}
		}
		return null;
	}
	
	public List<Button> getMenuButtons() {
		return menuButtons;
	}
	
	public static MenuScene getLoadOrNewMenu() {
		MenuScene scene = new MenuScene("Load Save","Start New");
		return scene;
	}
	
	public static MenuScene getCreateMenu() {
		MenuScene scene = new MenuScene("Race","Class","Ability","A.I.","Animation");
		scene.getMenuButton("Ability").setOnAction((ActionEvent e) -> {
			SceneMaker.changeScene("Abilities", new ManageAbilitiesScene());
		});
		return scene;
	}
}
