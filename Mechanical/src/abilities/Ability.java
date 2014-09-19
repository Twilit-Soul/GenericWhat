package abilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import effects.Effect;
import genericEnums.NumberType;

public class Ability implements Comparable<Ability> {
	private ObservableList<Effect> effects = FXCollections.observableArrayList();
	private String name;
	private NumberType costNumberType;
	private int cost = 0; //default cost is free
	
	public Ability(String name) {
		this(name, null);
	}
	
	public Ability(String name, Ability toCopy) {
		this.name = name;
		if (toCopy != null) {
			this.costNumberType = toCopy.costNumberType;
			this.cost = toCopy.cost;
			this.effects = FXCollections.observableArrayList(toCopy.getEffects());
		}
	}

	public NumberType getCostNumberType() {
		return costNumberType;
	}
	
	public void setCostNumberType(NumberType costNumberType) {
		this.costNumberType = costNumberType;
	}

	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public ObservableList<Effect> getEffects() {
		return effects;
	}
	
	public void addEffect(Effect effect) {
		if (!effects.contains(effect)) {
			effects.add(effect);
		}
	}
	
	public void removeEffect(Effect effect) {
		effects.remove(effect);
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Ability o) {
		return name.compareTo(o.getName());
	}
}