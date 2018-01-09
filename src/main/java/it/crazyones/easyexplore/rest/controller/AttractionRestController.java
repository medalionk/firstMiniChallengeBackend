package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.AttractionDTO;
import it.crazyones.easyexplore.application.service.impl.AttractionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bilal90 on 9/6/2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/attractions")
public class AttractionRestController extends BaseRestController<AttractionDTO> {
    private final AttractionServiceImpl service;

    @Autowired
    public AttractionRestController(AttractionServiceImpl service) {
        super(AttractionRestController.class, service);
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<AttractionDTO>> getAll() throws DataAccessException {
        List<AttractionDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttractionDTO> get(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<AttractionDTO> create(@RequestBody AttractionDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.create(entity);
    }

    @PutMapping("/")
    public ResponseEntity<AttractionDTO> update(@RequestBody AttractionDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.delete(id);
    }
}