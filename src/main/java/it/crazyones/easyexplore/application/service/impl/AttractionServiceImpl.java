package it.crazyones.easyexplore.application.service.impl;

import it.crazyones.easyexplore.application.dto.AttractionDTO;
import it.crazyones.easyexplore.application.mapper.AttractionMapper;
import it.crazyones.easyexplore.application.service.AttractionService;
import it.crazyones.easyexplore.application.service.BaseGenericService;
import it.crazyones.easyexplore.domain.model.Attraction;
import it.crazyones.easyexplore.domain.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionServiceImpl extends BaseGenericService<Attraction, AttractionDTO> implements AttractionService {
    @Autowired
    public AttractionServiceImpl(AttractionRepository repository, AttractionMapper mapper) {
        super(AttractionServiceImpl.class, repository, mapper);
    }

    @Override
    public AttractionDTO create(AttractionDTO entity) throws IllegalArgumentException, DataAccessException {
        if(entity == null) return null;
        return super.create(entity);
    }

    @Override
    public Optional<AttractionDTO> update(AttractionDTO dto) throws IllegalArgumentException, DataAccessException {
        return Optional.ofNullable(repository.findOne(dto.get_id())).map(x -> super.update(dto))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Feedback Id"));
    }

    @Override
    public List<AttractionDTO> saveAll(List<AttractionDTO> dtos) throws DataAccessException {
        if(dtos == null) return null;
        return super.saveAll(dtos);
    }
}
