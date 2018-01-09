package it.crazyones.easyexplore.application.service.impl;

import it.crazyones.easyexplore.application.dto.GuideDTO;
import it.crazyones.easyexplore.application.mapper.GuideMapper;
import it.crazyones.easyexplore.application.service.BaseGenericService;
import it.crazyones.easyexplore.application.service.GuideService;
import it.crazyones.easyexplore.domain.model.Guide;
import it.crazyones.easyexplore.domain.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideServiceImpl extends BaseGenericService<Guide, GuideDTO> implements GuideService {
    @Autowired
    public GuideServiceImpl(GuideRepository repository, GuideMapper mapper) {
        super(GuideServiceImpl.class, repository, mapper);
    }

    @Override
    public GuideDTO create(GuideDTO entity) throws IllegalArgumentException, DataAccessException {
        if(entity == null) return null;
        return super.create(entity);
    }

    @Override
    public Optional<GuideDTO> update(GuideDTO dto) throws IllegalArgumentException, DataAccessException {
        return Optional.ofNullable(repository.findOne(dto.get_id())).map(x -> super.update(dto))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Feedback Id"));
    }

    @Override
    public List<GuideDTO> saveAll(List<GuideDTO> dtos) throws DataAccessException {
        if(dtos == null) return null;
        return super.saveAll(dtos);
    }
}
