package com.project.auth.api;

import org.springframework.http.HttpHeaders;

public interface IOauth {
    boolean validate(String userId, HttpHeaders requestHeaders, String correlationId) throws Exception;
}
