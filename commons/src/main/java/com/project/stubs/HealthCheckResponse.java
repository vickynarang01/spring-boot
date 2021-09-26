package com.project.stubs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "apiName",
        "status",
        "statusString"
})
public class HealthCheckResponse implements GenericResponse {

    @JsonProperty("apiName")
    private String apiName;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusString")
    private String statusString;

    @JsonProperty("apiName")
    public String getApiName() {
        return apiName;
    }

    @JsonProperty("apiName")
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("statusString")
    public String getStatusString() {
        return statusString;
    }

    @JsonProperty("statusString")
    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HealthCheckResponse.class.getSimpleName() + "[", "]")
                .add("apiName='" + apiName + "'")
                .add("status='" + status + "'")
                .add("statusString='" + statusString + "'")
                .toString();
    }
}
