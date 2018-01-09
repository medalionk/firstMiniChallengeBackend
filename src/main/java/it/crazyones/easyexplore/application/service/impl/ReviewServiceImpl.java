package it.crazyones.easyexplore.application.service.impl;

import it.crazyones.easyexplore.application.dto.ReviewDTO;
import it.crazyones.easyexplore.application.mapper.ReviewMapper;
import it.crazyones.easyexplore.application.service.BaseGenericService;
import it.crazyones.easyexplore.application.service.ReviewService;
import it.crazyones.easyexplore.domain.model.Review;
import it.crazyones.easyexplore.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl extends BaseGenericService<Review, ReviewDTO> implements ReviewService {
    @Autowired
    public ReviewServiceImpl(ReviewRepository repository, ReviewMapper mapper) {
        super(ReviewServiceImpl.class, repository, mapper);
    }

    @Override
    public ReviewDTO create(ReviewDTO entity) throws IllegalArgumentException, DataAccessException {
        if(entity == null) return null;
        return super.create(entity);
    }

    @Override
    public Optional<ReviewDTO> update(ReviewDTO dto) throws IllegalArgumentException, DataAccessException {
        return Optional.ofNullable(repository.findOne(dto.get_id())).map(x -> super.update(dto))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Feedback Id"));
    }

    @Override
    public List<ReviewDTO> saveAll(List<ReviewDTO> dtos) throws DataAccessException {
        if(dtos == null) return null;
        return super.saveAll(dtos);
    }
}
