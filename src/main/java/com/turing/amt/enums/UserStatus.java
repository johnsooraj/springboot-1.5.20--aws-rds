package com.turing.amt.enums;

public enum UserStatus {

	ACTIVE(1), INACTIVE(2), DEACTIVE(3), PENDING(4);

	private int value;

	private UserStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
