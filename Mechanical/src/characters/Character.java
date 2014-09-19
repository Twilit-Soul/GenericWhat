package characters;

import java.util.List;

import classTypes.ClassType;
import races.Race;
import abilities.Ability;

public class Character {
	
	private String name;
	private int health;
	private double hitChance;
	private double dodgeChance;
	private int damage;
	private double defense;
	private List<Ability> abilities;
	private Race race;
	private ClassType classType;

	public Character(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getHitChance() {
		return hitChance;
	}

	public void setHitChance(double hitChance) {
		this.hitChance = hitChance;
	}

	public double getDodgeChance() {
		return dodgeChance;
	}

	public void setDodgeChance(double dodgeChance) {
		this.dodgeChance = dodgeChance;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void addAbility(Ability ability) {
		if (!abilities.contains(ability)) {
			abilities.add(ability);
		}
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
}
