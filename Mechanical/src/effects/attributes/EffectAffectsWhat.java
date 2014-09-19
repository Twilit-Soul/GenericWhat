package effects.attributes;

public enum EffectAffectsWhat {
	health("Health"), power("Power"), hit("Hit"), defense("Defense"), attack("Attack"), status("Status"), ability("Ability"), effect("Effect");
	
	private final String name;
	
	private EffectAffectsWhat(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	/**
	 * This can't stay a switch statement for localization.
	 */
	public static EffectAffectsWhat fromString(String str) {
		switch (str) {
			case "Health":
				return health;
			case "Power":
				return power;
			case "Hit":
				return hit;
			case "Defense":
				return defense;
			case "Attack":
				return attack;
			case "Status":
				return status;
			case "Ability":
				return ability;
			case "Effect":
				return effect;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectAffectsWhat[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
