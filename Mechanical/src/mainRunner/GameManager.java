package mainRunner;

import java.util.Collections;
import java.util.HashMap;

import effects.Effect;
import abilities.Ability;
import userInterface.SceneManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class GameManager extends Application {
	private static final int windowWidth = 1100;
	private static final int windowHeight = 700;
	private static HashMap<String, Ability> abilityMap = new HashMap<>(100,1);
	private static HashMap<String, Effect> effectMap = new HashMap<>(100,1);
	private static ObservableList<Ability> abilityList = FXCollections.observableArrayList();
	private static ObservableList<Effect> effectList = FXCollections.observableArrayList();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		SceneManager.setStartScreenAndSetUpStage(stage);
	}
	
	/**
	 * @return The decided window width for the game.
	 */
	public static int getWindowWidth() {
		return windowWidth;
	}
	
	/**
	 * @return The decided window height for the game.
	 */
	public static int getWindowHeight() {
		return windowHeight;
	}
	
	/**
	 * Note: you can't add an ability with the same name as another ability.
	 * @param ability
	 * @throws NameTakenException
	 */
	public static void addAbility(Ability ability) throws NameTakenException {
		String abilityName = ability.getName();
		if (!abilityMap.containsKey(abilityName)) {
			abilityMap.put(abilityName, ability);
			abilityList.add(ability);
			Collections.sort(abilityList);
		} else {
			throw new NameTakenException("Already have ability with name: "+ability);
		}
	}
	
	/**
	 * Is it a necessary class? Is it an unnecessary class?
	 * Oooooh it's stilll a mysterryyyy
	 * @author Mitchell
	 */
	public static class NameTakenException extends Exception {

		private static final long serialVersionUID = 1L;

		public NameTakenException(String string) {
			super(string);
		}
		
	}
	
	/**
	 * Retrieves an Effect object by name.
	 * @param effectName
	 */
	public static Effect getEffect(String effectName) {
		return effectMap.get(effectName);
	}
	
	/**
	 * Note: you can't add an effect with the same name as another effect.
	 * @param effect
	 * @throws NameTakenException
	 */
	public static void addEffect(Effect effect) throws NameTakenException {
		String effectName = effect.getName();
		if (!effectMap.containsKey(effectName)) {
			effectMap.put(effectName, effect);
			effectList.add(effect);
			Collections.sort(effectList);
		} else {
			throw new NameTakenException("Already have effect with name: "+effect);
		}
	}
	
	/**
	 * @return (All abilities that have been made)
	 */
	public static ObservableList<Ability> getAbilityList() {
		return abilityList;
	}
	
	/**
	 * @return (All effects that have been made)
	 */
	public static ObservableList<Effect> getEffectList() {
		return effectList;
	}
}
