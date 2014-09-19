package effects.attributes;

public enum EffectPowerSourceAttribute {
	health("Health"), power("Power"), defense("Defense"), attack("Attack");
	
	private final String name;
	
	private EffectPowerSourceAttribute(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectPowerSourceAttribute fromString(String str) {
		switch (str) {
			case "Health":
				return health;
			case "Power":
				return power;
			case "Defense":
				return defense;
			case "Attack":
				return attack;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectPowerSourceAttribute[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
