package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.ResourceDTO;
import it.crazyones.easyexplore.application.service.GenericService;
import it.crazyones.easyexplore.util.ResponseUtil;
import it.crazyones.easyexplore.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by bilal90 on 9/9/2017.
 */
public class BaseRestController<T extends ResourceDTO> extends RestControllerExceptionFilter implements RestController<T>{
    protected final Logger LOGGER;
    protected final GenericService<T> service;

    protected <U extends BaseRestController>BaseRestController(Class<U> tClass, GenericService<T> service) {
        super(tClass);
        this.LOGGER = LoggerFactory.getLogger(tClass);
        this.service = service;
    }

    @Override
    public ResponseEntity<List<T>> getAll() throws DataAccessException {
        LOGGER.info("Get all entities");
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> get(String id) throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        LOGGER.info("Get all entity with id: '{}'", id);
        ValidationUtil.ValidateIdentity(id);
        return ResponseUtil.wrapOrNotFound(service.findOne(id));
    }

    @Override
    public ResponseEntity<T> create(T entity) throws IllegalArgumentException, DataAccessException {
        LOGGER.info("Persist entity {} in db", entity);
        ValidationUtil.ValidateEntity(entity);
        return new ResponseEntity<>(service.create(entity), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<T> update(T entity) throws IllegalArgumentException, DataAccessException {
        LOGGER.info("Update '{}' entity", entity);
        ValidationUtil.ValidateEntity(entity);
        return ResponseUtil.wrapOrNotFound(service.update(entity));
    }

    @Override
    public ResponseEntity<Void> delete(String id) throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        ValidationUtil.ValidateIdentity(id);
        LOGGER.info("Delete entity with id: '{}'", id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
