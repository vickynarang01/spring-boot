package com.project.network;

import com.project.exceptions.AuthorizationException;
import com.project.exceptions.InformationNotAvailableException;
import com.project.stubs.GenericRequest;
import com.project.stubs.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestNetworkAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AbstractRestNetworkAdapter.class);

    public <T extends GenericResponse> ResponseEntity<T> executeGetResult(String url, String correlationId, Class<T> responseType, RestTemplate restTemplate) {
        return executeGetResult(url, correlationId, responseType, restTemplate, getDefaultHttpEntity());
    }

    public <T extends GenericResponse> ResponseEntity<T> executeGetResult(String url, String correlationId, Class<T> responseType, RestTemplate restTemplate, HttpEntity httpEntity) {
        return execute(url, correlationId, responseType, HttpMethod.GET, httpEntity, restTemplate);
    }

    public <T extends GenericResponse, S extends GenericRequest> ResponseEntity<T> executePostResult(S request, String url, String  correlationId, Class<T> responseType, RestTemplate restTemplate) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Correlation-Id", correlationId);
        HttpEntity<S> httpEntityRequest = new HttpEntity<>(request, httpHeaders);
        return execute(url, correlationId, responseType, HttpMethod.POST, httpEntityRequest, restTemplate);
    }

    public <T extends GenericResponse> ResponseEntity<T> executePostResult(HttpEntity<MultiValueMap<String, String>> httpEntityRequest, String url, String  correlationId, Class<T> responseType, RestTemplate restTemplate) {
        return execute(url, correlationId, responseType, HttpMethod.POST, httpEntityRequest, restTemplate);
    }

    private HttpEntity getDefaultHttpEntity() {
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(httpHeaders);
    }

    private <T extends GenericResponse> ResponseEntity<T> execute(String url, String correlationId, Class<T> responseType, HttpMethod httpMethod, HttpEntity httpEntityRequest, RestTemplate restTemplate) {
        ResponseEntity<T> response = null;
        try {
            logger.info("Time in millis before calling Request to Retrieve {} function, {}", responseType.getName(), System.currentTimeMillis());
            response = restTemplate.exchange(url, httpMethod, httpEntityRequest, responseType);
            logger.info("Time in millis after calling Request to Retrieve {} function, {}", responseType.getName(), System.currentTimeMillis());
        } catch(HttpClientErrorException e) {
            logger.error("errorMessage: {}", e.getMessage(), e);
            if (e.getRawStatusCode() == 401) {
                throw new AuthorizationException(correlationId);
            }
        } catch(RestClientException e) {
            logger.error("errorMessage: {}", e.getMessage());
            throw new InformationNotAvailableException(correlationId);
        }
        return response;
    }
}