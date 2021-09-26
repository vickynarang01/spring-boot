package com.project.util;

import com.project.stubs.CustomError;
import com.project.stubs.CustomResponse;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtils {

    public static CustomResponse getResponse(String code, String error, String type, String correlationId) {

        List<CustomError> customErrorList = new ArrayList<>();
        customErrorList.add(new CustomError(code, error, type));
        return new CustomResponse(customErrorList, correlationId, String.valueOf(System.currentTimeMillis()), false, null);

    }

}
