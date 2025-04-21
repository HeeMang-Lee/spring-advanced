package org.example.expert.domain.common.exception;

import org.example.expert.domain.common.exception.dto.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException e) {
		ErrorCode errorCode = e.getErrorCode();
		return ResponseEntity.status(errorCode.getStatus()).body(new ErrorResponseDto(errorCode));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleAll(Exception e) {
		return ResponseEntity.status(500)
			.body(new ErrorResponseDto(CommonErrorCode.INTERNAL_SERVER_ERROR));
	}
}
