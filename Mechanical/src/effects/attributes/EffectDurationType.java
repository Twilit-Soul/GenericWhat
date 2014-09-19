package effects.attributes;

public enum EffectDurationType {
	permanent("Permanent"), oneBattle("One Battle"), xTurns("X Turns"), xBattles("X Battles"), xSeconds("X Seconds");
	
	private final String name;
	
	private EffectDurationType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectDurationType fromString(String str) {
		switch (str) {
			case "Permanent":
				return permanent;
			case "One Battle":
				return oneBattle;
			case "X Turns":
				return xTurns;
			case "X Battles":
				return xBattles;
			case "X Seconds":
				return xSeconds;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectDurationType[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}