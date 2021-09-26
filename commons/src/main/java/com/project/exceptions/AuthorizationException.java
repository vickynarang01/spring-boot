package com.project.exceptions;

public class AuthorizationException extends RuntimeException{

    public AuthorizationException(String correlationId) {
        super(correlationId);
    }
}