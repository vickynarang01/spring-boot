package com.project.util;

public class Constants {

	public static final String APPLICATION_CODE = "1";
	public static final String APPLICATION_ERROR = "Error Processing Request";
	public static final String APPLICATION_TYPE = "Application";

	// Authorization key
	public static final String KEY_NOT_FOUND_CODE = "1100";
	public static final String KEY_NOT_FOUND_ERROR = "Authorization key missing";
	public static final String KEY_NOT_FOUND_TYPE = "Auth";

	// Token Verification key
	public static final String TOKEN_VERIFICATION_CODE = "1200";
	public static final String TOKEN_VERIFICATION_ERROR = "Token Verification failed";
	public static final String TOKEN_VERIFICATION_TYPE = "Token";

	// Subject Verification key
	public static final String TOKEN_SUBJECT_VERIFICATION_CODE = "1210";
	public static final String TOKEN_SUBJECT_VERIFICATION_ERROR = "Authorization Failed";
	public static final String TOKEN_SUBJECT_VERIFICATION_TYPE = "Token";

	// Subject Verification key
	public static final String TOKEN_TENANT_VERIFICATION_CODE = "1220";
	public static final String TOKEN_TENANT_VERIFICATION_ERROR = "Authorization Failed";
	public static final String TOKEN_TENANT_VERIFICATION_TYPE = "Token";

	// Issuer Verification key
	public static final String TOKEN_ISSUER_VERIFICATION_CODE = "1230";
	public static final String TOKEN_ISSUER_VERIFICATION_ERROR = "Authorization Failed";
	public static final String TOKEN_ISSUER_VERIFICATION_TYPE = "Token";

	// AppID Verification key
	public static final String TOKEN_APPID_VERIFICATION_CODE = "1240";
	public static final String TOKEN_APPID_VERIFICATION_ERROR = "Authorization Failed";
	public static final String TOKEN_APPID_VERIFICATION_TYPE = "Token";

	// AUDIENCE Verification key
	public static final String TOKEN_AUDIENCE_VERIFICATION_CODE = "1250";
	public static final String TOKEN_AUDIENCE_VERIFICATION_ERROR = "Authorization Failed";
	public static final String TOKEN_AUDIENCE_VERIFICATION_TYPE = "Token";

	// Token Validation key
	public static final String TOKEN_VALIDATION_CODE = "1300";
	public static final String TOKEN_VALIDATION_ISSUER_CODE = "1301";
	public static final String TOKEN_VALIDATION_SUBJECT_CODE = "1301";
	public static final String TOKEN_VALIDATION_EXPIRED_CODE = "1302";
	public static final String TOKEN_VALIDATION_UPN_CODE = "1303";
	public static final String TOKEN_VALIDATION_ERROR = "Authorization Failed";
	public static final String TOKEN_VALIDATION_ISSUER_ERROR = "Authorization Failed";
	public static final String TOKEN_VALIDATION_SUBJECT_ERROR = "Authorization Failed";
	public static final String TOKEN_VALIDATION_EXPIRED_ERROR = "Authorization Failed";
	public static final String TOKEN_VALIDATION_UPN_ERROR = "Authorization Failed";
	public static final String TOKEN_VALIDATION_TYPE = "Token";

	// JWKS URI key
	public static final String URI_NOT_FOUND_CODE = "1400";
	public static final String URI_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String URI_NOT_FOUND_TYPE = "JWKS";

	// JWKS Issue
	public static final String JWS_NOT_FOUND_CODE = "1500";
	public static final String JWS_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String JWS_NOT_FOUND_TYPE = "JWKS";

	// Audience Issue
	public static final String AUDIENCE_NOT_FOUND_CODE = "1510";
	public static final String AUDIENCE_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String AUDIENCE_NOT_FOUND_TYPE = "JWKS";

	// Subject Issue
	public static final String SUBJECT_NOT_FOUND_CODE = "1520";
	public static final String SUBJECT_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String SUBJECT_NOT_FOUND_TYPE = "JWKS";

	// Tenant ID Issue
	public static final String TENANT_ID_NOT_FOUND_CODE = "1530";
	public static final String TENANT_ID_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String TENANT_ID_NOT_FOUND_TYPE = "JWKS";

	// Tenant ID Issue
	public static final String NAME_NOT_FOUND_CODE = "1580";
	public static final String NAME_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String NAME_NOT_FOUND_TYPE = "JWKS";

	// Issuer Issue
	public static final String ISSUER_NOT_FOUND_CODE = "1540";
	public static final String ISSUER_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String ISSUER_NOT_FOUND_TYPE = "JWKS";

	// AppId Issue
	public static final String APP_ID_NOT_FOUND_CODE = "1550";
	public static final String APP_ID_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String APP_ID_NOT_FOUND_TYPE = "JWKS";

	// SecondLevelValidation Issue
	public static final String UPN_NOT_MATCH_CODE = "1570";
	public static final String UPN_NOT_MATCH_ERROR = "Authorization Failed";
	public static final String UPN_NOT_MATCH_TYPE = "JWKS";

	// UPN matching Issue
	public static final String UPN_NOT_FOUND_CODE = "1560";
	public static final String UPN_NOT_FOUND_ERROR = "Authorization Failed";
	public static final String UPN_NOT_FOUND_TYPE = "JWKS";

	// AppId Issue
	public static final String UPN_NOT_NULL_CODE = "1580";
	public static final String UPN_NOT_NULL_ERROR = "Authorization Failed";
	public static final String UPN_NOT_NULL_TYPE = "JWKS";

	public static final String CORRELATION_ID = "Correlation-Id";

	public static final String APPLICATION_UN_AUTHORIZED_CODE = "2200";
	public static final String APPLICATION_UN_AUTHORIZED_ERROR = "Un authorized access, Token validation failed";
	public static final String APPLICATION_UN_AUTHORIZED_TYPE = "Token Authorization - VIP Contest";

}
