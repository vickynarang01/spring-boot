package com.project.service;

import com.project.stubs.AbstractRequest;
import com.project.stubs.CustomResponse;

public interface Service {
    CustomResponse serviceRequest(AbstractRequest request, String correlationId);
}
