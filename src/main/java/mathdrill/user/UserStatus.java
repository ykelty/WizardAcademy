package mathdrill.user;

public enum UserStatus {
	ACTIVE("active"), INACTIVE("inactive"), FUTURE_ACTIVE("future_active"), NEW("new");

	private String value;

	private UserStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
