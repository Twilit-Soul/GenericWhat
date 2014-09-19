package effects.attributes;

public enum EffectWhen {
	everyTurn("Every Turn"), damageTaken("Damage Taken"), attackReceived("Attack Received"), damageDealt("Damage Dealt"), attackDone("Attack Done"), onAcquired("On Acquired"), onUse("On Use"), toggle("Toggle");
	//Thresholds:
	//Health certain amount?
	//Damage taken?
	//Damage dealt?
	//Every nth attack/turn?
	
	private final String name;
	
	private EffectWhen(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static EffectWhen fromString(String str) {
		switch (str) {
			case "Every Turn":
				return everyTurn;
			case "Damage Taken":
				return damageTaken;
			case "Attack Received":
				return attackReceived;
			case "Damage Dealt":
				return damageDealt;
			case "Attack Done":
				return attackDone;
			case "On Acquired":
				return onAcquired;
			case "On Use":
				return onUse;
			case "Toggle":
				return toggle;
		}
		
		return null;
	}
	
	public static String[] stringValues() {
		EffectWhen[] values = values();
		String[] stringValues = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			stringValues[i] = values[i].toString();
		}
		
		return stringValues;
	}
}
