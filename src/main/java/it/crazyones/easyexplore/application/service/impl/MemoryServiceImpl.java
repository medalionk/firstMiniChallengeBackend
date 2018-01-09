package it.crazyones.easyexplore.application.service.impl;

import it.crazyones.easyexplore.application.dto.MemoryDTO;
import it.crazyones.easyexplore.application.mapper.MemoryMapper;
import it.crazyones.easyexplore.application.service.BaseGenericService;
import it.crazyones.easyexplore.application.service.MemoryService;
import it.crazyones.easyexplore.domain.model.Memory;
import it.crazyones.easyexplore.domain.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoryServiceImpl extends BaseGenericService<Memory, MemoryDTO> implements MemoryService {
    @Autowired
    public MemoryServiceImpl(MemoryRepository repository, MemoryMapper mapper) {
        super(MemoryServiceImpl.class, repository, mapper);
    }

    @Override
    public MemoryDTO create(MemoryDTO entity) throws IllegalArgumentException, DataAccessException {
        if(entity == null) return null;
        return super.create(entity);
    }

    @Override
    public Optional<MemoryDTO> update(MemoryDTO dto) throws IllegalArgumentException, DataAccessException {
        return Optional.ofNullable(repository.findOne(dto.get_id())).map(x -> super.update(dto))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Feedback Id"));
    }

    @Override
    public List<MemoryDTO> saveAll(List<MemoryDTO> dtos) throws DataAccessException {
        if(dtos == null) return null;
        return super.saveAll(dtos);
    }
}
