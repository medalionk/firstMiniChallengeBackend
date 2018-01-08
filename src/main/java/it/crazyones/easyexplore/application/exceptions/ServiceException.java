package it.crazyones.easyexplore.application.exceptions;

/**
 * Created by bilal90 on 9/10/2017.
 */
public class ServiceException extends Exception {
    public ServiceException() {
        this("Service error not found!");
    }

    public ServiceException(String message) {
        this(message, (Throwable)null);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
