package effects.attributes;

public enum EffectRequiresWhat {
	nothing("Nothing"), effect("Effect"), health("Health"), power("Power"), race("Race"), classType("Class");
	
	private final String name;
	
	private EffectRequiresWhat(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectRequiresWhat fromString(String str) {
		switch (str) {
			case "Health":
				return health;
			case "Power":
				return power;
			case "Nothing":
				return nothing;
			case "Effect":
				return effect;
			case "Race":
				return race;
			case "Class":
				return classType;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectRequiresWhat[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
