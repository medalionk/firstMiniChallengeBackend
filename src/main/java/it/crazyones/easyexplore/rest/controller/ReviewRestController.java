package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.ReviewDTO;
import it.crazyones.easyexplore.application.service.impl.ReviewServiceImpl;
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
@RequestMapping("/api/reviews")
public class ReviewRestController extends BaseRestController<ReviewDTO> {
    private final ReviewServiceImpl service;

    @Autowired
    public ReviewRestController(ReviewServiceImpl service) {
        super(ReviewRestController.class, service);
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<ReviewDTO>> getAll() throws DataAccessException {
        List<ReviewDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> get(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<ReviewDTO> create(@RequestBody ReviewDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.create(entity);
    }

    @PutMapping("/")
    public ResponseEntity<ReviewDTO> update(@RequestBody ReviewDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.delete(id);
    }
}