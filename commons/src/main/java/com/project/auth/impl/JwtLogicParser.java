package com.project.auth.impl;

import com.project.exceptions.KeyNotFoundException;
import com.project.exceptions.TokenVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.project.util.Constants.*;
import static com.project.util.OauthConstants.*;

@Component
public class JwtLogicParser {

    @Value("${oauth.issuer}")
    private String oauthIssuer;

    @Value("${oauth.app}")
    private String oauthApp;

    @Value("${oauth.directory}")
    private String oauthDirectory;

    @Value("${oauth.audience}")
    private String oauthAudience;

    public void doUpnKeyComparison(Map<String, Object> tokenDecodedMap, String userId, String correlationId) {
        String upn = (String) tokenDecodedMap.get(UPN_KEY);

        if(upn == null){
            throw new KeyNotFoundException(UPN_NOT_MATCH_ERROR, UPN_NOT_MATCH_CODE, UPN_NOT_MATCH_TYPE,
                    correlationId);
        }

        upn = upn.substring(0, upn.indexOf("@"));
        if (!upn.equalsIgnoreCase(userId)) {
            throw new TokenVerificationException(UPN_NOT_MATCH_ERROR, UPN_NOT_MATCH_CODE, UPN_NOT_MATCH_TYPE,
                    correlationId);
        }
    }

    public void doIssuerKeyComparision(Map<String, Object> tokenDecodedMap, String correlationId) {
        if (!tokenDecodedMap.containsKey(ISSUER_KEY) || !tokenDecodedMap.get(ISSUER_KEY).equals(oauthIssuer)) {
            throw new TokenVerificationException(TOKEN_ISSUER_VERIFICATION_ERROR, TOKEN_ISSUER_VERIFICATION_CODE,
                    TOKEN_ISSUER_VERIFICATION_TYPE, correlationId);
        }
    }

    public void doAppIdKeyComparision(Map<String, Object> tokenDecodedMap, String correlationId) {
        if (!tokenDecodedMap.containsKey(APPID_KEY) || !tokenDecodedMap.get(APPID_KEY).equals(oauthApp)) {
            throw new TokenVerificationException(TOKEN_APPID_VERIFICATION_ERROR, TOKEN_APPID_VERIFICATION_CODE,
                    TOKEN_APPID_VERIFICATION_TYPE, correlationId);
        }
    }

    public void doTenantKeyComparision(Map<String, Object> tokenDecodedMap, String correlationId) {
        if (!tokenDecodedMap.containsKey(TENANT_KEY) || !tokenDecodedMap.get(TENANT_KEY).equals(oauthDirectory)) {
            throw new TokenVerificationException(TOKEN_TENANT_VERIFICATION_ERROR, TOKEN_TENANT_VERIFICATION_CODE,
                    TOKEN_TENANT_VERIFICATION_TYPE, correlationId);
        }
    }

    public void doAudienceKeyComparision(List<String> audienceList, String correlationId) {
        if (audienceList != null && !audienceList.isEmpty()) {

            if (!audienceList.contains(AUDIENCE_GRAPH) && !audienceList.contains(oauthAudience)) {
                throw new TokenVerificationException(TOKEN_AUDIENCE_VERIFICATION_ERROR,
                        TOKEN_AUDIENCE_VERIFICATION_CODE, TOKEN_AUDIENCE_VERIFICATION_TYPE, correlationId);
            }
        } else {
            throw new KeyNotFoundException(AUDIENCE_NOT_FOUND_ERROR, AUDIENCE_NOT_FOUND_CODE, AUDIENCE_NOT_FOUND_ERROR,
                    correlationId);
        }
    }
    
}
