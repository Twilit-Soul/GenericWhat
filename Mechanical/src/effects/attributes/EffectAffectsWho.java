package effects.attributes;

public enum EffectAffectsWho {
	target("Target"), self("Self"), allEnemies("All Enemies"), allAllies("All Allies"), everyone("Everyone");
	
	private final String name;
	
	private EffectAffectsWho(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectAffectsWho fromString(String str) {
		switch (str) {
			case "Target":
				return target;
			case "Self":
				return self;
			case "All Enemies":
				return allEnemies;
			case "All Allies":
				return allAllies;
			case "Everyone":
				return everyone;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectAffectsWho[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
