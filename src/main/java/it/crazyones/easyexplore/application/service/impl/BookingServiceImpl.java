package it.crazyones.easyexplore.application.service.impl;

import it.crazyones.easyexplore.application.dto.BookingDTO;
import it.crazyones.easyexplore.application.mapper.BookingMapper;
import it.crazyones.easyexplore.application.service.BaseGenericService;
import it.crazyones.easyexplore.application.service.BookingService;
import it.crazyones.easyexplore.domain.model.Booking;
import it.crazyones.easyexplore.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl extends BaseGenericService<Booking, BookingDTO> implements BookingService {
    @Autowired
    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper) {
        super(BookingServiceImpl.class, repository, mapper);
    }

    @Override
    public BookingDTO create(BookingDTO entity) throws IllegalArgumentException, DataAccessException {
        if(entity == null) return null;
        return super.create(entity);
    }

    @Override
    public Optional<BookingDTO> update(BookingDTO dto) throws IllegalArgumentException, DataAccessException {
        return Optional.ofNullable(repository.findOne(dto.get_id())).map(x -> super.update(dto))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Feedback Id"));
    }

    @Override
    public List<BookingDTO> saveAll(List<BookingDTO> dtos) throws DataAccessException {
        if(dtos == null) return null;
        return super.saveAll(dtos);
    }
}
