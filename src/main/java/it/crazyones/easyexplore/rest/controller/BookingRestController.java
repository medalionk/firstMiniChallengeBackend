package it.crazyones.easyexplore.rest.controller;

import it.crazyones.easyexplore.application.dto.BookingDTO;
import it.crazyones.easyexplore.application.service.impl.BookingServiceImpl;
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
@RequestMapping("/api/bookings")
public class BookingRestController extends BaseRestController<BookingDTO> {
    private final BookingServiceImpl service;

    @Autowired
    public BookingRestController(BookingServiceImpl service) {
        super(BookingRestController.class, service);
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookingDTO>> getAll() throws DataAccessException {
        List<BookingDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> get(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<BookingDTO> create(@RequestBody BookingDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.create(entity);
    }

    @PutMapping("/")
    public ResponseEntity<BookingDTO> update(@RequestBody BookingDTO entity)
            throws IllegalArgumentException, DataAccessException {
        return super.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id)
            throws IllegalArgumentException, DataAccessException, ResourceNotFoundException {
        return super.delete(id);
    }
}