package genericEnums;

public enum NumberType {
	percent("Percent"),absolute("Absolute");
	
private final String name;
	
	private NumberType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	/**
	 * This can't stay a switch statement for localization.
	 */
	public static NumberType fromString(String str) {
		switch (str) {
			case "Percent":
				return percent;
			case "Absolute":
				return absolute;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		NumberType[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
