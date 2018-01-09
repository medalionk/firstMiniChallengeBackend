package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.ClientDTO;
import it.crazyones.easyexplore.application.service.impl.ClientServiceImpl;
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
@RequestMapping("/api/clients")
public class ClientRestController extends BaseRestController<ClientDTO> {
    private final ClientServiceImpl service;

    @Autowired
    public ClientRestController(ClientServiceImpl service) {
        super(ClientRestController.class, service);
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> getAll() throws DataAccessException {
        List<ClientDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> get(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.create(entity);
    }

    @PutMapping("/")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.delete(id);
    }
}