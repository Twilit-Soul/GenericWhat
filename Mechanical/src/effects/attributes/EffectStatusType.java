package effects.attributes;

public enum EffectStatusType {
	physical("Physical"), disease("Disease"), poison("Poison"), curse("Curse"), magic("Magic"), elemental("Elemental");
	
	private final String name;
	
	private EffectStatusType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectStatusType fromString(String str) {
		switch (str) {
			case "Physical":
				return physical;
			case "Disease":
				return disease;
			case "Poison":
				return poison;
			case "Curse":
				return curse;
			case "Magic":
				return magic;
			case "Elemental":
				return elemental;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectStatusType[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
