package it.crazyones.easyexplore.application.service;

import it.crazyones.easyexplore.application.dto.ResourceDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bilal90 on 9/30/2017.
 */
@Service
public interface GenericService<T extends ResourceDTO> {
    T create(T entity) throws IllegalArgumentException, DataAccessException;

    Optional<T> update(T entity) throws IllegalArgumentException, DataAccessException;

    Optional<T> findOne(String id) throws IllegalArgumentException, DataAccessException;

    List<T> findAll() throws DataAccessException;

    void delete(String id) throws IllegalArgumentException, DataAccessException;

    long count() throws DataAccessException;

    //@Async
    List<T> saveAll(List<T> entities) throws DataAccessException;
}
