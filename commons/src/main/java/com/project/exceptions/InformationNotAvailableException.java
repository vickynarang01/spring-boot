package com.project.exceptions;

public class InformationNotAvailableException extends RuntimeException {
        public InformationNotAvailableException(String correlationId) {
            super(correlationId);
        }
}

