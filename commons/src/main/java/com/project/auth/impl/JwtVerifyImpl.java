package com.project.auth.impl;

import com.project.auth.api.IOauth;
import com.project.exceptions.TokenValidationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.project.util.Constants.TOKEN_VALIDATION_SUBJECT_ERROR;

@Component
public class JwtVerifyImpl implements IOauth {

	@Value("${oauth.tenant}")
	private String oauthTenant;

	@Value("${oauth.openurl}")
	private String oauthOpenUrl;

	@Value("${oauth.groupId}")
	private String oauthGroupId;

	@Value("${oauth.groupId.t1}")
	private String oauthGroupId1;

	@Value("${oauth.groupId.t2}")
	private String oauthGroupId2;

	@Value("${env}")
	private String env;

	@Autowired
	private JwtParser jwtParser;

	@Autowired
	private JwtLogicParser jwtLogicParser;

	@Override
	public boolean validate(String userId, HttpHeaders requestHeaders, String correlationId) throws TokenValidationException {
		String token = jwtParser.getBearerToken(requestHeaders, correlationId);

		DecodedJWT decodedJWT;

		try {
			decodedJWT = JWT.decode(token);
		} catch (JWTDecodeException ex) {
			throw new TokenValidationException(TOKEN_VALIDATION_SUBJECT_ERROR, correlationId);
		}

		Map<String, Object> decodedMap = jwtParser.getDecodedContent(decodedJWT, userId, token, correlationId, env);

		List<String> audienceList = jwtParser.getAudience(decodedJWT, correlationId);

		jwtLogicParser.doIssuerKeyComparision(decodedMap, correlationId);
		jwtLogicParser.doAppIdKeyComparision(decodedMap, correlationId);
		jwtLogicParser.doTenantKeyComparision(decodedMap, correlationId);
		jwtLogicParser.doAudienceKeyComparision(audienceList, correlationId);

		return true;
	}

	public String getBearerToken(HttpHeaders requestHeaders, String correlationId) {
		return jwtParser.getBearerToken(requestHeaders, correlationId);
	}

	public List<String> getGroupsClaims(String token, String correlationId) throws TokenValidationException {
		return jwtParser.getGroupsClaims(token, correlationId);
	}

	public Map<String, Object> getTokenMetadata(String userId, String token, String correlationId) throws TokenValidationException {
		return jwtParser.getTokenMetadata(userId, token, correlationId, env);
	}

}
