package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.GuideDTO;
import it.crazyones.easyexplore.application.service.impl.GuideServiceImpl;
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
@RequestMapping("/api/guides")
public class GuideRestController extends BaseRestController<GuideDTO> {
    private final GuideServiceImpl service;

    @Autowired
    public GuideRestController(GuideServiceImpl service) {
        super(GuideRestController.class, service);
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<GuideDTO>> getAll() throws DataAccessException {
        List<GuideDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideDTO> get(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<GuideDTO> create(@RequestBody GuideDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.create(entity);
    }

    @PutMapping("/")
    public ResponseEntity<GuideDTO> update(@RequestBody GuideDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.delete(id);
    }
}