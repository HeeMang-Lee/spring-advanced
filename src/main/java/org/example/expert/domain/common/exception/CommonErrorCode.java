package org.example.expert.domain.common.exception;

public enum CommonErrorCode implements ErrorCode {
	INVALID_INPUT("INVALID_INPUT", "입력값이 올바르지 않습니다.", 400),
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "서버 내부 오류입니다.", 500);

	private final String code;
	private final String message;
	private final int status;

	CommonErrorCode(String code, String message, int status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public int getStatus() {
		return status;
	}
}
