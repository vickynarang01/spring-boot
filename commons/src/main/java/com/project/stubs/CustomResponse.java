package com.project.stubs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "errors",
        "correlationId",
        "timeStamp",
        "success",
        "payload"
})
public class CustomResponse {

    @JsonProperty("errors")
    private List<CustomError> errors;
    @JsonProperty("correlationId")
    private String correlationId;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("payload")
    private List<GenericResponse> payload = null;

    public CustomResponse(List<CustomError> errors, String correlationId, String timeStamp, Boolean success, List<GenericResponse> payload) {
        this.errors = errors;
        this.correlationId = correlationId;
        this.timeStamp = timeStamp;
        this.success = success;
        this.payload = payload;
    }

    public CustomResponse() {

    }

    @JsonProperty("errors")
    public List<CustomError> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<CustomError> errors) {
        this.errors = errors;
    }

    @JsonProperty("correlationId")
    public String getCorrelationId() {
        return correlationId;
    }

    @JsonProperty("correlationId")
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("payload")
    public List<GenericResponse> getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(List<GenericResponse> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("errors", errors).append("correlationId", correlationId).append("timeStamp", timeStamp).append("success", success).append("payload", payload).toString();
    }

}