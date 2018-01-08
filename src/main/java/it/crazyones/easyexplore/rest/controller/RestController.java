package it.crazyones.easyexplore.rest.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by bilal90 on 9/30/2017.
 */
public interface RestController<T> {
    ResponseEntity<List<T>> getAll() throws DataAccessException;

    ResponseEntity<T> get(String id) throws IllegalArgumentException, DataAccessException,
            ResourceNotFoundException;

    ResponseEntity<T> create(T entity) throws IllegalArgumentException, DataAccessException;

    ResponseEntity<T> update(T entity) throws IllegalArgumentException, DataAccessException;

    ResponseEntity<Void> delete(String id) throws IllegalArgumentException, DataAccessException,
            ResourceNotFoundException;
}
