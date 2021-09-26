package com.project.exceptions;

import com.project.stubs.CustomError;
import com.project.stubs.CustomResponse;
import com.project.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class JwksExtractionException extends RuntimeException implements GenericException {

	private String errorMessage;
	private String errorCode;
	private String errorType;
	private String correlationId;

	public JwksExtractionException(String errorMessage, String correlationId) {
		super(errorMessage);
		this.errorCode = Constants.JWS_NOT_FOUND_CODE;
		this.errorMessage = errorMessage;
		this.errorType = Constants.JWS_NOT_FOUND_TYPE;
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
