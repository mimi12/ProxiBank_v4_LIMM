package org.project.proxibank.security.exception;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 9124092556603481429L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
