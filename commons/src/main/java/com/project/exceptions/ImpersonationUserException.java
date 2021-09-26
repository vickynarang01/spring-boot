package com.project.exceptions;

public class ImpersonationUserException extends RuntimeException {
    public ImpersonationUserException(String correlationId) {
        super(correlationId);
    }
}
