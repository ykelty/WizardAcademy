package mathdrill.util;

public enum SessionVariable {
	COMPLIMENTARY_PASS_FLAG("mathdrill.flag.iscomplimentarypass");

	private String value;

	private SessionVariable(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
