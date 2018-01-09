package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.MemoryDTO;
import it.crazyones.easyexplore.application.service.impl.MemoryServiceImpl;
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
@RequestMapping("/api/memories")
public class MemoryRestController extends BaseRestController<MemoryDTO> {
    private final MemoryServiceImpl service;

    @Autowired
    public MemoryRestController(MemoryServiceImpl service) {
        super(MemoryRestController.class, service);
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<MemoryDTO>> getAll() throws DataAccessException {
        List<MemoryDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoryDTO> get(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<MemoryDTO> create(@RequestBody MemoryDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.create(entity);
    }

    @PutMapping("/")
    public ResponseEntity<MemoryDTO> update(@RequestBody MemoryDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.delete(id);
    }
}