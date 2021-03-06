package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.exceptions.ServiceException;
import it.crazyones.easyexplore.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * Created by bilal90 on 9/9/2017.
 */
public class RestControllerExceptionFilter{
    protected final Logger LOGGER;

    protected <U extends RestControllerExceptionFilter> RestControllerExceptionFilter(Class<U> tClass) {
        this.LOGGER = LoggerFactory.getLogger(tClass);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        LOGGER.error("Invalid parameters: {}", ex.getMessage());
        return ResponseUtil.exceptionResponseBuilder(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String,String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        LOGGER.error(String.format("The resource was not found: %s", ex.getMessage()));
        return ResponseUtil.exceptionResponseBuilder(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(MalformedURLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String,String>> handleMalformedURLException(MalformedURLException ex) {
        LOGGER.error(String.format("Malformed URL: %s", ex.getMessage()));
        return ResponseUtil.exceptionResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String,String>> handleDataAccessException(DataAccessException ex) {
        LOGGER.error(String.format("Data access error: %s", ex.getMessage()));
        return ResponseUtil.exceptionResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String,String>> handleServiceException(ServiceException ex) {
        LOGGER.error(String.format("Service error: %s", ex.getMessage()));
        return ResponseUtil.exceptionResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }
}
