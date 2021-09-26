package com.project.exceptions;

import com.project.stubs.CustomError;
import com.project.stubs.CustomResponse;
import com.project.util.Constants;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.ArrayList;
import java.util.List;

public class TokenVerificationException extends JWTVerificationException implements GenericException {

	private String errorMessage;
	private String errorCode;
	private String errorType;
	private String correlationId;

	public TokenVerificationException(String message, String correlationId) {
		super(message);
		this.errorMessage = message;
		this.errorCode = Constants.TOKEN_VERIFICATION_CODE;
		this.errorType = Constants.TOKEN_VERIFICATION_TYPE;
		this.correlationId = correlationId;
	}

	public TokenVerificationException(String message, String errorCode, String errorType,String correlationId) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
		this.errorType = errorType;
		this.correlationId = correlationId;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getErrorType() {
		return errorType;
	}

	@Override
	public CustomResponse getResponse() {
		List<CustomError> customErrorList = new ArrayList<>();
		customErrorList.add(new CustomError(this.getErrorCode(), this.getErrorMessage(), this.getErrorType()));
		return new CustomResponse(customErrorList,
				correlationId,
				String.valueOf(System.currentTimeMillis()), false, null);
	}
}
