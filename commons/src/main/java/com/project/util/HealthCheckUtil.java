package com.project.util;

import com.project.stubs.CustomResponse;
import com.project.stubs.GenericResponse;
import com.project.stubs.HealthCheckResponse;

import java.util.ArrayList;
import java.util.List;

public class HealthCheckUtil {

    public static CustomResponse getHealthStatus(String apiName) {
        CustomResponse response = new CustomResponse();
        HealthCheckResponse healthCheckResponse = new HealthCheckResponse();
        healthCheckResponse.setApiName(apiName);
        healthCheckResponse.setStatus("200");
        healthCheckResponse.setStatusString("Green");
        List<GenericResponse> list = new ArrayList<>();
        list.add(healthCheckResponse);
        response.setPayload(list);
        return response;
    }
}
