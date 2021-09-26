package com.project.stubs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractRequest implements GenericRequest {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("impersonationUserId")
    private String impersonationUserId;

    @JsonProperty("onBehalfOf")
    private String onBehalfOf;

    @JsonProperty("isOfficeAdmin")
    private boolean isOfficeAdmin;

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("impersonationUserId")
    public String getImpersonationUserId() {
        return impersonationUserId;
    }

    @JsonProperty("impersonationUserId")
    public void setImpersonationUserId(String impersonationUserId) {
        this.impersonationUserId = impersonationUserId;
    }

    @JsonProperty("onBehalfOf")
    public String getOnBehalfOf() {
        return onBehalfOf;
    }

    @JsonProperty("onBehalfOf")
    public void setOnBehalfOf(String onBehalfOf) {
        this.onBehalfOf = onBehalfOf;
    }

    @JsonProperty("isOfficeAdmin")
    public boolean isOfficeAdmin() {
        return isOfficeAdmin;
    }

    @JsonProperty("isOfficeAdmin")
    public void setIsOfficeAdmin(boolean isOfficeAdmin) {
        this.isOfficeAdmin = isOfficeAdmin;
    }
}
