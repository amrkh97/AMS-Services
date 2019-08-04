package yello.amo;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class RequestInterceptor implements ContainerRequestFilter {

	private static final String AUTHENTICATION_SCHEME = "Bearer";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Entered the filter!");
		// Get the Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Validate the Authorization header
		if (!isTokenBasedAuthentication(authorizationHeader)) {
			abortWithUnauthorized(requestContext);
			return;
		}

		// Extract the token from the Authorization header
		//System.out.println("Header: " + authorizationHeader);
		String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
		//System.out.println("Token:" + token);
		try {

			// Validate the token
			validateToken(token);

		} catch (Exception e) {
			abortWithUnauthorized(requestContext);
		}
	}

	private boolean isTokenBasedAuthentication(String authorizationHeader) {

		// Check if the Authorization header is valid
		// It must not be null and must be prefixed with "Bearer" plus a whitespace
		// Authentication scheme comparison must be case-insensitive
		
		 return authorizationHeader != null && authorizationHeader.toLowerCase()
		 .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
		
		/*
		 return authorizationHeader != null;
		*/
	}

	private void abortWithUnauthorized(ContainerRequestContext requestContext) {

		// Abort the filter chain with a 401 status code
		// The "WWW-Authenticate" is sent along with the response
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME).build());
	}

	private void validateToken(String token) throws Exception {
		// Check if it was issued by the server and if it's not expired
		// Throw an Exception if the token is invalid
		//TODO: Implement Checks here.
	}
}
