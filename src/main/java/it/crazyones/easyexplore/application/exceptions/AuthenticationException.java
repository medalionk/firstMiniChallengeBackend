package it.crazyones.easyexplore.application.exceptions;

/**
 * Created by bilal90 on 9/10/2017.
 */
public class AuthenticationException extends Exception {
    public AuthenticationException() {
        this("Authentication error!");
    }

    public AuthenticationException(String message) {
        this(message, (Throwable)null);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
