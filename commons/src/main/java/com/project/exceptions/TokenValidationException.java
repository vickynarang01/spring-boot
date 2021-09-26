package com.project.exceptions;

import com.project.stubs.CustomError;
import com.project.stubs.CustomResponse;
import com.project.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class TokenValidationException extends Exception implements GenericException {

    private String errorMessage;
    private String errorCode;
    private String errorType;
    private String correlationId;

    public TokenValidationException(String message, String correlationId) {
        super(message);
        this.errorMessage = Constants.TOKEN_VALIDATION_ERROR;
        this.errorCode = Constants.TOKEN_VALIDATION_CODE;
        this.errorType = Constants.TOKEN_VALIDATION_TYPE;
        this.correlationId = correlationId;
    }

    public TokenValidationException(String code, String message, String correlationId) {
        super(message);
        this.errorMessage = message;
        this.errorCode = code;
        this.errorType = Constants.TOKEN_VALIDATION_TYPE;
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
        return new CustomResponse(customErrorList, correlationId,
                String.valueOf(System.currentTimeMillis()), false, null);
    }

}
