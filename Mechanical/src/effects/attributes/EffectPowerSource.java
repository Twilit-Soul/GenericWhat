package effects.attributes;

public enum EffectPowerSource {
	user("User"), target("Target");
	
	private final String name;
	
	private EffectPowerSource(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectPowerSource fromString(String str) {
		switch (str) {
			case "User":
				return user;
			case "Target":
				return target;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectPowerSource[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
