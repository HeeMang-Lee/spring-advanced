package org.example.expert.domain.common.exception.dto;

import org.example.expert.domain.common.exception.ErrorCode;

import lombok.Getter;

@Getter
public class ErrorResponseDto {
	private final String errorCode;
	private final String message;

	public ErrorResponseDto(ErrorCode errorCode) {
		this.errorCode = errorCode.getCode();
		this.message = errorCode.getMessage();
	}
}
