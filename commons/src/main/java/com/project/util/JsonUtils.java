package com.project.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.IOException;


public class JsonUtils {

    private JsonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Object createObjectFromJsonFile(String sourceFileName, Class classOfObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(ResourceUtils.getFile(sourceFileName), classOfObject);
    }

}