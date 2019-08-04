package HelperClasses;

import java.security.Key;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;

import Models.ServerResponse;
import Models.Users.LoginCredentialsRequest;

public class TokenClass {
	
	public static String CreateToken(LoginCredentialsRequest model, Key encryptionKey) {
		
		//Key Creation:
		/*
		byte[] KeyArray = ByteUtil.randomBytes(16);
		Key key = new AesKey(KeyArray);
		System.out.println("Key:" + KeyArray.toString());
		*/
		JsonWebEncryption jwe = new JsonWebEncryption();
		
		JwtClaims claims = new JwtClaims();
		claims.setClaim("email", model.getEmailOrPAN());
		claims.setClaim("password", model.getPassword());
		claims.setIssuedAtToNow();
		
		jwe.setPayload(claims.toJson());
		jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
		jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
		jwe.setKey(encryptionKey);
		
		String serializedJwe = "Failed to get Token!";
		try {
			 serializedJwe = jwe.getCompactSerialization();
			 
		} catch (JoseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serializedJwe;
		
	}
	
	public static ServerResponse DecodeToken(String token) {
		ServerResponse response = new ServerResponse();
		response.setResponseHexCode("FF");
		response.setResponseMsg("Failed to decode token.");
		//TODO: Create a connection to DB to Authenticate the user.
		
		
		return response;
	}
}
