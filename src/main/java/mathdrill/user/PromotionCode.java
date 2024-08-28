package mathdrill.user;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PromotionCode {

	DEFAULT("default"), LEAP_AHEAD("leapahead"), STAY_AHEAD("stayahead");

	private static final Map<String, PromotionCode> valueMap = new HashMap<String, PromotionCode>();

	static {
		for (PromotionCode code : EnumSet.allOf(PromotionCode.class)) {
			valueMap.put(code.getValue(), code);
		}
	}

	public static PromotionCode findByValue(String value) {
		return valueMap.get(value);
	}

	private String value;

	private PromotionCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
