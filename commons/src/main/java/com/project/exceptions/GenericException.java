package com.project.exceptions;

import com.project.stubs.CustomResponse;

public interface GenericException {

    public String getErrorMessage();

    public String getErrorCode();

    public String getErrorType();

    public CustomResponse getResponse();
}
