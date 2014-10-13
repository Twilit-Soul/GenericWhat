package effects;

import effects.attributes.EffectAffectsWhat;
import effects.attributes.EffectAffectsWho;
import effects.attributes.EffectDurationType;
import effects.attributes.EffectPowerSource;
import effects.attributes.EffectPowerSourceAttribute;
import effects.attributes.EffectRequiresWhat;
import effects.attributes.EffectStatusType;
import effects.attributes.EffectWhen;
import genericEnums.NumberType;

public class Effect implements Comparable<Effect> {

	private EffectAffectsWho affectsWho = null;
	private EffectDurationType durationType = null;
	private EffectStatusType statusType = null;
	private EffectWhen whenHappens = null;
	private NumberType powerNumberType = null;
	private EffectAffectsWhat affectsWhat = null;
	private EffectRequiresWhat requiresWhat = EffectRequiresWhat.nothing; // default
																			// is
																			// "just happens"
	private EffectPowerSource powerSource = null;
	private EffectPowerSourceAttribute powerSourceAttribute = null;
	
	private int threshold;
	private String name;
	private int power;
	private int duration;
	private int successRate = 100; // default chance is always works

	public Effect() {
		this(null,null);
	}
	
	public Effect(String name) {
		this(name,null);
	}
	
	public Effect(Effect toCopy) {
		this(null,toCopy);
	}
	
	/**
	 * @param toCopy The effect passed in is copied.
	 */
	public Effect(String name, Effect toCopy) {
		if (name != null) {
			this.name = name;
		}
		if (toCopy != null) {
			this.affectsWho = toCopy.affectsWho;
			this.durationType = toCopy.durationType;
			this.statusType = toCopy.statusType;
			this.whenHappens = toCopy.whenHappens;
			this.powerNumberType = toCopy.powerNumberType;
			this.affectsWhat = toCopy.affectsWhat;
			this.requiresWhat = toCopy.requiresWhat;
			this.powerSource = toCopy.powerSource;
			this.powerSourceAttribute = toCopy.powerSourceAttribute;
			this.threshold = toCopy.threshold;
			this.power = toCopy.power;
			this.duration = toCopy.duration;
			this.successRate = toCopy.successRate;
		}
	}

	public void setWhen(EffectWhen whenHappens) {
		this.whenHappens = whenHappens;
	}
	
	public EffectWhen getWhen() {
		return whenHappens;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	public int getThreshold() {
		return threshold;
	}

	public void setAffectsWho(EffectAffectsWho affectsWho) {
		this.affectsWho = affectsWho;
	}
	
	public EffectAffectsWho getAffectsWho() {
		return affectsWho;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}

	public void setPowerNumberType(NumberType powerNumberType) {
		this.powerNumberType = powerNumberType;
	}
	
	public NumberType getPowerNumberType() {
		return powerNumberType;
	}

	public void setDurationType(EffectDurationType durationType) {
		this.durationType = durationType;
	}
	
	public EffectDurationType getDurationType() {
		return durationType;
	}

	public void setStatusType(EffectStatusType statusType) {
		this.statusType = statusType;
	}
	
	public EffectStatusType getStatusType() {
		return statusType;
	}

	public void setAffectsWhat(EffectAffectsWhat affectsWhat) {
		this.affectsWhat = affectsWhat;
	}

	public EffectAffectsWhat getAffectsWhat() {
		return affectsWhat;
	}

	public void setRequiresWhat(EffectRequiresWhat requiresWhat) {
		this.requiresWhat = requiresWhat;
	}

	public EffectRequiresWhat getRequiresWhat() {
		return requiresWhat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}

	public int getSuccessRate() {
		return successRate;
	}

	public EffectPowerSource getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(EffectPowerSource powerSource) {
		this.powerSource = powerSource;
	}

	public EffectPowerSourceAttribute getPowerSourceAttribute() {
		return powerSourceAttribute;
	}

	public void setPowerSourceAttribute(
			EffectPowerSourceAttribute powerSourceAttribute) {
		this.powerSourceAttribute = powerSourceAttribute;
	}

	/**
	 * I don't think this is still used.
	 * I don't know if this was ever a good idea.
	 * @param toUse The class of the attribute we're setting.
	 * @param choiceText The string value of the assignment.
	 */
	public void setAttribute(Class<?> toUse, String choiceText) {
		if (toUse == EffectPowerSourceAttribute.class) {
			powerSourceAttribute = EffectPowerSourceAttribute.fromString(choiceText);
		} else if (toUse == EffectAffectsWhat.class) {
			affectsWhat = EffectAffectsWhat.fromString(choiceText);
		} else if (toUse == EffectPowerSource.class) {
			powerSource = EffectPowerSource.fromString(choiceText);
		} else if (toUse == EffectRequiresWhat.class) {
			requiresWhat = EffectRequiresWhat.fromString(choiceText);
		} else if (toUse == NumberType.class) {
			powerNumberType = NumberType.fromString(choiceText);
		} else if (toUse == EffectWhen.class) {
			whenHappens = EffectWhen.fromString(choiceText);
		} else if (toUse == EffectStatusType.class) {
			statusType = EffectStatusType.fromString(choiceText);
		} else if (toUse == EffectDurationType.class) {
			durationType = EffectDurationType.fromString(choiceText);
		} else if (toUse == EffectAffectsWho.class) {
			affectsWho = EffectAffectsWho.fromString(choiceText);
		} else {
			throw new IllegalArgumentException("Not an attribute of effect.");
		}
	}
	
	/**
	 * Checks (or will check) to see if anything is null.
	 */
	public boolean isFullyConstructed() {
		return affectsWho != null &&
				durationType != null &&
				statusType != null &&
				whenHappens != null &&
				powerNumberType != null &&
				affectsWhat != null &&
				requiresWhat != null &&
				powerSource != null &&
				powerSourceAttribute != null &&
				name != null;
	}

	/**
	 * For sorting.
	 */
	@Override
	public int compareTo(Effect o) {
		return name.compareTo(o.getName());
	}
}
