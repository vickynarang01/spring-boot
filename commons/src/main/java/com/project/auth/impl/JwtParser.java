package com.project.auth.impl;

import com.project.exceptions.KeyNotFoundException;
import com.project.exceptions.TokenValidationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.util.Constants.*;
import static com.project.util.OauthConstants.*;

@Component
public class JwtParser {

    @Autowired
    private JwtLogicParser jwtLogicParser;

    @Value("${oauth.groupId.t0}")
    private String oauthGroupId0;

    @Value("${oauth.groupId.t1}")
    private String oauthGroupId1;

    @Value("${oauth.groupId.t2}")
    private String oauthGroupId2;

    public Map<String, Object> getDecodedContent(DecodedJWT decodedJWT, String userId, String token, String correlationId, String env) throws TokenValidationException {
        Map<String, Object> decodedMapContent = new HashMap<>();
        getIssuerKey(decodedMapContent, decodedJWT, correlationId);

        Map<String, Claim> claims = decodedJWT.getClaims();

        if(claims == null || claims.isEmpty()) {
            throw new KeyNotFoundException(JWS_NOT_FOUND_ERROR, correlationId);
        }

        getAppIdKey(decodedMapContent, decodedJWT, correlationId);

        getTenantKey(decodedMapContent, decodedJWT, correlationId);

        getUpnKey(decodedMapContent, decodedJWT, correlationId);

        if (!"dev".equals(env)) {

            jwtLogicParser.doUpnKeyComparison(decodedMapContent, userId, correlationId);

            getNameKey(decodedMapContent, decodedJWT, correlationId);

            getGroupsClaims(token, correlationId);

        }

        return decodedMapContent;

    }

    public String getBearerToken(HttpHeaders requestHeaders, String correlationId) {

        if (requestHeaders == null)
            throw new KeyNotFoundException(TOKEN_PREFIX + " token missing", correlationId);

        List<String> authHeaders = requestHeaders.get(HEADER_STRING);

        if (authHeaders == null || authHeaders.isEmpty())
            throw new KeyNotFoundException(TOKEN_PREFIX + " token missing", correlationId);

        return authHeaders.get(0).replace(TOKEN_PREFIX, "");
    }

    public List<String> getGroupsClaims(String token, String correlationId) throws TokenValidationException {

        List<String> groupClaims = new ArrayList<>();

        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            String payload = decodedJWT.getPayload();
            String decodedPayload = StringUtils.newStringUtf8(Base64.decodeBase64(payload));
            Map<String, Object> claims = new ObjectMapper().readValue(decodedPayload, Map.class);
            List<String> groups = (List<String>) claims.get("groups");

            if(groups != null){
                for(String group : groups){
                    if(group.equalsIgnoreCase(oauthGroupId0) ||
                            group.equalsIgnoreCase(oauthGroupId1) ||
                            group.equalsIgnoreCase(oauthGroupId2)){
                        groupClaims.add(group);
                    }
                }
            }

        } catch (Exception e) {
            throw new TokenValidationException("Failed to decode token - cannot extract group claims", correlationId);
        }

        if(groupClaims.isEmpty()) return null;

        return groupClaims;
    }

    public Map<String, Object> getTokenMetadata(String userId, String token, String correlationId, String env) throws TokenValidationException {
        DecodedJWT decodedJWT = JWT.decode(token);
        return getDecodedContent(decodedJWT, userId, token, correlationId, env);
    }

    public void getIssuerKey(Map<String, Object> decodedMapContent, DecodedJWT decodedJWT, String correlationId) {
        if (decodedJWT.getIssuer() != null) {
            decodedMapContent.put(ISSUER_KEY, decodedJWT.getIssuer());
        } else {
            throw new KeyNotFoundException(ISSUER_NOT_FOUND_ERROR, ISSUER_NOT_FOUND_CODE, ISSUER_NOT_FOUND_TYPE,
                    correlationId);
        }
    }

    public void getAppIdKey(Map<String, Object> decodedMapContent, DecodedJWT decodedJWT, String correlationId) {
        if (decodedJWT.getClaims().containsKey(APPID_KEY)) {
            decodedMapContent.put(APPID_KEY, decodedJWT.getClaim(APPID_KEY).asString());
        } else {
            throw new KeyNotFoundException(APP_ID_NOT_FOUND_ERROR, APP_ID_NOT_FOUND_CODE, APP_ID_NOT_FOUND_TYPE,
                    correlationId);
        }
    }

    public void getTenantKey(Map<String, Object> decodedMapContent, DecodedJWT decodedJWT, String correlationId) {
        if (decodedJWT.getClaims().containsKey(TENANT_KEY)) {
            decodedMapContent.put(TENANT_KEY, decodedJWT.getClaim(TENANT_KEY).asString());
        } else {
            throw new KeyNotFoundException(TENANT_ID_NOT_FOUND_ERROR, TENANT_ID_NOT_FOUND_CODE,
                    TENANT_ID_NOT_FOUND_TYPE, correlationId);
        }
    }

    public void getUpnKey(Map<String, Object> decodedMapContent, DecodedJWT decodedJWT, String correlationId) {
        if (decodedJWT.getClaims().containsKey(UPN_KEY)) {
            decodedMapContent.put(UPN_KEY, decodedJWT.getClaim(UPN_KEY).asString());
        } else {
            throw new KeyNotFoundException(UPN_NOT_FOUND_ERROR, UPN_NOT_FOUND_CODE, UPN_NOT_FOUND_TYPE,
                    correlationId);
        }
    }

    public void getNameKey(Map<String, Object> decodedMapContent, DecodedJWT decodedJWT, String correlationId) {
        if (decodedJWT.getClaims().containsKey(NAME)) {
            decodedMapContent.put(NAME, decodedJWT.getClaim(NAME).asString());
        } else {
            throw new KeyNotFoundException(NAME_NOT_FOUND_ERROR, NAME_NOT_FOUND_CODE,
                    NAME_NOT_FOUND_TYPE, correlationId);
        }
    }

    /**
     * Get Audience from the Token
     *
     * @param decodedJWT
     * @return
     */
    public List<String> getAudience(DecodedJWT decodedJWT, String correlationId) {
        if (decodedJWT.getAudience() != null && !decodedJWT.getAudience().isEmpty()) {
            return decodedJWT.getAudience();
        }
        throw new KeyNotFoundException(AUDIENCE_NOT_FOUND_ERROR, AUDIENCE_NOT_FOUND_CODE, AUDIENCE_NOT_FOUND_TYPE,
                correlationId);
    }

}

