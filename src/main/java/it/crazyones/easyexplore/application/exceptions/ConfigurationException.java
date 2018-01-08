package it.crazyones.easyexplore.application.exceptions;

/**
 * Created by bilal90 on 9/10/2017.
 */
public class ConfigurationException extends Exception {
    public ConfigurationException() {
        this("Configuration error!");
    }

    public ConfigurationException(String message) {
        this(message, (Throwable)null);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
