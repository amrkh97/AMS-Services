package HelperClasses;

import org.jose4j.jwe.JsonWebEncryption;

import Models.ServerResponse;
import Models.Users.LoginCredentialsRequest;

public class TokenClass {
	
	public static JsonWebEncryption CreateToken(LoginCredentialsRequest model) {
		
		//TODO: Create a connection to DB to Authenticate the user.
		return null;
	}
	
	public static ServerResponse DecodeToken(String token) {
		ServerResponse response = new ServerResponse();
		response.setResponseHexCode("FF");
		response.setResponseMsg("Failed to decode token.");
		
		
		return response;
	}
}
