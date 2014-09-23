package userInterface.scenes.sceneTypes;

import java.util.ArrayList;
import java.util.List;

import userInterface.SceneManager;
import userInterface.scenes.sceneTypes.createAbilityEffect.ManageAbilitiesScene;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Easy construction of a scene with vertical list of buttons.
 * Auto-makes a back button if this isn't the starting scene.
 * @author Mitchell
 */
public class MenuScene extends Scene {

	private List<Button> menuButtons = new ArrayList<Button>(0);
	private Scene previousScene;
	private String previousTitle;
	
	/**
	 * Just makes a scene with a back button.
	 * @param buttons The names of the menu buttons.
	 */
	public MenuScene(String...buttons) {
		this(true,buttons);
	}
	
	/**
	 * We can use this to make the first scene without a back button easily.
	 * @param hasBackButton false for no back button.
	 * @param buttons The names of the menu buttons.
	 */
	public MenuScene(boolean hasBackButton, String...buttons) {
		super(new GridPane());
		
		Stage current = SceneManager.getStage();
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
			buttonHolder.getChildren().add(SceneManager.getBackButton(previousTitle, previousScene));
		}
		
		grid.add(buttonHolder, 0, 0);
		
		this.setRoot(grid);
	}
	
	/**
	 * Get a menu button button by its text.
	 */
	public Button getMenuButton(String buttonText) {
		for (Button button : menuButtons) {
			if (button.getText().equals(buttonText)) {
				return button;
			}
		}
		return null;
	}
	
	/**
	 * Get all menu buttons.
	 * @return
	 */
	public List<Button> getMenuButtons() {
		return menuButtons;
	}
	
	/**
	 * Called when you hit the "play" button.
	 */
	public static MenuScene getLoadOrNewMenu() {
		MenuScene scene = new MenuScene("Load Save","Start New");
		return scene;
	}
	
	/**
	 * Called when you hit the "create" button.
	 * @return
	 */
	public static MenuScene getCreateMenu() {
		MenuScene scene = new MenuScene("Race","Class","Ability","A.I.","Animation");
		scene.getMenuButton("Ability").setOnAction((ActionEvent e) -> {
			SceneManager.changeScene("Abilities", new ManageAbilitiesScene());
		});
		return scene;
	}
}
