package userInterface;

import userInterface.scenes.sceneTypes.MenuScene;
import mainRunner.GameManager;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class SceneMaker {
	private static Stage stage;
	private static TabPane currentTabPane;

	public static final String ROUND_BLACK_BORDER = "-fx-border-width: 2px; -fx-border-color: black; -fx-border-radius: 10px;";

	public static void setTabPane(TabPane tabPane) {
		currentTabPane = tabPane;
	}
	
	public static TabPane getTabPane() {
		return currentTabPane;
	}
	
	public static Stage getStage() {
		return stage;
	}

	/**
	 * Updates the scene for the back button, then returns it.
	 * 
	 * @param scene
	 * @return
	 */
	public static Button getBackButton(String previousTitle, Scene previousScene) {
		Button backButton = new Button("Back");
		backButton.setOnAction((ActionEvent e) -> {
			changeScene(previousTitle, previousScene);
		});
		return backButton;
	}

	/**
	 * ChoiceBox with <, <=, =, >=, >.
	 * 
	 * @return
	 */
	public static ChoiceBox<String> getOperatorsBox() {
		ChoiceBox<String> operators = new ChoiceBox<String>();
		operators.getItems().addAll("<", "<=", "=", ">=", ">");
		operators.getSelectionModel().selectFirst();
		operators.setMaxSize(5, 5);
		return operators;
	}

	/**
	 * Changes the window title and the scene.
	 */
	public static void changeScene(String newTitle, Scene scene) {
		changeWindowTitle(newTitle);
		stage.setScene(scene);
	}

	/**
	 * This makes the title screen, with the play/create buttons.
	 * 
	 * @param stage
	 * @return
	 */
	public static void setStartScreenAndSetUpStage(Stage stage) {
		SceneMaker.stage = stage;
		changeWindowTitle("Start");
		MenuScene scene = new MenuScene(false, "Play", "Create");
		scene.getMenuButton("Play").setOnAction((ActionEvent e) -> {
			changeScene("Play", MenuScene.getLoadOrNewMenu());
		});
		scene.getMenuButton("Create").setOnAction((ActionEvent e) -> {
			changeScene("Create", MenuScene.getCreateMenu());
		});
		stage.setScene(scene);
		stage.setHeight(GameManager.getWindowHeight());
		stage.setWidth(GameManager.getWindowWidth());
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}

	/**
	 * Sets previousTitle variable and changes window title.
	 */
	private static void changeWindowTitle(String newTitle) {
		stage.setTitle(newTitle);
	}

}
