package mainRunner;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import effects.Effect;
import abilities.Ability;
import userInterface.SceneMaker;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class GameManager extends Application {
	private static int windowWidth = 1100;
	private static int windowHeight = 700;
	private static HashMap<String, Ability> abilityMap = new HashMap<>(100,1);
	private static HashMap<String, Effect> effectMap = new HashMap<>(100,1);
	private static ObservableList<Ability> abilityList = FXCollections.observableArrayList();
	private static ObservableList<Effect> effectList = FXCollections.observableArrayList();
	private long lastSortedEffect = 0;
	private long lastSortedArray = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		SceneMaker.setStartScreenAndSetUpStage(stage);
		setUpAutoSorts();
	}
	
	private void setUpAutoSorts() {
		effectList.addListener((ListChangeListener<Effect>) change -> {
			long curTime = System.currentTimeMillis();
			if (curTime - lastSortedEffect > 100) {
				lastSortedEffect = curTime;
				Collections.sort(effectList);
			}
		});
		abilityList.addListener((ListChangeListener<Ability>) change -> {
			long curTime = System.currentTimeMillis();
			if (curTime - lastSortedArray > 100) {
				lastSortedArray = curTime;
				Collections.sort(abilityList);
			}
		});
	}
	
	public static int getWindowWidth() {
		return windowWidth;
	}
	
	public static int getWindowHeight() {
		return windowHeight;
	}
	
	public static Collection<Ability> getAllAbilities() {
		return abilityMap.values();
	}
	
	public static void addAbility(Ability ability) throws NameTakenException {
		String abilityName = ability.getName();
		if (!abilityMap.containsKey(abilityName)) {
			abilityMap.put(abilityName, ability);
			abilityList.add(ability);
		} else {
			throw new NameTakenException("Already have ability with name: "+ability);
		}
	}
	
	public static class NameTakenException extends Exception {

		private static final long serialVersionUID = 1L;

		public NameTakenException(String string) {
			super(string);
		}
		
	}
	
	public static Collection<Effect> getAllEffects() {
		return effectMap.values();
	}
	
	public static Effect getEffect(String effectName) {
		return effectMap.get(effectName);
	}
	
	public static void addEffect(Effect effect) throws NameTakenException {
		String effectName = effect.getName();
		if (!effectMap.containsKey(effectName)) {
			effectMap.put(effectName, effect);
			effectList.add(effect);
		} else {
			throw new NameTakenException("Already have effect with name: "+effect);
		}
	}
	
	public static ObservableList<Ability> getAbilityList() {
		return abilityList;
	}
	
	public static ObservableList<Effect> getEffectList() {
		return effectList;
	}
}
