package com.project.util;

import org.springframework.http.HttpHeaders;

import java.util.Objects;

public class CorrelationIdUtil {

    private CorrelationIdUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String getCorrelationId(HttpHeaders requestHeaders) {
        if (requestHeaders.containsKey(Constants.CORRELATION_ID)
                && requestHeaders.get(Constants.CORRELATION_ID) != null
                && !Objects.requireNonNull(requestHeaders.get(Constants.CORRELATION_ID)).isEmpty()) {
            return requestHeaders.getFirst(Constants.CORRELATION_ID);
        }
        return null;
    }
}
